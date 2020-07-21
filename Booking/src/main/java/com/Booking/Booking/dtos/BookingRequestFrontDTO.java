package com.Booking.Booking.dtos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.Booking.Booking.enums.RequestStates;


public class BookingRequestFrontDTO {

  
    private Long id;

    // onaj ko je objavio
    private Long userForId;

    // onaj ko podnosi
    private Long userToId;

    private RequestStates stateOfRequest;

    private AdvertisementCreationDTO advertisement;

    private Long groupId;

    private boolean together;

    private LocalDateTime timeFrom;

    private LocalDateTime timeTo;

    public BookingRequestFrontDTO(Long id,Long userForId, Long userToId, Long groupId, RequestStates stateOfRequest,
    AdvertisementCreationDTO advertisement, boolean together, LocalDateTime timeFrom, LocalDateTime timeTo) {
        this.id=id;
        this.userForId = userForId;
        this.userToId = userToId;
        this.groupId = groupId;
        this.stateOfRequest = stateOfRequest;
        this.advertisement = advertisement;
        this.together = together;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public BookingRequestFrontDTO() {
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

    public void setUserForId(Long userId) {
        this.userForId = userId;
    }

    public RequestStates getStateOfRequest() {
        return stateOfRequest;
    }

    public void setStateOfRequest(RequestStates stateOfRequest) {
        this.stateOfRequest = stateOfRequest;
    }

    public AdvertisementCreationDTO getAdvertisement() {
        return this.advertisement;
    }

    public void setAdvertisement(AdvertisementCreationDTO advertisement) {
        this.advertisement = advertisement;
    }

    public boolean isTogether() {
        return this.together;
    }

    public void setTogether(boolean together) {
        this.together = together;
    }

    public Long getUserToId() {
        return this.userToId;
    }

    public void setUserToId(Long userToId) {
        this.userToId = userToId;
    }

    public Long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public LocalDateTime getTimeFrom() {
        return this.timeFrom;
    }

    public void setTimeFrom(LocalDateTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalDateTime getTimeTo() {
        return this.timeTo;
    }

    public void setTimeTo(LocalDateTime timeTo) {
        this.timeTo = timeTo;
    }

}
