package org.emp.service;

import org.emp.dto.EmployeeDto;
import org.emp.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    void addEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAll();
    void deleteById(Long id);
}
