package com.Message.Message.dtos;
import java.time.LocalDateTime;
import java.util.List;

import com.Message.Message.model.*;
import com.Message.Message.dtos.*;

public class MessageFrontDTO {
   
    private Long id;
    private UserDTO sender;
    private UserDTO receiver;
    private String text;
    private LocalDateTime timeSent;

    
    public MessageFrontDTO(Message message, List<UserDTO> all) {
        for (UserDTO user : all) {
            if (user.getId().equals(message.getReceiverId())) {
                this.receiver = user;
            } else if (user.getId().equals(message.getSenderId())) {

                this.sender = user;
            }
        }
        this.id = message.getId();
        this.text = message.getText();
        this.timeSent = message.getTimeSent();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getSender() {
        return this.sender;
    }

    public void setSender(UserDTO sender) {
        this.sender = sender;
    }

    public UserDTO getReceiver() {
        return this.receiver;
    }

    public void setReceiver(UserDTO receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimeSent() {
        return this.timeSent;
    }

    public void setTimeSent(LocalDateTime timeSent) {
        this.timeSent = timeSent;
    }

    public MessageFrontDTO() {
    }


}