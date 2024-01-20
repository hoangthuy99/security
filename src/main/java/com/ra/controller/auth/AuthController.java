package com.ra.controller.auth;

import com.ra.model.dto.request.UserLogin;
import com.ra.model.dto.request.UserRegister;
import com.ra.model.dto.response.JwtResponse;
import com.ra.model.dto.response.RoleResponse;
import com.ra.model.dto.response.Status;
import com.ra.model.dto.response.UserResponse;
import com.ra.model.entity.Products;
import com.ra.model.entity.User;
import com.ra.service.IRoleService;
import com.ra.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> handleLogin(@RequestBody @Valid UserLogin userLogin) {
        return new ResponseEntity<>(userService.handleLogin(userLogin), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> handleRegister(@RequestBody @Valid UserRegister userRegister) {
        return new ResponseEntity<>(userService.handleRegister(userRegister), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(Pageable pageable) {
        Page<UserResponse> userResponses = userService.getAll(pageable);
        return new ResponseEntity<>(userResponses, HttpStatus.OK);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<?> toggleUserLockStatus(@PathVariable Long userId) {
        Optional<User> userResponse = userService.findById(userId);
        if (userResponse.isPresent()) {
            User user = userResponse.get();
            if (user.getStatus().equals(Status.ACTIVE)) {
                user.setStatus(Status.BLOCK);
            } else {
                user.setStatus(Status.ACTIVE);
            }
            userService.save(user);
            String status = user.getStatus().getValue() ? "khoá" : "mở khoá";
            return new ResponseEntity<>("Người dùng đã được " + status + ".", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Người dùng không tồn tại.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/roles")
    public ResponseEntity<?> getAllRole(Pageable pageable) {
        Page<RoleResponse> roleResponses = roleService.getAll(pageable);
        return new ResponseEntity<>(roleResponses, HttpStatus.OK);
    }
    @GetMapping("/users/search")
    public ResponseEntity<?> searchUserByName(@RequestParam(name = "fullName") String keyword) {
        List<User> users = userService.searchUserByFullName(keyword);
        if(keyword != null){
            users = userService.searchUserByFullName(keyword);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
