package com.Booking.Booking.dtos;

import java.time.LocalDateTime;




public class ItemInCartFrontDTO  {

    private Long id;

    private AdvertisementCreationDTO advertisementCreationDTO;

    private LocalDateTime timeFrom;

    private LocalDateTime timeTo;

    private boolean owner;

    private boolean together;


    public ItemInCartFrontDTO(){
        
    }

    public ItemInCartFrontDTO(Long id, LocalDateTime from, LocalDateTime to, AdvertisementCreationDTO advertisementCreationDTO ) {
        this.id=id;
        this.advertisementCreationDTO=advertisementCreationDTO;
        this.timeFrom=from;
        this.timeTo=to;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AdvertisementCreationDTO getAdvertisementCreationDTO() {
        return advertisementCreationDTO;
    }

    public void setAdvertisementCreationDTO(AdvertisementCreationDTO advertisementCreationDTO) {
        this.advertisementCreationDTO = advertisementCreationDTO;
    }


}