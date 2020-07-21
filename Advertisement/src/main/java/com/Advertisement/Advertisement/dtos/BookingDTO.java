package com.Advertisement.Advertisement.dtos;

import java.time.LocalDateTime;

public class BookingDTO {

    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;
    private Long advertisementId;

    public BookingDTO(LocalDateTime timeFrom, LocalDateTime timeTo, Long advertisementId) {
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.advertisementId = advertisementId;
    }

    public BookingDTO() {
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

    public Long getAdvertisementId() {
        return this.advertisementId;
    }

    public void setAdvertisementId(Long advertisementId) {
        this.advertisementId = advertisementId;
    }

}