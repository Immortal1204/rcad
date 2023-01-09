package com.mrf.Rcad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mrf.Rcad.entity.Clinic;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface ClinicRepository extends JpaRepository<Clinic, Long> {

	Optional<Clinic> findByName(String cli_name);
	
	
	
}

