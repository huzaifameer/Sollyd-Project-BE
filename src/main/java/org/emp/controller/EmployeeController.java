package org.emp.controller;

import lombok.RequiredArgsConstructor;
import org.emp.dto.EmployeeDto;
import org.emp.entity.EmployeeEntity;
import org.emp.service.EmployeeService;
import org.emp.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor
public class EmployeeController {
    final EmployeeService employeeService;

    @PostMapping("/add-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.addEmployee(employeeDto);
    }

    @GetMapping("/get-all")
    public List<EmployeeDto> getAll(){
        return employeeService.getAll();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        employeeService.deleteById(id);
        return "Deleted";
    }
}
