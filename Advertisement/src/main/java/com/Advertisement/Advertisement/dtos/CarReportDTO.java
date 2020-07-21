package com.Advertisement.Advertisement.dtos;

public class CarReportDTO {

    private Long carId;
    private int travelled;
    private String comment;

    public CarReportDTO(Long carId, int travelled, String comment) {
        this.carId = carId;
        this.travelled = travelled;
        this.comment = comment;
    }

    public int getTravelled() {
        return travelled;
    }

    public void setTravelled(int travelled) {
        this.travelled = travelled;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
}
