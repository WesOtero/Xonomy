package com.wesotero.xonomy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesotero.xonomy.model.Specimen;

public interface SpecimenRepository extends JpaRepository<Specimen, Long>{
	
}
