package com.java.project.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.java.project.entity.EmployeeEntity;

public interface EmployeeService {

	public List<EmployeeEntity> getAllEmployees();

	public String insertData();

	public void saveEmployeeInfo(EmployeeEntity entity);

	public EmployeeEntity getEmployeeInfo(long id);

	public void deleteEmployeeInfo(long id);
	
	public Page<EmployeeEntity> findPageProperty(int pageNo, int pageSize, String sortField, String sortDirection);
}
