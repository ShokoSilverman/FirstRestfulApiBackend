package com.CSC280.Lab2Api.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.management.openmbean.KeyAlreadyExistsException;
import javax.servlet.http.HttpServletResponse;

import com.CSC280.Lab2Api.Controllers.Repos.DegreeRepository;
import com.CSC280.Lab2Api.Controllers.Repos.FacultyRepository;
import com.CSC280.Lab2Api.Controllers.Repos.StudentRepository;
import com.CSC280.Lab2Api.Controllers.Repos.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CSC280.Lab2Api.Models.Degree;
import com.CSC280.Lab2Api.Models.Faculty;
import com.CSC280.Lab2Api.Models.Student;
import com.CSC280.Lab2Api.Models.Teacher;

@RestController
@CrossOrigin
@RequestMapping("/user/Api")
public class UserAPI {

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
    public String StudentID(@PathVariable String id, HttpServletResponse response) { 
		response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", 
                "Origin, X-Requested-With, Context-Type, Accept*");
		Optional<Student> stu = studentRepo.findById(id);
		if (stu.isPresent()){
			//Student student = stu.get().toString();
			return stu.get().toString();
		}else{
			return "No student found";
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
		return (ArrayList<Degree>) degreeRepo.findAll();
	}
	
	//delete

	@RequestMapping(path="/student/{id}", method=RequestMethod.DELETE)
	public String delStudent(@PathVariable String id) {
		//return bllApi.delStudent(id);
		studentRepo.deleteById(id);
		return "Deleted student";
	}
	
	@RequestMapping(path="/teacher/{id}", method=RequestMethod.DELETE)
	public String delTeacher(@PathVariable String id) {
		teacherRepo.deleteById(id);
		return "Deleted Teacher";
	}
	
	@RequestMapping(path="/faculty/{id}", method=RequestMethod.DELETE)
	public String delFaculty(@PathVariable String id) {
		facultyRepo.deleteById(id);
		return "Faculty deleted";
	}
	@RequestMapping(path="/degree/{id}", method=RequestMethod.DELETE)
	public String delDegree(@PathVariable String id) {
		degreeRepo.deleteById(id);
		return "Degree deleted";
	}
	
	//updates
	
	@PatchMapping(path = "/studentUpd")
	@ResponseStatus(code=HttpStatus.CREATED)
	public String updStudent(@RequestBody Student student) {
		return bllApi.upStudent(student.getId(), student.getFirstName(), student.getLastName(),student.getFavoriteClass());
	}
	
	@PatchMapping(path = "/teacherUpd")
	@ResponseStatus(code=HttpStatus.CREATED)
	public String updTeacher(@RequestBody Teacher teacher) {
		return bllApi.upTeacher(teacher.getId(), teacher.getFirstName(), teacher.getLastName(), teacher.getClassTaught());
	}
	
	@PatchMapping(path = "/facultyUpd")
	@ResponseStatus(code=HttpStatus.CREATED)
	public String updFaculty(@RequestBody Faculty faculty) {
		return bllApi.upFaculty(faculty.getId(), faculty.getFirstName(), faculty.getLastName(), faculty.getJobTitle());
	}
	
	@PatchMapping(path = "/degreeUpd")
	@ResponseStatus(code=HttpStatus.CREATED)
	public String updFaculty(@RequestBody Degree degree){
		return bllApi.upDegree(degree.getId(), degree.getName(), degree.getChair());
	}
	
	//creates have been moved to mongoDB
	
	@PostMapping(path = "/studentAdd")
	@ResponseStatus(code=HttpStatus.CREATED)
	public String createStudent(@RequestBody Student student) {
		//bllApi.studentList.add(student);
		//return student.getFirstName() + " added";
		if (studentRepo.findById(student.getId()).isPresent()){
			throw new KeyAlreadyExistsException("That student already exists!");
		}
		studentRepo.save(student);
		return student.getFirstName() + " added";
	}



	@PostMapping(path = "/teacherAdd")
	@ResponseStatus(code=HttpStatus.CREATED)
	public String createTeacher(@RequestBody Teacher teacher) {
		//bllApi.teacherList.add(teacher);
		if (teacherRepo.findById(teacher.getId()).isPresent()){
			throw new KeyAlreadyExistsException("That teacher already exists!");
		}
		teacherRepo.save(teacher);
		return teacher.getFirstName() + " added";
	}
	
	@PostMapping(path = "/facultyAdd")
	@ResponseStatus(code=HttpStatus.CREATED)
	public String createFaculty(@RequestBody Faculty faculty) {
		//bllApi.facultyList.add(faculty);
		if (facultyRepo.findById(faculty.getId()).isPresent()){
			throw new KeyAlreadyExistsException("That faculty member already exists!");
		}
		facultyRepo.save(faculty);
		return faculty.getFirstName() + " added!";
	}
	
	@PostMapping(path = "/degreeAdd")
	@ResponseStatus(code=HttpStatus.CREATED)
	 public String createDegree(@RequestBody Degree degree) {
       // bllApi.degreeList.add(degree);
        if (degreeRepo.findById(degree.getId()).isPresent()){
        	throw new KeyAlreadyExistsException("That degree already exists!");
		}
        degreeRepo.save(degree);
        return degree.getName() + " added!";
	  }

}
