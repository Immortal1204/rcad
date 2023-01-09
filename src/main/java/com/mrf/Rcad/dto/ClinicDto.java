package com.mrf.Rcad.dto;

import java.io.Serializable;
import java.util.List;

import com.mrf.Rcad.entity.Clinic;
import com.mrf.Rcad.entity.Doctor;
import com.mrf.Rcad.entity.Speciality;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data @AllArgsConstructor
public class ClinicDto implements Serializable{
private static final long serialVersionUID = 1L;
//private static final long serialVersionUID = 545249592854772609L;
	  private Long id;
	  private String name;
//	  private String address;
	  private String phone;
	  private Double latitude;
	  private Double longitude;
	  private List<Speciality> specialities;
	  private List<Doctor> doctors;

	  public ClinicDto(Clinic clinic) {
//	    this.id = clinic.getId();
	    this.name = clinic.getName();
//	    this.address = clinic.getAddress();
	    this.phone = clinic.getPhone();
	    this.latitude = clinic.getLatitude();
	    this.longitude = clinic.getLongitude();
	  }

//	public ClinicDto(String name, String phone, Double latitude, Double longitude) {
//		super();
//		this.name = name;
//		this.phone = phone;
//		this.latitude = latitude;
//		this.longitude = longitude;
//	}
	  
	  

	}

