package com.Advertisement.Advertisement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.Advertisement.Advertisement.model.*;


public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    public Advertisement findOneByid(Long id);
    public List<Advertisement> findAll();
    public List<Advertisement> findAllByPostedByID(Long id);
}
