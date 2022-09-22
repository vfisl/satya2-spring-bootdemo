package com.studentapp.service;

import java.util.List;

import com.studentapp.model.Student;

public interface IStudentService {
	public void addStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(int studentId);
	Student getById(int sudentId);
	List<Student> getByDepartment(String department);
	List<Student> getByCity(String city);
	List<Student> getByCityAndDepartment( String city,String department);
	List<Student> getAll();
	List<Student> getByCityState(String city, String state);

}
