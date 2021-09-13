package com.wesotero.xonomy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesotero.xonomy.exception.SpeciesNotFoundException;
import com.wesotero.xonomy.model.Species;
import com.wesotero.xonomy.repository.SpeciesRepository;

@Service
public class SpeciesService {
	
	@Autowired
	private SpeciesRepository speciesRepository;
	
	// CREATE
	public Species addSpecies(Species species) {
		return speciesRepository.save(species);
	}
	
	// READ
	public List<Species> findAllSpecies() {
		List<Species> speciesList = speciesRepository.findAll();
		return speciesList;
	}
	
	public Species findSpeciesById(Long id) {
		return speciesRepository.findById(id).orElseThrow(() -> new SpeciesNotFoundException("Speices Not Found"));
	}
	
	// UPDATE
	public Species updateSpecies(Species species) {
		return speciesRepository.save(species);
	}
	
	// DELETE
	public void deleteSpecies(Species species) {
		speciesRepository.delete(species);
	}
	
	public void deleteSpeciesById(Long id) {
		speciesRepository.deleteById(id);
	}
}
