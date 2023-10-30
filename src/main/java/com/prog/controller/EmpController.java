package com.prog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Employee;
import com.prog.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home() {
		
    return "index";
		
	}
	

	@GetMapping("/allemp")
	public String showAllEmp(Model m) {
		List<Employee> emp = service.getAllEmp();
		m.addAttribute("emp",emp);
		
		return "all_emp";
	}
	

	@GetMapping("/login")
	public String showLoginPage() {
		
		return "login";
	}

	@GetMapping("/about")
	public String showAboutPage() {
		
		return "about";
	}
	
	
	
	@GetMapping("/addemp")
	public String addEmpForm() {
		
		return "add_emp";
	}
	
	@GetMapping("/contactus")
	public String showContactusPage() {
		
		return "contactus";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e) {
		System.out.println(e);
		
		service.addEmp(e);
		
		//session.setAttribute("msg", "Employee Added Sucessfully....");
		return "redirect:/";
		
		
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		
		Employee e = service.getEMpById(id);
		
		m.addAttribute("emp",e);
		
		
		return "edit";
		
		
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Emp Data Update Sucessfully");
		return "redirect:/allemp";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id) {
		service.deleteEMp(id);
		return "redirect:/allemp";
		
	}

}
