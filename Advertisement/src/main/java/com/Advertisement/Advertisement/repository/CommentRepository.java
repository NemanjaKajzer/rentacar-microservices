package com.Advertisement.Advertisement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.Advertisement.Advertisement.model.*;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    public Comment findOneByid(Long id);
    public List<Comment> findAll();
   // public List<Comment> findAllByPostedBy_Id(Long id);
    public List<Comment> findByAd_Id(Long id);
    public List<Comment> findByApproved(Boolean approved);
    public void deleteByEndUserID(Long endUserID);
}