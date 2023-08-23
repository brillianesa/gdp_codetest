package com.gdp.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdp.codetest.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
