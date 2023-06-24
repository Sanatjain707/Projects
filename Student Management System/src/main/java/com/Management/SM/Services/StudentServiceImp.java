package com.Management.SM.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Management.SM.Entities.Student;
import com.Management.SM.Repository.StudentRepo;

@Service
public class StudentServiceImp implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	

	@Override
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}


	@Override
	public void saveStudent(Student student) {
		studentRepo.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		return studentRepo.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}


	@Override
	public void deleteStudentById(Long id) {
		studentRepo.deleteById(id);
	}




}
