package com.ra.model.dto.response;

import com.ra.model.entity.Role;
import com.ra.model.entity.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class RoleResponse {
    private Long id;
    private RoleName roleName;
    public RoleResponse(Role role){
        this.id = role.getId();
        this.roleName = role.getRoleName();
    }
}
