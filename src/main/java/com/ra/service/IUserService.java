package com.ra.service;

import com.ra.model.dto.request.UserLogin;
import com.ra.model.dto.request.UserRegister;
import com.ra.model.dto.response.JwtResponse;
import com.ra.model.dto.response.UserResponse;
import com.ra.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    JwtResponse handleLogin(UserLogin userLogin);
    String handleRegister(UserRegister userRegister);
    Page<UserResponse> getAll(Pageable pageable);
    Optional<User> findById(Long id);
    User save(User user);
    List<User> searchUserByFullName(String keyword);


}
