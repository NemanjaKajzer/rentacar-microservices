package com.Advertisement.Advertisement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.Advertisement.Advertisement.model.*;


public interface BrandRepository extends JpaRepository<Brand, Long> {

    public Brand findOneByid(Long id);
    public List<Brand> findAll();
    public void deleteByCode(String code);
    public Brand findByName(String name);
}