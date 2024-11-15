package org.emp.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.EmployeeDto;
import org.emp.entity.EmployeeEntity;
import org.emp.repository.EmployeeRepository;
import org.emp.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    final EmployeeRepository repository;
    List<EmployeeDto> employeeList = new ArrayList<>();
    @Override
    public void addEmployee(EmployeeDto employee) {
        employeeList.add(employee);
        EmployeeEntity employeeEntity = new ObjectMapper().convertValue(employee, EmployeeEntity.class);
        repository.save(employeeEntity);
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<EmployeeDto> employeeList = new ArrayList<>();

        List<EmployeeEntity> employeeEntityList = repository.findAll();
        employeeEntityList.forEach(employeeEntity -> {
            EmployeeDto employee = new ObjectMapper().convertValue(employeeEntity, EmployeeDto.class);
            employeeList.add(employee);
        });
        return employeeList;
    }

    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public void updateEmployee(EmployeeDto employee) {
        if (repository.findById(employee.getId()).isPresent()){
            repository.save(new ObjectMapper().convertValue(employee,EmployeeEntity.class));
        }
    }

    @Override
    public EmployeeDto findById(Long id) {
        if (repository.findById(id).isPresent()){
            Optional<EmployeeEntity> byId = repository.findById(id);
            return new ObjectMapper().convertValue(byId.get(),EmployeeDto.class);
        }
        return new EmployeeDto();
    }

    @Override
    public EmployeeDto findByFirstName(String firstName) {
        return new ObjectMapper().convertValue(repository.findByFirstName(firstName),EmployeeDto.class);
    }
}
