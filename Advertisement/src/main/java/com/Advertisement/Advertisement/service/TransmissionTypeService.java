package com.Advertisement.Advertisement.service;

import java.util.List;

import com.Advertisement.Advertisement.model.*;
import com.Advertisement.Advertisement.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransmissionTypeService {
    
@Autowired
TransmissionTypeRepository transmissionTypeRepository;

    public TransmissionType findOneById(Long id){
        return transmissionTypeRepository.findOneByid(id);
    }

    public List<TransmissionType> findAll(){
        return transmissionTypeRepository.findAll();
    }

    public void save(String name){
        transmissionTypeRepository.save(new TransmissionType(name));
    }
}