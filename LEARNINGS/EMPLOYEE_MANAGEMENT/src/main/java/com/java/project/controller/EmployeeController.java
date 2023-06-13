package com.java.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.project.entity.EmployeeEntity;
import com.java.project.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String getAllEmployees(Model model) {
//		model.addAttribute("employeeList", employeeService.getAllEmployees());
//		return "employeeList";
		return findPageProperty(1, "firstName", "asc", model); // Calling the pagination property
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertData() {
		// model.addAttribute("employeeList", employeeService.getAllEmployees());
		System.out.println("@@@@@@@@@@@@@@@@@");
		employeeService.insertData();
		return "employeeList";
	}

	@GetMapping("/addNewEmployeeInfo")
	public String addNewEmployee(Model model) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		model.addAttribute("employeeRegistrationKey", employeeEntity);
		return "employeeRegistration";
	}

	@PostMapping("/saveEmployeeInfo")
	public String saveEmployeeInfo(@ModelAttribute("employeeRegistrationKey") EmployeeEntity entity) {
		// method call to save the emp info to db
		employeeService.saveEmployeeInfo(entity);
		return "redirect:/";
	}

	@GetMapping("/editEmployeeInfo/{id}")
	public String editEmployeeInfo(@PathVariable(value = "id") long id, Model model) {
		System.out.println("id " + id);
		EmployeeEntity employeeEntity = employeeService.getEmployeeInfo(id);
		System.out.println("employeeEntity " + employeeEntity);
		model.addAttribute("employeeRegistrationKey", employeeEntity);
		return "updateEmpInfo";

	}

	@GetMapping("/deleteEmployeeInfo/{id}")
	public String deleteEmployeeInfo(@PathVariable(value = "id") long id) {
		System.out.println("deleteEmployeeInfo");
		employeeService.deleteEmployeeInfo(id);
		return "redirect:/";

	}

	@GetMapping("/pagination/{pageNo}")
	public String findPageProperty(@PathVariable(value = "pageNo") int pageNo,
			 @RequestParam("sortField") String sortField,
		     @RequestParam("sortDir") String sortDir,
			Model model) {
		
		System.out.println("sortField ---- "+sortField);
		int pageSize = 3;
		Page<EmployeeEntity> page = employeeService.findPageProperty(pageNo, pageSize, sortField, sortDir);
		System.out.println("page content --- " + page);
		List<EmployeeEntity> pageContent = page.getContent(); // fetch the list of employees

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	    System.out.println("---------------- 2 "+sortField);
		model.addAttribute("employeeList", pageContent);

		return "employeeList";
	}

}
