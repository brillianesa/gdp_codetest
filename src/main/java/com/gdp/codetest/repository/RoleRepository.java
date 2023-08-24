package com.gdp.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gdp.codetest.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
