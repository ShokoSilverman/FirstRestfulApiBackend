package com.CSC280.Lab2Api.Controllers.Repos;

import com.CSC280.Lab2Api.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> getFirstByUserName(String userName);

}
