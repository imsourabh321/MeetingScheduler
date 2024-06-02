package com.calendarassistant.calendar_assistant.dao;

import com.calendarassistant.calendar_assistant.exception.NotFoundException;
import com.calendarassistant.calendar_assistant.modal.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository {
    private final Map<Long, Employee> employees = new HashMap<>();
    private static Long idCounter = 0L;

    @Override
    public Employee findById(Long id) throws NotFoundException {
        Employee employee = employees.get(id);
        if (employee == null) {
            throw new NotFoundException("Employee not found with id: " + id);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(++idCounter);
        }
        employees.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public void deleteById(Long id) {
        employees.remove(id);
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }
}
