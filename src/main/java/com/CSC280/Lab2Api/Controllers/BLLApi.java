package com.CSC280.Lab2Api.Controllers;

import java.util.Optional;

import com.CSC280.Lab2Api.Controllers.Repos.DegreeRepository;
import com.CSC280.Lab2Api.Controllers.Repos.FacultyRepository;
import com.CSC280.Lab2Api.Controllers.Repos.StudentRepository;
import com.CSC280.Lab2Api.Controllers.Repos.TeacherRepository;
import com.CSC280.Lab2Api.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BLLApi {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private TeacherRepository teacherRepo;
	@Autowired
	private FacultyRepository facultyRepo;
	@Autowired
	private DegreeRepository degreeRepo;

	@PostConstruct
	public void populate() {
		System.out.println("beans");
	}

	
	public String upStudent(String id, String firstName, String lastName, String favoriteClass) {
		Optional<Student> stu = studentRepo.findById(id);
		if (stu.isPresent()){
			Student student = stu.get();
			student.updateStudent(firstName, lastName, favoriteClass);
			studentRepo.save(student);
			return firstName + "updated!";
		}else{
			return "no student found";
		}
	}
	
	public String upTeacher(String id, String firstName, String lastName, String classTaught) {
		Optional<Teacher> tec = teacherRepo.findById(id);
		if (tec.isPresent()){
			Teacher teacher = tec.get();
			teacher.upTeacher(firstName, lastName, classTaught);
			teacherRepo.save(teacher);
			return firstName + "updated!";
		}else{
			return "no teacher found";
		}
	}
	
	public String upFaculty(String id, String firstName, String lastname, String jobTitle) {
		Optional<Faculty> fac = facultyRepo.findById(id);
		if (fac.isPresent()){
			Faculty faculty = fac.get();
			faculty.upFaculty(firstName, lastname, jobTitle);
			facultyRepo.save(faculty);
			return firstName + "updated!";
		}else{
			return "no faculty found";
		}
	}
	
	public String upDegree(String id, String name, String chair) {
		Optional<Degree> deg = degreeRepo.findById(id);
		if (deg.isPresent()){
			Degree degree = deg.get();
			degree.upDegree(name, chair);
			degreeRepo.save(degree);
			return name + "updated!";
		}else{
			return "no degree found";
		}
	}


}
