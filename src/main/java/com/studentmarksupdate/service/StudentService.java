package com.studentmarksupdate.service;

import java.util.List;

import com.studentmarksupdate.entity.Student;

public interface StudentService {

	public void createStudent(Student student);

	public String getStudent();

	public List<Student> getAllStudent();

	public void updateStd(int std_id, Student std);

}
