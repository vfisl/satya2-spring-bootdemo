package com.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.Address;
import com.studentapp.model.Student;
import com.studentapp.service.IStudentService;

@SpringBootApplication
public class SpringDatajpaOnetooneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetooneApplication.class, args);
	}
	@Autowired
  IStudentService iStudentService;
	@Override
	public void run(String... args) throws Exception {
		Student student1=new Student("Sharan","Mech",new Address("Guntur","Hyderabad"));
		//iStudentService.addStudent(student1);
		System.out.println("*********get all*********");
		System.out.println();
		iStudentService.getAll().forEach(System.out::println);
		System.out.println();
		System.out.println("**********get by city*************");
		iStudentService.getByCity("Banglore").forEach(System.out::println);
		System.out.println();
		System.out.println("**********by department************");
		iStudentService.getByDepartment("Testing").forEach(System.out::println);
		System.out.println("**********by City Depart,ment************");
		iStudentService.getByCityAndDepartment("Kokrajhar", "java").forEach(System.out::println);
		System.out.println("**********by City State************");
		iStudentService.getByCityState("Guntur", "Hyderabad").forEach(System.out::println);
	
	}

}
