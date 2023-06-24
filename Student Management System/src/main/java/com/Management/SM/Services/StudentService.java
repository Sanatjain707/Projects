package com.Management.SM.Services;

import java.util.List;

import com.Management.SM.Entities.Student;

public interface StudentService {
	
	List<Student> getAllStudent();
	void saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
}
