package com.rodarte.crm.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rodarte.crm.model.Student;
import com.rodarte.crm.repository.ReadXLSX;
import com.rodarte.crm.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public List<Student> showStudents() throws IOException
	{
		String locationFile = "C:\\Users\\Tales R Jardim\\OneDrive\\Área de Trabalho\\sts-4.14.0.RELEASE\\Projeto\\projetoPraticoRodarte-API\\src\\main\\resources\\static\\dataStudent.xlsx";
		ReadXLSX fileXLSX = new ReadXLSX();
		
		List<Student> students = fileXLSX.ReadXLSXFile(locationFile);
		
		return studentRepository.saveAll(students);
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Student add( @RequestBody Student student)
	{
		return studentRepository.save(student);
	}
}

