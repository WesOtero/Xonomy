package com.wesotero.xonomy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesotero.xonomy.exception.SpecimenNotFoundException;
import com.wesotero.xonomy.model.Specimen;
import com.wesotero.xonomy.repository.SpecimenRepository;

@Service
public class SpecimenService {

	@Autowired
	private final SpecimenRepository specimenRepository;

	public SpecimenService(SpecimenRepository specimenRepository) {
		super();
		this.specimenRepository = specimenRepository;
	}
	
	// CREATE
	public Specimen addSpecimen(Specimen specimen) {
		return specimenRepository.save(specimen);
	}
	
	// READ
	public List<Specimen> getAllSpecimens() {
		return specimenRepository.findAll();
	}
	
	public Specimen findSpecimenById(Long id) {
		Specimen specimen = specimenRepository.findById(id).orElseThrow(() -> new SpecimenNotFoundException ("Specimen Not Found"));
		return specimenRepository.findById(id).orElseThrow(() -> new SpecimenNotFoundException ("Specimen Not Found"));
	}
	
	// UPDATE
	public Specimen updateSpecimen(Specimen specimen) {
		return specimenRepository.save(specimen);
	}
	
	// DELETE
	public void deleteSpecimen(Specimen specimen) {
		specimenRepository.delete(specimen);
	}
	
	public void deleteSpecimenById(Long id) {
		specimenRepository.deleteById(id);
	}
	
}
