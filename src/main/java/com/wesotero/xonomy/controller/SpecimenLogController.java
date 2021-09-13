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

import com.wesotero.xonomy.model.SpecimenLog;
import com.wesotero.xonomy.service.SpecimenLogService;

@RestController
@RequestMapping("/specimenlog")
@CrossOrigin("localhost:4200")
public class SpecimenLogController {
	
	@Autowired
	private SpecimenLogService specimenLogService;

	// CREATE
	@PostMapping("/add")
	public ResponseEntity<SpecimenLog> addSpecimenLog(@RequestBody SpecimenLog specimenLog) {
		specimenLogService.addSpecimenLog(specimenLog);
		return new ResponseEntity<SpecimenLog>(specimenLog, HttpStatus.CREATED);
	}
	
	// READ
	@GetMapping("/all")
	public ResponseEntity<List<SpecimenLog>> getAllSpecimenLogs() {
		List<SpecimenLog> specimenLogList = specimenLogService.getAllSpecimenLogs();
		return new ResponseEntity<List<SpecimenLog>>(specimenLogList, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<SpecimenLog> getSpecimenLogById(@PathVariable("id") Long id) {
		SpecimenLog specimenLog = specimenLogService.getSpecimenLogById(id);
		return new ResponseEntity<SpecimenLog>(specimenLog, HttpStatus.OK);
	}
	
	// UPDATE
	@PutMapping("/update")
	public ResponseEntity<SpecimenLog> updateSpecimenLog(SpecimenLog specimenLog) {
		specimenLogService.updateSpecimenLog(specimenLog);
		return new ResponseEntity<SpecimenLog>(specimenLog, HttpStatus.OK);
	}
	
	// DELETE
	@PutMapping("/delete/{id}")
	public ResponseEntity<?> deleteSpecimenLog(@PathVariable("id") Long id) {
		specimenLogService.deleteSpecimenLogById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
