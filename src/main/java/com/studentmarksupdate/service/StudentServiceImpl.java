package com.studentmarksupdate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmarksupdate.entity.Student;
import com.studentmarksupdate.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public void createStudent(Student student) {
		int totalMark = student.getMarks().getTamil() + student.getMarks().getEnglish() + student.getMarks().getMaths()
				+ student.getMarks().getScience() + student.getMarks().getSocial();
		student.getMarks().setTotal(totalMark);
		studentRepository.save(student);
	}

	@Override
	public String getStudent() {
		List<Student> list = studentRepository.findAll();
		int max = 0;
		for (Student name : list) {
			if (max < name.getMarks().getTotal()) {
				max = name.getMarks().getTotal();
			}
		}
		return "No 1 Rank Holder is " + studentRepository.getStdName(max);

	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public void updateStd(int std_id, Student std) {
		Student student = studentRepository.findById(std_id).get();
		student.setStudent_name(std.getStudent_name());
		student.setStudent_gender(std.getStudent_gender());
		student.getMarks().setEnglish(std.getMarks().getEnglish());
		student.getMarks().setTamil(std.getMarks().getTamil());
		student.getMarks().setMaths(std.getMarks().getMaths());
		student.getMarks().setScience(std.getMarks().getScience());
		student.getMarks().setSocial(std.getMarks().getSocial());
		int totalMark = student.getMarks().getTamil() + student.getMarks().getEnglish() + student.getMarks().getMaths()
				+ student.getMarks().getScience() + student.getMarks().getSocial();
		student.getMarks().setTotal(totalMark);
		studentRepository.save(student);
	}

}
