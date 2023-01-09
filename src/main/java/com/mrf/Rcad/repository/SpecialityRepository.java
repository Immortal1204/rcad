package com.mrf.Rcad.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mrf.Rcad.entity.Speciality;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

	Optional<Speciality> findByName(String spe_name);

	List<Speciality> findByNameIn(List<String> specialityNames);
	
	
}

