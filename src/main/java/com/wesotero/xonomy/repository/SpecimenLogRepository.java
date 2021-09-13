package com.wesotero.xonomy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wesotero.xonomy.model.SpecimenLog;

@Repository
public interface SpecimenLogRepository extends JpaRepository<SpecimenLog, Long> {

}
