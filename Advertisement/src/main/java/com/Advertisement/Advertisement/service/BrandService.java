package com.Advertisement.Advertisement.service;

import com.Advertisement.Advertisement.model.*;
import com.Advertisement.Advertisement.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    
@Autowired
BrandRepository brandRepository;

    public Brand findOneById(Long id){
        return brandRepository.findOneByid(id);
    }

    public List<Brand> findAll(){
        return brandRepository.findAll();
    }

    public void save(String name){
        brandRepository.save(new Brand(name));
    }
}