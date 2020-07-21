package com.Message.Message.controller;

import java.util.List;

import com.Message.Message.dtos.*;
import com.Message.Message.model.Message;
import com.Message.Message.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;

@RestController
// @RequestMapping(value = "inbox")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    RestTemplate restTemplate;

    // vraca sve korisnike sa kojima ima razgovor
    @GetMapping(value = "/allUsers")
    public ResponseEntity<List<UserDTO>> getInboxUsers() {

        List<UserDTO> allUsers = restTemplate
                .exchange("http://auth/getAll", HttpMethod.GET, null, new ParameterizedTypeReference<List<UserDTO>>() {
                }).getBody();

        System.out.println("Broj usera koje vrati sa auth="+allUsers.size());

        List<UserDTO> users = messageService.getInboxUsers(allUsers);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/allMessagableUsers")
    public ResponseEntity<List<UserDTO>> getAllMessagableUsers() {
        List<UserDTO> allUsers = restTemplate
                .exchange("http://auth/getAll", HttpMethod.GET, null, new ParameterizedTypeReference<List<UserDTO>>() {
                }).getBody();

        List<BookingRequestDTO> allBookings = restTemplate.exchange("http://book/getAllBookings", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<BookingRequestDTO>>() {
                }).getBody();

        List<UserDTO> users = messageService.getAllMessagableUsers(allBookings, allUsers);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(value = "/getConversation")
    public ResponseEntity<List<MessageFrontDTO>> getConversation(@RequestBody Long id) {
        List<UserDTO> allUsers = restTemplate
                .exchange("http://auth/getAll", HttpMethod.GET, null, new ParameterizedTypeReference<List<UserDTO>>() {
                }).getBody();
        List<MessageFrontDTO> messages = messageService.getConversation(id, allUsers);

        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> newMessage(@RequestBody MessageDTO messageDTO) {

        // MORAMO DOBITI PRVO SVE USERE
        List<UserDTO> allUsers = restTemplate
                .exchange("http://auth/getAll", HttpMethod.GET, null, new ParameterizedTypeReference<List<UserDTO>>() {
                }).getBody();
        if (messageService.newMessage(messageDTO, allUsers) == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }

}