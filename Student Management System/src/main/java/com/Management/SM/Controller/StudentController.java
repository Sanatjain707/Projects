package com.Management.SM.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Management.SM.Entities.Student;
import com.Management.SM.Services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService; 
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		
		model.addAttribute("Students", studentService.getAllStudent());
 		return "Students";
		
	}
	
	
	@GetMapping("/addstudent")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
 		return "addStudent";
		
	}
	  
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		 model.addAttribute("student", studentService.getStudentById(id));
		return "editStudent";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
	
		Student stud = new Student();
		stud = studentService.getStudentById(id);
		
		stud.setFirstName(student.getFirstName());
		stud.setLastName(student.getLastName());
		stud.setEmail(student.getEmail());
		
		studentService.updateStudent(stud);
		
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) 
	{
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
	
}
