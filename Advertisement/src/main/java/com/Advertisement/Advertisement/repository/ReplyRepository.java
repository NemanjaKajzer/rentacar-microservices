package com.Advertisement.Advertisement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.Advertisement.Advertisement.model.*;


public interface ReplyRepository extends JpaRepository<Reply, Long> {

    public Reply findOneByid(Long id);
    public List<Reply> findAll();
   // public List<Reply> findAllByPostedBy_Id(Long id);
}