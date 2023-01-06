package com.studentmarksupdate.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.studentmarksupdate.entity.Student;
import com.studentmarksupdate.exception.StudentException;
import com.studentmarksupdate.service.StudentServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	StudentServiceImpl studentService;

	@PostMapping("/create")
	public ResponseEntity<String> createStudent(@Valid @RequestBody Student student) throws StudentException {
		if (Objects.isNull(student)) {
			throw new StudentException(" Please check the fields");
		}
		studentService.createStudent(student);
		return new ResponseEntity<>("Student added", HttpStatusCode.valueOf(201));

	}

	@GetMapping("/getRankHolder")
	public String getStudent( ) {
		return studentService.getStudent();
	}

	@GetMapping("/getAllStd")
	public List<Student> getAllStd() {
		return studentService.getAllStudent();
	}

	@PutMapping("/updateStd/{std_id}")
	public ResponseEntity<String> updateStd(@PathVariable int std_id, @RequestBody Student std) {
		studentService.updateStd(std_id, std);
		return new ResponseEntity<String>("Student Record updated", HttpStatusCode.valueOf(202));

	}

}