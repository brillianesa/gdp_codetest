package com.gdp.codetest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdp.codetest.model.Role;
import com.gdp.codetest.repository.RoleRepository;
import com.gdp.codetest.service.servicelist.RoleServices;

public class RoleServiceImpl implements RoleServices<Role> {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Boolean Save(Role role) {
        return roleRepository.findById(role.getRole_id()).isPresent();

    }

    @Override
    public Role Get(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Boolean Delete(int id) {
        try {
            roleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
