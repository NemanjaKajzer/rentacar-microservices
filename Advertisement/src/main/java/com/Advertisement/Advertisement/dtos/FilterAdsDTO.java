package com.Advertisement.Advertisement.dtos;

import com.Advertisement.Advertisement.model.*;

import java.time.LocalDateTime;

public class FilterAdsDTO {

    private String model;

    private String brand;

    private String fuelType;

    private String transmissionType;

    private String carClass;

    private int travelledFrom;

    private int travelledTo;

    private double priceFrom;

    private double priceTo;

    private int carSeats;

    private LocalDateTime timeFrom;

    private LocalDateTime timeTo;

    public FilterAdsDTO() {

    }

    public FilterAdsDTO(String brand, String model, String fuelType, String transmissionType, String carClass,
            int travelledFrom, int travelledTo, double priceFrom, double priceTo, int carSeats, LocalDateTime timeFrom,
            LocalDateTime timeTo) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.carClass = carClass;
        this.travelledFrom = travelledFrom;
        this.travelledTo = travelledTo;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.carSeats = carSeats;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public int getTravelledFrom() {
        return travelledFrom;
    }

    public void setTravelledFrom(int travelledFrom) {
        this.travelledFrom = travelledFrom;
    }

    public int getTravelledTo() {
        return travelledTo;
    }

    public void setTravelledTo(int travelledTo) {
        this.travelledTo = travelledTo;
    }

    public double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(double priceTo) {
        this.priceTo = priceTo;
    }

    public int getCarSeats() {
        return carSeats;
    }

    public void setCarSeats(int carSeats) {
        this.carSeats = carSeats;
    }

    public LocalDateTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalDateTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalDateTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalDateTime timeTo) {
        this.timeTo = timeTo;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
