package com.Advertisement.Advertisement.service;

import com.Advertisement.Advertisement.model.*;
import com.Advertisement.Advertisement.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ModelService {
    
@Autowired
ModelRepository modelRepository;

    public Model findOneById(Long id){
        return modelRepository.findOneByid(id);
    }

    public List<Model> findAll(){
        return modelRepository.findAll();
    }

    public void save(String name){
        modelRepository.save(new Model(name));
    }
}