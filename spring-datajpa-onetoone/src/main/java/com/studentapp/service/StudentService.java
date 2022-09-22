package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.model.Student;
import com.studentapp.repository.IStudentRepository;
@Service
public class StudentService implements IStudentService {
     IStudentRepository iStudentRepository;
     @Autowired
	public void setiStudentRepository(IStudentRepository iStudentRepository) {
		this.iStudentRepository = iStudentRepository;
	}

	@Override
	public void addStudent(Student student) {
		iStudentRepository.save(student);

	}

	@Override
	public void updateStudent(Student student) {
		iStudentRepository.save(student);

	}

	@Override
	public void deleteStudent(int studentId) {
		iStudentRepository.deleteById(studentId);

	}

	@Override
	public Student getById(int sudentId) {
		// TODO Auto-generated method stub
		return iStudentRepository.findById(sudentId).get();
	}

	@Override
	public List<Student> getByDepartment(String department) {
		// TODO Auto-generated method stub
		//return iStudentRepository.findByDepartment(department);
		return iStudentRepository.findByDept(department);
	}

	@Override
	public List<Student> getByCity(String city) {
		// TODO Auto-generated method stub
		//return iStudentRepository.findByAddressCity(city);
		return iStudentRepository.findStudesByCity(city);
	}

	@Override
	public List<Student> getByCityAndDepartment(String city, String department) {
		// TODO Auto-generated method stub
	 	//return iStudentRepository.findByAddressCityAndDepartment(city, department);
	    return iStudentRepository.findByCityDept(city, department);
	}
	

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return iStudentRepository.findAll();
	}

	@Override
	public List<Student> getByCityState(String city, String state) {
		// TODO Auto-generated method stub
		return iStudentRepository.findByCityStates(city, state);
	}

}
