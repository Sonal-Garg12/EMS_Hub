package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.prog.entity.Employee;
import com.prog.repository.EmpRepo;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepo repo;
	public void addEmp(Employee e) {
		
		repo.save(e);
		
		
	}
	
	// fetch data all employee from database
	
	public List<Employee> getAllEmp(){
		return repo.findAll();
		
		
	}
	
	// data fetch in text box from database
	
	public Employee getEMpById(int id) {
		
		 Optional<Employee> e = repo.findById(id);
		 if(e.isPresent()) {
			 return e.get();
		 }
		 
		 return null;
	}
	
	public void deleteEMp(int id) {
		repo.deleteById(id);
	}

}
