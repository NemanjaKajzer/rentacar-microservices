package com.Advertisement.Advertisement.model;

import javax.persistence.*;

import com.Advertisement.Advertisement.model.*;

@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String comment;

    private Long agentID;

    public Reply(){

    }

    public Reply(String comment, Comment parent, Long agentID) {
        this.comment = comment;
        this.agentID = agentID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getAgentID() {
        return agentID;
    }

    public void setAgentID(Long agentID) {
        this.agentID = agentID;
    }
}
