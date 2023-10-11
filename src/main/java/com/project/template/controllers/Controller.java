package com.project.template.controllers;

import com.project.template.entities.Template;
import com.project.template.exceptions.ResourceNotFoundException;
import com.project.template.services.Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

	@Autowired
	private Service service;

	@GetMapping("/health")
	public ResponseEntity<String> health() {
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Template> get(@PathVariable Integer id) throws ResourceNotFoundException {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Template> post(@RequestBody @Valid Template template) {
		return new ResponseEntity<>(service.post(template), HttpStatus.CREATED);
	}

	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Template> put(@RequestBody @Valid Template template) throws ResourceNotFoundException {
		return new ResponseEntity<>(service.put(template), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Template> delete(@PathVariable Integer id) throws ResourceNotFoundException {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

}
