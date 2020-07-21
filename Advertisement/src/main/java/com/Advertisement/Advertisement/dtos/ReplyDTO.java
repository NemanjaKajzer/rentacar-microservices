package com.Advertisement.Advertisement.dtos;

public class ReplyDTO {

    private String comment;

    private String agentMail;

    private Long id;

    public ReplyDTO() {
    }

    public ReplyDTO(String comment, String agentMail, Long id) {
        this.comment = comment;
        this.agentMail = agentMail;
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAgentMail() {
        return agentMail;
    }

    public void setAgentMail(String agentMail) {
        this.agentMail = agentMail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReplyDTO{" +
                "comment='" + comment + '\'' +
                ", agentMail='" + agentMail + '\'' +
                ", id=" + id +
                '}';
    }
}
