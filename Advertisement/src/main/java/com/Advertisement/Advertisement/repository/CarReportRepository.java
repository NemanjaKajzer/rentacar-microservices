package com.Advertisement.Advertisement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.Advertisement.Advertisement.model.*;


public interface CarReportRepository extends JpaRepository<CarReport, Long> {

    public CarReport findOneByid(Long id);
    public List<CarReport> findAll();
  //  public List<CarReport> findAllByPostedBy_Id(Long id);
}