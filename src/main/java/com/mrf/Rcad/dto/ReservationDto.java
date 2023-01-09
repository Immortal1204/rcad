package com.mrf.Rcad.dto;


import java.sql.Time;
//import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class ReservationDto {
	
//	  private Long id;
//	  private LocalDateTime dateTime;
	  private Date date;
	  private Time debut;
	  private Time fin;
	  private Double price;
	  private DoctorDto doctorDto;
	  private PatientDto patientDto;
	  private ClinicDto clinicDto;
}
