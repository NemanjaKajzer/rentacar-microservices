package com.Message.Message.dtos;

import com.Message.Message.enums.RequestStates;

public class BookingRequestDTO {
    
    private Long id;

    //onaj ko je objavio
    private Long userForId;

    //onaj ko podnosi
    private Long userToId;

    private RequestStates stateOfRequest;


    public BookingRequestDTO(Long id, Long userForId,Long userToId, RequestStates stateOfRequest  ){

        this.id=id;
        this.userForId=userForId;
        this.userToId=userToId;
        this.stateOfRequest=stateOfRequest;


    }

    public BookingRequestDTO(){

        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserForId() {
        return userForId;
    }

    public void setUserForId(Long userForId) {
        this.userForId = userForId;
    }

    public Long getUserToId() {
        return userToId;
    }

    public void setUserToId(Long userToId) {
        this.userToId = userToId;
    }

    public RequestStates getStateOfRequest() {
        return stateOfRequest;
    }

    public void setStateOfRequest(RequestStates stateOfRequest) {
        this.stateOfRequest = stateOfRequest;
    }


}