package com.Booking.Booking.dtos;

import java.time.LocalDateTime;

public class ReservationDTO {
    private Long advertisementId;
    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;

    public ReservationDTO() {

    }

    public ReservationDTO(Long advertisementId, LocalDateTime timeFrom, LocalDateTime timeTo) {
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.advertisementId = advertisementId;
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

}