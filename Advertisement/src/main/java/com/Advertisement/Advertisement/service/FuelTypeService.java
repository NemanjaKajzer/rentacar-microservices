package com.Advertisement.Advertisement.service;

import com.Advertisement.Advertisement.model.*;
import com.Advertisement.Advertisement.repository.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelTypeService {
    
@Autowired
FuelTypeRepository fuelTypeRepository;

    public FuelType findOneById(Long id){
        return fuelTypeRepository.findOneByid(id);
    }

    public List<FuelType> findAll(){
        return fuelTypeRepository.findAll();
    }

    public void save(String name){
        fuelTypeRepository.save(new FuelType(name));
    }
}