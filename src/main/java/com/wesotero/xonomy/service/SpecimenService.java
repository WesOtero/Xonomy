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
	
	public Specimen addSpecimen(Specimen specimen) {
		return specimenRepository.save(specimen);
	}
	
	public Specimen findSpecimenById(Long id) {
		return specimenRepository.findById(id).orElseThrow(() -> new SpecimenNotFoundException ("Specimen Not Found"));
	}
	
	public List<Specimen> getAllSpecimens() {
		return specimenRepository.findAll();
	}
	
	public Specimen updateSpecimen(Specimen specimen) {
		return specimenRepository.save(specimen);
	}
	
	public void deleteSpecimen(Long id) {
		specimenRepository.deleteById(id);
	}
	
}
