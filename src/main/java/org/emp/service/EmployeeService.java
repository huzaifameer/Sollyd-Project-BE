package org.emp.service;

import org.emp.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    void addEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAll();
    void deleteById(Long id);
    void updateEmployee(EmployeeDto employee);
    EmployeeDto findById(Long id);
    EmployeeDto findByFirstName(String firstName);
}
