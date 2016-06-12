package com.freebird.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.freebird.web.domain.Employee;
import com.freebird.web.domain.form.EmployeeForm;

@Service("homeService")
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	@Qualifier("cacheService")
	CacheService cacheService;
	
	public Employee getEmployee(EmployeeForm form) {
		Employee employee = cacheService.getEmployeeMap().get(form.getId() == null?1:form.getId());
		return employee;
	}
}