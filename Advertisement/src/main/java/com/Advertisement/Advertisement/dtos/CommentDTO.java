package com.Advertisement.Advertisement.dtos;

public class CommentDTO {

    private String message;

    private Double grade;

    private Long ad;

    private Long userId;

    public CommentDTO(String message, Double grade, Long ad, Long userId) {
        this.message = message;
        this.grade = grade;
        this.ad = ad;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Long getAd() {
        return ad;
    }

    public void setAd(Long ad) {
        this.ad = ad;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
