package com.Advertisement.Advertisement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.Advertisement.Advertisement.model.TransmissionType;


public interface TransmissionTypeRepository extends JpaRepository<TransmissionType, Long> {

    public TransmissionType findOneByid(Long id);
    public List<TransmissionType> findAll();
    public void deleteByCode(String code);
    public TransmissionType findByName(String name);
}