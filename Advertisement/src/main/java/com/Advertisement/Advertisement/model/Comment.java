package com.Advertisement.Advertisement.model;



import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String value;

    @Column
    private Date date;

    @ManyToOne
    private Advertisement ad;

    
    private Long endUserID;

    @Column
    private Double grade;

    @OneToOne
    private Reply reply;

    @Column
    private Boolean approved;

    @Column
    private Boolean deleted;

    public Comment(){

    }

    public Comment(String value, Date date, Advertisement ad) {
        this.value = value;
        this.date = date;
        this.ad = ad;
    }

    public Comment(String value, Date date, Advertisement ad, Long endUserID) {
        this.value = value;
        this.date = date;
        this.ad = ad;
        this.endUserID = endUserID;
    }

    public Comment(String value, Date date, Advertisement ad, Long endUserID, Double grade) {
        this.value = value;
        this.date = date;
        this.ad = ad;
        this.endUserID = endUserID;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Advertisement getAd() {
        return ad;
    }

    public void setAd(Advertisement ad) {
        this.ad = ad;
    }

    public Long getEndUserID() {
        return endUserID;
    }

    public void setEndUserID(Long endUserID) {
        this.endUserID = endUserID;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public Boolean getApproved() {
        return this.approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", date=" + date +
                ", ad=" + ad +
                ", endUser=" + endUserID +
                ", grade=" + grade +
                '}';
    }
}
