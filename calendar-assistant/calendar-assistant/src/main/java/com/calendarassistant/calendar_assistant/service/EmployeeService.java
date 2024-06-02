package com.calendarassistant.calendar_assistant.service;

import java.util.List;

import com.calendarassistant.calendar_assistant.exception.NotFoundException;
import com.calendarassistant.calendar_assistant.modal.Employee;

public interface EmployeeService {
    Employee findById(Long id) throws NotFoundException;
    Employee save(Employee employee);
    void deleteById(Long id);
    List<Employee> findAll();
}
