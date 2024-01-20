package com.ra.model.dto.response;


import com.ra.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponse {
    private Long user_id;
    private String fullName;
    private String username;
    private String password;
    private Status status;
    private String avatar;
    private String phone;
    private String address;
    private Set<Role> roles;
    public UserResponse(User user){
        this.user_id = user.getUserId();
        this.fullName = user.getFullName();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.status = user.getStatus();
        this.avatar = user.getAvatar();
        this.phone = user.getAddress();
        this.address = user.getAddress();
        this.roles =user.getRoles();
    }
}
