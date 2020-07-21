package com.Advertisement.Advertisement.service;

import java.util.List;

import com.Advertisement.Advertisement.model.*;
import com.Advertisement.Advertisement.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarClassService {
    
@Autowired
CarClassRepository carClassRepository;

    public CarClass findOneById(Long id){
        return carClassRepository.findOneByid(id);
    }

    public List<CarClass> findAll(){
        return carClassRepository.findAll();
    }

    public void save(String name){
        carClassRepository.save(new CarClass(name));
    }
}