package com.freebird.web.service;

import com.freebird.web.domain.Employee;
import com.freebird.web.domain.form.EmployeeForm;

public interface HomeService {
	
	public Employee getEmployee(EmployeeForm form);
}
