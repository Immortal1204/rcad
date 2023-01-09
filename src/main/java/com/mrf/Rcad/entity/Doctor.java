package com.mrf.Rcad.entity;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(indexes= {@Index(name = "idx_name", columnList = "name", unique = true)})
public class Doctor{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
 
  private String name;
  
  @Column
  private String photo;
  
  @Column(nullable = false)
  
  private String lastname;
//
//  @JsonCreator
//  public Doctor(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("phone") String phone, @JsonProperty("spcialty")Speciality specialty, @JsonProperty("clinic")Clinic clinic) {
//	super();
//	this.id = id;
//	this.name = name;
//	this.phone = phone;
//	this.specialty = specialty;
//	this.clinic = clinic;
//}
  

//public Doctor(String name, String phone, Speciality specialty, Clinic clinic) {
//	super();
//	this.name = name;
//	this.phone = phone;
//	this.speciality = specialty;
//	this.clinic = clinic;
//}

//public Doctor(String name, String phone) {
//	super();
//	this.name = name;
//	this.phone = phone;
//}


  @Column(nullable = false)
  private String phone;

  @ManyToOne
  @JoinColumn(name = "specialty_id")
  private Speciality speciality;

  @ManyToOne
  @JoinColumn(name = "clinic_id")
  private Clinic clinic;

}


