package com.Advertisement.Advertisement.controller;

import java.util.List;

import com.Advertisement.Advertisement.model.CarClass;
import com.Advertisement.Advertisement.service.CarClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Advertisement.Advertisement.model.CarClass;
import com.Advertisement.Advertisement.service.CarClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "carClass")
public class CarClassController {

    @Autowired
	private CarClassService carClassService;


	@PostMapping(value="/save")
	public ResponseEntity<Long> save(@RequestBody String name) {
	
		carClassService.save(name);

		return new ResponseEntity<>(HttpStatus.OK);
	}

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,  consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarClass> getCarClass(@PathVariable Long id) {
        CarClass carClass = carClassService.findOneById(id);
		if(carClass == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CarClass>(carClass, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<CarClass>> getAll() {
        List<CarClass> carClasses = carClassService.findAll();
        return new ResponseEntity<List<CarClass>>(carClasses, HttpStatus.OK);
	}
}