package com.Advertisement.Advertisement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.Advertisement.Advertisement.model.*;


public interface GradeRepository extends JpaRepository<Grade, Long> {

    public Grade findOneByid(Long id);
 
    public List<Grade> findAllByAd_Id(Long id);
}