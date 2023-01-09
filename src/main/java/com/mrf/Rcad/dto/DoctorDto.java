package com.mrf.Rcad.dto;

import java.io.Serializable;

import com.mrf.Rcad.entity.Clinic;
import com.mrf.Rcad.entity.Doctor;
import com.mrf.Rcad.entity.Speciality;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class DoctorDto implements Serializable{
	  private static final long serialVersionUID = 4600635158367635L;
	  private Long id;
	  private String name;
	  private String phone;
	  private Speciality speciality;
	  private Clinic clinic;

	  public DoctorDto(Doctor doctor) {
	    this.name = doctor.getName();
	    this.phone = doctor.getPhone();
	    this.speciality = doctor.getSpeciality();
	    this.clinic = doctor.getClinic();
	  }

//	public DoctorDto(String name, String phone, String specialty, String clinic) {
//		super();
//		this.name = name;
//		this.phone = phone;
//		this.specialty = specialty;
//		this.clinic = clinic;
//	}

	


	}

