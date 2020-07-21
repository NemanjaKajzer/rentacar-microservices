package com.Message.Message.model;

    import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long senderId;

    private Long receiverId;

    private String text;

    private LocalDateTime timeSent;

    public Long getSenderId() {
        return this.senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReceiverId() {
        return this.receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
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

    public Message() {

    }

    public Message(Long senderId, Long receiverId, String text, LocalDateTime timeSent) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.text = text;
        this.timeSent = timeSent;
    }

}