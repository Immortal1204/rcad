package com.mrf.Rcad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mrf.Rcad.entity.Doctor;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	
}
