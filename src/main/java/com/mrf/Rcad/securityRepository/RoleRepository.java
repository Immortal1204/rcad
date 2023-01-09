package com.mrf.Rcad.securityRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrf.Rcad.securityModels.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(String name);
}
