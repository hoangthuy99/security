package com.ra.service.impl;

import com.ra.model.entity.Role;
import com.ra.repository.IRoleRepository;
import com.ra.service.IRoleService;
import com.ra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Role findByRoleName(String roleName) {
        Role role = roleRepository.findByRoleName(roleName).orElseThrow(()->new RuntimeException("role not found"));
        return role;
    }
}
