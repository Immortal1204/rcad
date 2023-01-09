package com.mrf.Rcad.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @Data @AllArgsConstructor
@Entity @Table(indexes= {@Index(name = "idx_name", columnList = "name", unique = true)})
public class Clinic {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String name;

//  @Column(nullable = false)
//  private String address;
  
  @Column
  private String photo;

  @Column(nullable = false)
  private String phone;

  @Column(nullable = false)
  private Double latitude;

  @Column(nullable = false)
  private Double longitude;

  @OneToMany(mappedBy = "clinic")
  private List<Doctor> doctors;
  
  @ManyToMany
  private List<Speciality> specialities;

//public Clinic(String name, String phone, Double latitude, Double longitude) {
//	super();
//	this.name = name;
//	this.phone = phone;
//	this.latitude = latitude;
//	this.longitude = longitude;
//	this.doctors = new ArrayList<Doctor>();
//	this.specialities = new ArrayList<Speciality>();
//	
//}
  
  

}
