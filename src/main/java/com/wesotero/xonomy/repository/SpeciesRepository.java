package com.wesotero.xonomy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wesotero.xonomy.model.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {

}
