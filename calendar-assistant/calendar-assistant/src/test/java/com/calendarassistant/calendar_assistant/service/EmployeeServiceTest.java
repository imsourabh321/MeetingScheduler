package com.calendarassistant.calendar_assistant.service;


import com.calendarassistant.calendar_assistant.dao.EmployeeRepository;
import com.calendarassistant.calendar_assistant.modal.Employee;
import com.calendarassistant.calendar_assistant.service.EmployeeServiceImpl;
import com.calendarassistant.calendar_assistant.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        Employee employee = new Employee();
        employee.setId(1L);

        when(employeeRepository.findById(1L)).thenReturn(employee);

        Employee foundEmployee = employeeService.findById(1L);

        assertNotNull(foundEmployee);
        assertEquals(1L, foundEmployee.getId());
        verify(employeeRepository, times(1)).findById(1L);
    }

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setId(1L);

        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee savedEmployee = employeeService.save(employee);

        assertNotNull(savedEmployee);
        assertEquals(1L, savedEmployee.getId());
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(employeeRepository).deleteById(1L);

        employeeService.deleteById(1L);

        verify(employeeRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testFindAll() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> foundEmployees = employeeService.findAll();

        assertNotNull(foundEmployees);
        assertEquals(1, foundEmployees.size());
        verify(employeeRepository, times(1)).findAll();
    }
}
