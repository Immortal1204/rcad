package com.mrf.Rcad.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mrf.Rcad.entity.Reservation;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Page<Reservation> findAll(Pageable pageable);
	
}

