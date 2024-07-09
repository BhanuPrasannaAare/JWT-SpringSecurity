package com.example.demo.repository;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Student;

@SpringBootTest
class StudentRepositoryTest {
	
	@Autowired
private StudentRepository  studentrepository;
	
	
	@Test
	void saveMethod() {
		//create student
		Student student=new Student();
		student.setName("bhanu");
		student.setMailId("bhanuprasanna.are@gmail.com");
		student.setBranch("c.s.e");
		
		//save student
		Student studentSave=studentrepository.save(student);
		
		//display product info
		System.out.println(studentSave.getId());
		System.out.println(studentSave.toString());
	}

	@Test
	void UpdateUsingSaveMethod() {

		
		//find or retrieve an entity by id
		int id=2;
		Student student=studentrepository.findById(id).get();
		
		//update entity information
		student.setName("chaitu");
		student.setMailId("chaitanya.are@gmail.com");
		student.setBranch("e.c.e");
		
		
		//save updated entity
		studentrepository.save(student);
		
	}
	
	
	@Test
	void findbyidMethod() {

		 int id=1;
		 Student student=studentrepository.findById(id).get();
		 
	}
	@Test
	void saveallMethod() {
		Student student=new Student();
		student.setName("sravs");
		student.setMailId("sravani.are@gmail.com");
		student.setBranch("e.e.e");
		
		Student student1=new Student();
		student1.setName("ammu");
		student1.setMailId("amulya.are@gmail.com");
		student1.setBranch("c.s.e");
		
		studentrepository.saveAll(List.of(student,student1));
		
	}
	@Test
	void findallMethod()	{
		List<Student> students=studentrepository.findAll();
		students.forEach((s)->{
			System.out.println(s.getName());
		});
	}
	@Test
	void deletebyidMethod() {
		int id=1;
		studentrepository.deleteById(id);
		
	} 
	@Test
	void deleteMethod() {
		//find an entity by id
		int id=2;
		Student student=studentrepository.findById(id).get();
		
		//delete entity
		studentrepository.delete(student);
	}
	@Test
	void deleteallMethod() {
		studentrepository.deleteAll();
	}
	@Test
	void countMethod() {
		long count=studentrepository.count();
		System.out.println(count);
	}
	}
