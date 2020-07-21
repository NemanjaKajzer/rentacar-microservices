package com.Booking.Booking.dtos;

import java.time.LocalDateTime;




public class ItemInCartDTO  {

    private Long id;

    private Long advertisementPostedById;
    
    private Long advertisementId;

    private LocalDateTime timeFrom;

    private LocalDateTime timeTo;

    private boolean owner;

    private boolean together;


    public ItemInCartDTO(){
        
    }

    public ItemInCartDTO( Long adv,Long advPostedBy, LocalDateTime from, LocalDateTime to) {
        
        this.advertisementId= adv;
        this.advertisementPostedById=advPostedBy;
        this.timeFrom=from;
        this.timeTo=to;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isOwner() {
        return this.owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public boolean isTogether() {
        return this.together;
    }

    public void setTogether(boolean together) {
        this.together = together;
    }

    public Long getAdvertisementPostedById() {
        return advertisementPostedById;
    }

    public void setAdvertisementPostedById(Long advertisementPostedById) {
        this.advertisementPostedById = advertisementPostedById;
    }


}