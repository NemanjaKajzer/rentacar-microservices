package com.Advertisement.Advertisement.controller;

import java.util.List;
import java.util.jar.Attributes.Name;

import com.Advertisement.Advertisement.model.*;
import com.Advertisement.Advertisement.service.FuelTypeService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value = "fuelType")
public class FuelTypeController {

    @Autowired
	private FuelTypeService fuelTypeService;

    @PostMapping(value="/save")
	public ResponseEntity<Long> save(@RequestBody String name) {
	
		fuelTypeService.save(name);

		return new ResponseEntity<>(HttpStatus.OK);
	}

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,  consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FuelType> getFuelType(@PathVariable Long id) {
        FuelType fuelType = fuelTypeService.findOneById(id);
		if(fuelType == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FuelType>(fuelType, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<FuelType>> getAll() {
        List<FuelType> fuelType = fuelTypeService.findAll();
        return new ResponseEntity<List<FuelType>>(fuelType, HttpStatus.OK);
	}
}