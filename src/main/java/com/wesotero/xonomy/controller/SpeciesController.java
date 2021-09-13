package com.wesotero.xonomy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesotero.xonomy.model.Species;
import com.wesotero.xonomy.service.SpeciesService;

@RestController
@RequestMapping("/species")
@CrossOrigin(origins = "http://localhost:4200/")
public class SpeciesController {

	@Autowired
	private SpeciesService speciesService;
	
	// CREATE
	@PostMapping("/add")
	public ResponseEntity<Species> addSpecimen(@RequestBody Species species) {
		speciesService.addSpecies(species);
		return new ResponseEntity<>(species, HttpStatus.CREATED);
	}
	
	// READ
	@GetMapping("/all")
	public ResponseEntity<List<Species>> getAllSpecies() {
		List<Species> speciesList = speciesService.findAllSpecies();
		return new ResponseEntity<>(speciesList, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Species> getSpeciesById(@PathVariable("id") Long id) {
		Species species = speciesService.findSpeciesById(id);
		return new ResponseEntity<>(species, HttpStatus.OK);
	}
	
	// UPDATE
	@PutMapping("/update")
	public ResponseEntity<Species> updateSpecies(Species species) {
		speciesService.updateSpecies(species);
		return new ResponseEntity<>(species, HttpStatus.OK); 
	}
	
	// DELETE
	
	
}
