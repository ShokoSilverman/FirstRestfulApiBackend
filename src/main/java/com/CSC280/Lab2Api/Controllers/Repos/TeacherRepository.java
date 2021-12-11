package com.CSC280.Lab2Api.Controllers.Repos;

import com.CSC280.Lab2Api.Models.Teacher;
import com.CSC280.Lab2Api.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
}
