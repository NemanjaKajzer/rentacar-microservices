package com.Advertisement.Advertisement.dtos;

public class EndUserNumberOfAdsDTO {
    private Long id;
    private int numberOfAds;
    private boolean blocked;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getNumberOfAds() {
        return this.numberOfAds;
    }

    public void setNumberOfAds(int numberOfAds) {
        this.numberOfAds = numberOfAds;
    }

    public EndUserNumberOfAdsDTO() {
    }

    public EndUserNumberOfAdsDTO(Long id, int numberOfAds, boolean blocked) {
        this.id = id;
        this.numberOfAds = numberOfAds;
        this.blocked = blocked;
    }



}