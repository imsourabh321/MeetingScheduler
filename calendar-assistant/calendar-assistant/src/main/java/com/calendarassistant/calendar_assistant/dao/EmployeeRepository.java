package com.calendarassistant.calendar_assistant.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.calendarassistant.calendar_assistant.exception.NotFoundException;
import com.calendarassistant.calendar_assistant.modal.Employee;

public interface EmployeeRepository {
    Employee findById(Long id) throws NotFoundException;
    Employee save(Employee employee);
    void deleteById(Long id);
	List<Employee> findAll();
}