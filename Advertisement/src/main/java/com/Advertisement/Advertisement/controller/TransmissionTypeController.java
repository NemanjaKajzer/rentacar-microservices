package com.Advertisement.Advertisement.controller;

import java.util.List;

import com.Advertisement.Advertisement.model.*;
import com.Advertisement.Advertisement.service.*;

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
@RequestMapping(value = "transmission")
public class TransmissionTypeController {

    @Autowired
	private TransmissionTypeService transmissionTypeService;

    @PostMapping(value="/save")
	public ResponseEntity<Long> save(@RequestBody String name) {
	
		transmissionTypeService.save(name);

		return new ResponseEntity<>(HttpStatus.OK);
	}

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,  consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransmissionType> getModel(@PathVariable Long id) {
        TransmissionType tt = transmissionTypeService.findOneById(id);
		if(tt == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TransmissionType>(tt, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<TransmissionType>> getAll() {
        List<TransmissionType> transmissionTypes = transmissionTypeService.findAll();
        return new ResponseEntity<List<TransmissionType>>(transmissionTypes, HttpStatus.OK);
	}
}