package com.Message.Message.dtos;
import javax.persistence.*;
public class MessageDTO {

    public String text;
    public String email;
    public Long receiverID;

    public String getText()
    {
        return this.text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Long getReceiverID(){
        return this.receiverID;
    }

    public void setReceiverID(Long receiverID){
        this.receiverID = receiverID;
    }

    public MessageDTO()
    {

    }

    public MessageDTO(String text, String email)
    {
        this.text = text;
        this.email = email;
    }   

    public MessageDTO(String text, Long receiverID)
    {
        this.text = text;
        this.receiverID = receiverID;
    }   
    
}