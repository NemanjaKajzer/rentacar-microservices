package com.Advertisement.Advertisement.dtos;

import java.util.Date;

public class CommentPreviewDTO {

    private Long id;

    private String comment;

    private String userMail;

    private Double grade;

    private Date date;

    private ReplyDTO replyDTO;

    public CommentPreviewDTO(String comment, String userMail, Double grade, Date date) {
        this.comment = comment;
        this.userMail = userMail;
        this.grade = grade;
        this.date = date;
    }

    public CommentPreviewDTO(Long id, String comment, String userMail, Double grade, Date date) {
        this.id = id;
        this.comment = comment;
        this.userMail = userMail;
        this.grade = grade;
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReplyDTO getReplyDTO() {
        return replyDTO;
    }

    public void setReplyDTO(ReplyDTO replyDTO) {
        this.replyDTO = replyDTO;
    }

    @Override
    public String toString() {
        return "CommentPreviewDTO{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", userMail='" + userMail + '\'' +
                ", grade=" + grade +
                ", date=" + date +
                ", replyDTO=" + replyDTO +
                '}';
    }
}
