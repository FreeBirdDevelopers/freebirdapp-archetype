package com.freebird.web.dao.jpa;

import java.util.List;

import com.freebird.web.domain.Employee;


public interface CacheDao {
	
	public List<Employee> getEmployees();
}