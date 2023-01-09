package com.mrf.Rcad.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity @Table(indexes= {@Index(name = "idx_name", columnList = "name", unique = true)})
public class Status {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable=false)
  private String name;
  
  @OneToOne
  private Patient patient;
  
  @OneToOne
  private Doctor doctor;
  
  @OneToOne
  private Clinic clinic;
  
  

}
