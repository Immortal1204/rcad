package com.mrf.Rcad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mrf.Rcad.entity.Patient;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
}

