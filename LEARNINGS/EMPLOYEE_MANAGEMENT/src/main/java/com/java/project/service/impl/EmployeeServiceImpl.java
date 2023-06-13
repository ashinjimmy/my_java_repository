package com.java.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.project.entity.EmployeeEntity;
import com.java.project.repository.EmployeeRepository;
import com.java.project.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public String insertData() {
		employeeRepository.save(new EmployeeEntity(1, "Manu", "Roshan", "mr@gmail.com", 45000, "Telecom"));
		employeeRepository.save(new EmployeeEntity(2, "Ashin", "Jimmy", "as@gmail.com", 55000, "IT"));
		employeeRepository.save(new EmployeeEntity(3, "Jeeva", "Jhon", "jj@gmail.com", 55000, "Finance"));
		employeeRepository.save(new EmployeeEntity(4, "Sam", "Maben", "sm@gmail.com", 55000, "HR"));

		System.out.println("Count --- " + employeeRepository.count());
		return "Data updated";
	}

	@Override
	public void saveEmployeeInfo(EmployeeEntity entity) {
		employeeRepository.save(entity);
		System.out.println("Count of employees saved to db --- " + employeeRepository.count());
	}

	@Override
	public EmployeeEntity getEmployeeInfo(long id) {

		Optional<EmployeeEntity> data = employeeRepository.findById(id);
		EmployeeEntity employeeEntity = null;
		if (data.isPresent()) {
			employeeEntity = data.get();
		} else {
			throw new RuntimeException("No data available for the given id ");
		}
		return employeeEntity;

	}

	@Override
	public void deleteEmployeeInfo(long id) {
		employeeRepository.deleteById(id);
		System.out.println("Deleted count -- " + employeeRepository.count());
	}

	@Override
	public Page<EmployeeEntity> findPageProperty(int pageNo, int pageSize, String sortField, String sortDirection) {

		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();
		

		Pageable page = PageRequest.of(pageNo - 1, pageSize, sort);
		return employeeRepository.findAll(page);
	}

}
