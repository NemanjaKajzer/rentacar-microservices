package com.Advertisement.Advertisement.model;

import javax.persistence.*;

@Entity
public class CarReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "travelled")
    private int travelled;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "advertisement_id")
    private Advertisement ad;

    public CarReport(int travelled, String comment, Advertisement ad) {
        this.travelled = travelled;
        this.comment = comment;
        this.ad = ad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Advertisement getAd() {
        return ad;
    }

    public void setAd(Advertisement ad) {
        this.ad = ad;
    }
}
