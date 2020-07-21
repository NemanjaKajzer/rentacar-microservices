package com.Booking.Booking.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ItemInCart {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

   
    private Long userId;
    
    private Long advertisementPostedById;

    private Long advertisementId;

    private LocalDateTime timeFrom;

    private LocalDateTime timeTo;

   

    public ItemInCart(){
        
    }

    public ItemInCart( Long userId,Long advertisementPostedById, Long advertisementId, LocalDateTime from, LocalDateTime to) {
        this.userId =userId;
        this.advertisementPostedById=advertisementPostedById;
        this.advertisementId= advertisementId;
        this.timeFrom=from;
        this.timeTo=to;
    }

    public ItemInCart( Long advertisementId, LocalDateTime from, LocalDateTime to) {
        this.advertisementId= advertisementId;
        this.timeFrom=from;
        this.timeTo=to;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAdvertisementId() {
        return this.advertisementId;
    }

    public void setAdvertisementId(Long advertisementId) {
        this.advertisementId = advertisementId;
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

    public Long getAdvertisementPostedById() {
        return advertisementPostedById;
    }

    public void setAdvertisementPostedById(Long advertisementPostedById) {
        this.advertisementPostedById = advertisementPostedById;
    }


   

}