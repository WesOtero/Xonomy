package com.wesotero.xonomy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesotero.xonomy.exception.SpecimenLogNotFoundException;
import com.wesotero.xonomy.model.SpecimenLog;
import com.wesotero.xonomy.repository.SpecimenLogRepository;

@Service
public class SpecimenLogService {
	
	@Autowired
	private SpecimenLogRepository specimenLogRepository;
	
	// CREATE
	public SpecimenLog addSpecimenLog(SpecimenLog specimenLog) {
		return specimenLogRepository.save(specimenLog);
	}
	
	// READ
	public List<SpecimenLog> getAllSpecimenLogs() {
		return specimenLogRepository.findAll();
	}
	
	public SpecimenLog getSpecimenLogById(Long id) {
		return specimenLogRepository.findById(id).orElseThrow(() -> new SpecimenLogNotFoundException("Specimen Not Found"));
	}
	
	// UPDATE
	public SpecimenLog updateSpecimenLog(SpecimenLog specimenLog) {
		return specimenLogRepository.save(specimenLog);
	}
	
	// DELETE
	public void deleteSpecimenLog(SpecimenLog specimenLog) {
		specimenLogRepository.delete(specimenLog);
	}
	
	public void deleteSpecimenLogById(Long id) {
		specimenLogRepository.deleteById(id);
	}
}
