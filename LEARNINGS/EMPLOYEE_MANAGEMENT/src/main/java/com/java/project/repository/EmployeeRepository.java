package com.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.project.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	// JpaRepository<EntityClass, Type of Primary Key>
	// Following are the built in methods of jpa repository
	// findAll(), save(), count(), deleteAllInBatch().

}
