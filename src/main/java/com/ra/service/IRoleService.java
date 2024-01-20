package com.ra.service;

import com.ra.model.dto.response.RoleResponse;
import com.ra.model.entity.Role;
import com.ra.model.entity.RoleName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    Role findByRoleName(RoleName roleName);

    Optional<Role> findById(Long id);
    Page<RoleResponse> getAll(Pageable pageable);
}
