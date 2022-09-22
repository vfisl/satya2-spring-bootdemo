package com.studentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentapp.model.Student;



public interface IStudentRepository extends JpaRepository<Student,Integer>{
	  //derived query
	  //List<Student> findByDepartment(String dept);
	  //List<Student> findByAddressCity(String city);
      //List<Student> findByAddressCityAndDepartment(String city, String dept);
	
	//JPLQ
	@Query("from Student where department=?1")
	List<Student>findByDept(String dept);	
	@Query("from Student s inner join s.address a where a.city=?1")
	List<Student>findStudesByCity(String city);
	@Query("from Student s inner join s.address a where a.city=?1 and s.department=?2")
	List<Student>findByCityDept(String city, String dept);
	@Query("from Student s inner join s.address a where a.city=?1 and a.state=?2")
	List<Student>findByCityStates(String city, String state);
	

}
