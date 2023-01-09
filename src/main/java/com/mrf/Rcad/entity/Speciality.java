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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(indexes=@Index(name = "idx_id", unique = true, columnList = "name"))
public class Speciality {
	public Speciality(String name, String description) {
			this.name = name;
			this.description = description;
		}
	public Speciality(String name, String description, String photo) {
		this.name = name;
		this.description = description;
		this.photo = photo;
	}

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
//  @Id
  @Column(nullable = false, unique=true)
  private String name;
  
  @Column
  private String photo;

  @Column(nullable = false, unique=true, length=1000)
  private String description;
  
  @OneToMany(mappedBy = "speciality")
  private List<Doctor> doctors;
  
  @ManyToMany
  private List<Clinic> clinics;
}
