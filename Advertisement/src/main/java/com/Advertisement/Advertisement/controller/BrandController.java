package com.Advertisement.Advertisement.controller;

import java.util.List;

import com.Advertisement.Advertisement.model.Brand;
import com.Advertisement.Advertisement.service.BrandService;

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
@RequestMapping(value = "brand")
public class BrandController {

    @Autowired
	private BrandService brandService;

    @PostMapping(value="/save")
	public ResponseEntity<Long> save(@RequestBody String name) {
	
		brandService.save(name);

		return new ResponseEntity<>(HttpStatus.OK);
	}

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,  consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Brand> getBrand(@PathVariable Long id) {
        Brand brand = brandService.findOneById(id);
		if(brand == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Brand>(brand, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Brand>> getAll() {
        List<Brand> brands = brandService.findAll();
        return new ResponseEntity<List<Brand>>(brands, HttpStatus.OK);
	}
}