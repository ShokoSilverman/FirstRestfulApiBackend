package com.CSC280.Lab2Api.Controllers.Repos;

import com.CSC280.Lab2Api.Models.Faculty;
import com.CSC280.Lab2Api.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String> {
}
