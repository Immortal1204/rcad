package com.mrf.Rcad.securityModels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Role {
    public Role(String string) {
		name = string;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}