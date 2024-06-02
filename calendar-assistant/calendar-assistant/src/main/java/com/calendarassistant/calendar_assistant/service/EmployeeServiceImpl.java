package com.calendarassistant.calendar_assistant.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.calendarassistant.calendar_assistant.dao.EmployeeRepository;
import com.calendarassistant.calendar_assistant.exception.NotFoundException;
import com.calendarassistant.calendar_assistant.modal.Employee;

@Service
class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(Long id) throws NotFoundException {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}