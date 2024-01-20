package com.ra.service.impl;

import com.ra.model.dto.request.UserLogin;
import com.ra.model.dto.request.UserRegister;
import com.ra.model.dto.response.JwtResponse;
import com.ra.model.dto.response.Status;
import com.ra.model.dto.response.UserResponse;
import com.ra.model.entity.Role;
import com.ra.model.entity.RoleName;
import com.ra.model.entity.User;
import com.ra.repository.UserRepository;
import com.ra.security.jwt.JwtProvider;
import com.ra.security.user_principal.UserPrincipal;
import com.ra.service.IRoleService;
import com.ra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Override
    public JwtResponse handleLogin(UserLogin userLogin) {
        Authentication authentication;
        try{
            authentication = authenticationProvider
                    .authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(),userLogin.getPassword()));
        }catch (AuthenticationException exception){
            throw new RuntimeException("Username or password");
        }
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        //Tạo ra 1 token
        String token = jwtProvider.generateToken(userPrincipal);
        //Convert xang doi tuong UserResoin
        if(!userPrincipal.getUser().getStatus().getValue()) {
            throw new RuntimeException("your account is blocked");
        }

        return JwtResponse.builder()
                .fullName(userPrincipal.getUsername()).
                accessToken(token).
                status(userPrincipal.getUser().getStatus().getValue()).
                roles(userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet())).build();
    }

    @Override
    public String handleRegister(UserRegister userRegister) {
        if(userRepository.existsByUsername(userRegister.getUsername())){
            throw new RuntimeException("userName is exists");
        }
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByRoleName(RoleName.USER));
        User user = User.builder().
                fullName(userRegister.getFullName())
                .username(userRegister.getUsername())
                .password(passwordEncoder.encode(userRegister.getPassword()))
                .status(Status.ACTIVE)
                .address(userRegister.getAddress())
                .phone(userRegister.getPhone())
                .roles(roles).build();
        userRepository.save(user);
        return "Success";
    }

    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        // maper
        Sort sort=Sort.by("fullName").ascending();
        Pageable pageableCustom= PageRequest.of(pageable.getPageNumber(),5,sort);
        Page<User> users = userRepository.findAll(pageableCustom);
        return users.map(UserResponse::new);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> searchUserByFullName(String keyword) {
        return userRepository.searchUserByFullName(keyword);
    }

}
