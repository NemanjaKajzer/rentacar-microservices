package com.Message.Message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.core.ParameterizedTypeReference;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

import javax.servlet.http.HttpSession;


import com.Message.Message.dtos.*;
import com.Message.Message.enums.RequestStates;
import com.Message.Message.model.*;
import com.Message.Message.repository.*;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<MessageFrontDTO> getConversation(Long id, List<UserDTO> allUsers) {
        List<Message> allMessages = messageRepository.findAll();
        List<Message> filteredMessages = new ArrayList<Message>();
        List<MessageFrontDTO> messageDTOs = new ArrayList<MessageFrontDTO>();

        for (Message message : allMessages) {
            if (message.getSenderId() == id && message.getReceiverId() == getLogedUserId()) {
                filteredMessages.add(message);
            }

            if (message.getSenderId() == getLogedUserId() && message.getReceiverId() == id) {
                filteredMessages.add(message);
            }
        }

        Collections.sort(filteredMessages, new Comparator<Message>() {
            public int compare(Message m1, Message m2) {
                return m1.getTimeSent().compareTo(m2.getTimeSent());
            }
        });


        for(Message message : filteredMessages){
            messageDTOs.add(new MessageFrontDTO(message, allUsers));
        }
        return messageDTOs;
    }

    public int newMessage(MessageDTO messageDTO, List<UserDTO> allUsers) {

        System.out.println(messageDTO.email + " " + messageDTO.text);

        if (getLogedUserId() == null) {
            return 0;
        }

        Message message = new Message();
        message.setSenderId(getLogedUserId());

        if (messageDTO.getEmail() != null && !messageDTO.getEmail().equals("")) {
            for (UserDTO user : allUsers) {
                if (user.getLoginInfo().getEmail().equals(messageDTO.getEmail())) {

                    message.setReceiverId(user.getId());
                }
            }
        } else {
            for (UserDTO user : allUsers) {
                if (user.getId().equals(messageDTO.getReceiverID())) {

                    message.setReceiverId(user.getId());
                }
            }
        }

        message.setText(messageDTO.text);
        message.setTimeSent(LocalDateTime.now());

        messageRepository.save(message);

        return 1;
    }

    public List<UserDTO> getInboxUsers(List<UserDTO> allUsers) {
        List<Message> allMessages = messageRepository.findAll();
        List<Message> filteredMessages = new ArrayList<Message>();
        List<UserDTO> users = new ArrayList<UserDTO>();
        Long loggedID = getLogedUserId();

        for (Message message : allMessages) {
            if (message.getReceiverId() == loggedID) {
                filteredMessages.add(message);
            }

            if (message.getSenderId() == loggedID) {
                filteredMessages.add(message);
            }
        }

        System.out.println("FilterMessages suuuuuuuuu prvi for="+filteredMessages.size());

  //      System.out.println("USER======"+users.get(0).getId()+"EMAIL"+users.get(0).getLoginInfo().getEmail());
        
        for (Message message : filteredMessages) {
            if (!users.contains(getUserDTOById(allUsers, message.getReceiverId())) && message.getReceiverId() != loggedID) {
                users.add(getUserDTOById(allUsers, message.getReceiverId()));
            }

            if (!users.contains(getUserDTOById(allUsers, message.getSenderId())) && message.getSenderId() != loggedID) {
                users.add(getUserDTOById(allUsers, message.getSenderId()));
            }
        }

        System.out.println("Posle drugog fora==="+users.size());

        // return users; OVAKO KASNIJE
        return users;
    }

    public List<UserDTO> getAllMessagableUsers(List<BookingRequestDTO> bookingRequests, List<UserDTO> allUsers) {
        List<UserDTO> messagableUsers = new ArrayList<UserDTO>();
        Long loggedID = getLogedUserId();

        for (BookingRequestDTO bookingRequest : bookingRequests) {
            if (bookingRequest.getUserForId().equals(loggedID)
                    && (bookingRequest.getStateOfRequest() == RequestStates.RESERVED || bookingRequest.getStateOfRequest() == RequestStates.PAID)) {
                if (!messagableUsers.contains(getUserDTOById(allUsers, bookingRequest.getUserToId()))) {
                    messagableUsers.add(getUserDTOById(allUsers, bookingRequest.getUserToId()));
                }
            }

            if (bookingRequest.getUserToId().equals(loggedID)
                    && (bookingRequest.getStateOfRequest() == RequestStates.RESERVED 
                            || bookingRequest.getStateOfRequest() == RequestStates.PAID)) {
                if (!messagableUsers.contains(getUserDTOById(allUsers, bookingRequest.getUserForId()))) {
                    messagableUsers.add(getUserDTOById(allUsers, bookingRequest.getUserForId()));
                }
            }
        }

        return messagableUsers;
    }

    public UserDTO getUserDTOById(List<UserDTO> allUsers, Long userId) {
        UserDTO user = new UserDTO();
        for (UserDTO userDTO : allUsers) {
            if (userDTO.getId().equals(userId)) {
                user = userDTO;
                break;
            }
        }
        return user;
    }

    private Long getLogedUserId() {
        Long id = restTemplate
                .exchange("http://auth/getUserId", HttpMethod.GET, null, new ParameterizedTypeReference<Long>() {
                }).getBody();

        System.out.println("Nasao je id=" + id);

        return id;
    }

}