package com.Advertisement.Advertisement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.Advertisement.Advertisement.model.*;


public interface CarClassRepository extends JpaRepository<CarClass, Long> {

    public CarClass findOneByid(Long id);
    public List<CarClass> findAll();
    public void deleteByCode(String code);
    public CarClass findByName(String name);
}