package com.mrf.Rcad.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mrf.Rcad.entity.Clinic;
import com.mrf.Rcad.entity.Doctor;
import com.mrf.Rcad.entity.Speciality;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data @AllArgsConstructor
public class SpecialityDto implements Serializable{
private static final long serialVersionUID = 8527249377121596656L;
	//	  private Long id;
	  private String name;
	  private String description;
	  private List<Doctor> doctors;
	  private List<Clinic> clinics;

	  public SpecialityDto(Speciality specialty) {
//	    this.id = specialty.getId();
	    this.name = specialty.getName();
	    this.description = specialty.getDescription();
	    this.doctors = specialty.getDoctors();
	    this.clinics = specialty.getClinics();
	  }

//	public SpecialityDto(String name, String description, String doctors, String clinics) {
//		super();
//		this.name = name;
//		this.description = description;
//		this.doctors = new ;
//		this.clinics = new ArrayList<Clinic>();
//	}
//	  
	  

	}

