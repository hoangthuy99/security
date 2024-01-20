package com.ra.service.impl;

import com.ra.model.dto.response.RoleResponse;
import com.ra.model.entity.Role;
import com.ra.model.entity.RoleName;
import com.ra.repository.IRoleRepository;
import com.ra.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Role findByRoleName(RoleName roleName) {
        Role roles = roleRepository.findByRoleName(roleName).orElseThrow(()->new RuntimeException("role not found"));
        return roles;
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Page<RoleResponse> getAll(Pageable pageable) {
        Sort sort=Sort.by("rollName").ascending();
        Pageable pageableCustom= PageRequest.of(pageable.getPageNumber(),5,sort);
        Page<Role> roles = roleRepository.findAll(pageableCustom);
        return roles.map(RoleResponse::new);
    }


}
