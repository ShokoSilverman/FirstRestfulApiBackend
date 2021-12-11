package com.CSC280.Lab2Api.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.CSC280.Lab2Api.Controllers.Repos.DegreeRepository;
import com.CSC280.Lab2Api.Controllers.Repos.FacultyRepository;
import com.CSC280.Lab2Api.Controllers.Repos.StudentRepository;
import com.CSC280.Lab2Api.Controllers.Repos.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.CSC280.Lab2Api.Models.Degree;
import com.CSC280.Lab2Api.Models.Faculty;
import com.CSC280.Lab2Api.Models.Student;
import com.CSC280.Lab2Api.Models.Teacher;

@RestController
@RequestMapping("/anyone/Api")
public class ApiConnector {

	@Autowired
	private BLLApi bllApi;
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private TeacherRepository teacherRepo;
	@Autowired
	private FacultyRepository facultyRepo;
	@Autowired
	private DegreeRepository degreeRepo;


	@RequestMapping(path="/testCon", method=RequestMethod.GET)
	public String speak() {
		return "Connected";
	}

	@GetMapping(path="/student/{id}")//     /person/{id} /person
	public Student StudentID(@PathVariable String id, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Context-Type, Accept*");
		Optional<Student> stu = studentRepo.findById(id);
		if (stu.isPresent()){
			//Student student = stu.get().toString();
			return stu.get();
		}else{
			//return "No student found";
			return null;
		}

	}

	@GetMapping(path="/student", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<Student> getStudentJSON(HttpServletResponse response) {
		//BllJournalEntry bllJournalEntry = new BllJournalEntry();
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Context-Type, Accept*");
		return (ArrayList<Student>) studentRepo.findAll();
	}

	@GetMapping(path="/teacher/{id}")//     /person/{id} /person
	public String teacherID(@PathVariable String id, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Context-Type, Accept*");
		Optional<Teacher> tec = teacherRepo.findById(id);
		if (tec.isPresent()){
			return tec.get().toString();
		}else{
			return "No teacher found";
		}

	}

	@GetMapping(path="/teacher", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<Teacher> getTeacherJSON(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Context-Type, Accept*");
		return (ArrayList<Teacher>) teacherRepo.findAll();
	}

	@GetMapping(path="/faculty/{id}")//     /person/{id} /person
	public String facultyID(@PathVariable String id, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Context-Type, Accept*");
		Optional<Faculty> fac = facultyRepo.findById(id);
		if (fac.isPresent()){
			return fac.get().toString();
		}else{
			return "No faculty found";
		}

	}

	@GetMapping(path="/faculty", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<Faculty> getFacultyJSON(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Context-Type, Accept*");
		return (ArrayList<Faculty>) facultyRepo.findAll();
	}

	@GetMapping(path="/degree/{id}")//     /person/{id} /person
	public String degreeID(@PathVariable String id, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Context-Type, Accept*");
		Optional<Degree> deg = degreeRepo.findById(id);
		if (deg.isPresent()){
			return deg.get().toString();
		}else{
			return "No faculty found";
		}

	}

	@GetMapping(path="/degree", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<Degree> getDegreeJSON(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Context-Type, Accept*");
		//BllJournalEntry bllJournalEntry = new BllJournalEntry();

		return (ArrayList<Degree>) degreeRepo.findAll();
	}
	
	
	
	
}
