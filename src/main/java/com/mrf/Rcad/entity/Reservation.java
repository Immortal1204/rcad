package com.mrf.Rcad.entity;

import java.util.Date;
import java.sql.Time;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
//@Table(indexes= {@Index(name = "idx_date_time", columnList = "date_time", unique=true)})
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

//  @Column(name = "date_time")
//  private LocalDateTime dateTime;
  
  private Date date;
  private Time debut;
  private Time fin;

  @Column(name = "price")
  private Double price;

  @ManyToOne 
//  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

  @ManyToOne
//  @JoinColumn(name = "patient_id")
  private Patient patient;
  
  @ManyToOne
//  @JoinColumn(name = "clinic_id", nullable = false)
  private Clinic clinic;


}