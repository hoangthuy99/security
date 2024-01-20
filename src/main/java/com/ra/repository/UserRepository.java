package com.ra.repository;

import com.ra.model.entity.Products;
import com.ra.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String userName);
    boolean existsByUsername(String userName);
    @Query("SELECT u from User u WHERE u.fullName like %?1% ")
    List<User> searchUserByFullName(String keyword);
}
