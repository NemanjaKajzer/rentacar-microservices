package com.Advertisement.Advertisement.model;

import javax.persistence.*;
//import javax.validation.constraints.Size;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
   // @Size(min=1, max=5)
    private double value;

    @ManyToOne
    private Advertisement ad;

    public Grade() {
    }

    public Grade(double value, Advertisement ad) {
        this.value = value;
        this.ad = ad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Advertisement getAd() {
        return ad;
    }

    public void setAd(Advertisement ad) {
        this.ad = ad;
    }
}
