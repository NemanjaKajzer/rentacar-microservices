package com.Advertisement.Advertisement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.Advertisement.Advertisement.model.*;


public interface ModelRepository extends JpaRepository<Model, Long> {

    public Model findOneByid(Long id);
    public List<Model> findAll();
    public void deleteByCode(String code);
    public Model findByName(String name);
}