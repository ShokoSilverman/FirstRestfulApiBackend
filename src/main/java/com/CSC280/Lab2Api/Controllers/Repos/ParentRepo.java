package com.CSC280.Lab2Api.Controllers.Repos;

import com.CSC280.Lab2Api.Models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepo extends JpaRepository<Parent, Integer> {
}
