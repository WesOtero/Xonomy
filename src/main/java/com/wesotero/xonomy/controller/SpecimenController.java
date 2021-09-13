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

import com.wesotero.xonomy.model.Specimen;
import com.wesotero.xonomy.service.SpecimenService;

@RestController
@RequestMapping("/specimen")
@CrossOrigin(origins = "http://localhost:4200/")
public class SpecimenController {

	@Autowired
	private SpecimenService specimenService;

	//CREATE
	@PostMapping("/add")
	public ResponseEntity<Specimen> addSpecimen(@RequestBody Specimen specimen) {
		specimenService.addSpecimen(specimen);
		return new ResponseEntity<Specimen>(specimen, HttpStatus.CREATED);
	}
	
	// READ
	@GetMapping("/all")
	public ResponseEntity<List<Specimen>> getAllSpecimens() {
		List<Specimen> specimenList = specimenService.getAllSpecimens();
		return new ResponseEntity<>(specimenList, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Specimen> getSpecimenById(@PathVariable("id") Long id) {
		Specimen specimen = specimenService.findSpecimenById(id);
		return new ResponseEntity<>(specimen, HttpStatus.OK);
	} 
	
	// UPDATE
	@PutMapping("/update")
	public ResponseEntity<Specimen> updateSpecimen(Specimen specimen) {
		specimenService.updateSpecimen(specimen);
		return new ResponseEntity<>(specimen, HttpStatus.OK);
	}
	
	// DELETE
	@PutMapping("/delete/{id}")
	public ResponseEntity<?> deleteSpecimen(@PathVariable("id") Long id) {
		specimenService.deleteSpecimenById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
