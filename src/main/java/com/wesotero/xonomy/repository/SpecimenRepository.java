package com.wesotero.xonomy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wesotero.xonomy.model.Specimen;

@Repository
public interface SpecimenRepository extends JpaRepository<Specimen, Long>{
	
}
