package com.Advertisement.Advertisement.controller;

import java.util.List;

import com.Advertisement.Advertisement.model.Model;
import com.Advertisement.Advertisement.service.ModelService;

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
@RequestMapping(value = "model")
public class ModelController {

    @Autowired
	private ModelService modelService;

    @PostMapping(value="/save")
	public ResponseEntity<Long> save(@RequestBody String name) {
	
		modelService.save(name);

		return new ResponseEntity<>(HttpStatus.OK);
	}

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,  consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Model> getModel(@PathVariable Long id) {
        Model model = modelService.findOneById(id);
		if(model == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Model>(model, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Model>> getAll() {
        List<Model> models = modelService.findAll();
        return new ResponseEntity<List<Model>>(models, HttpStatus.OK);
	}
}