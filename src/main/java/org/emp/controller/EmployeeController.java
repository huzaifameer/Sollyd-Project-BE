package org.emp.controller;

import lombok.RequiredArgsConstructor;
import org.emp.dto.EmployeeDto;
import org.emp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin
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
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteById(@PathVariable Long id){
        employeeService.deleteById(id);
        return "Successfully Deleted.. !";
    }

    @PutMapping("/update-employee")
    public void updateEmployee(@RequestBody EmployeeDto employee){
        employeeService.updateEmployee(employee);
    }

    @GetMapping("/find-by-id/{id}")
    public EmployeeDto findById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @GetMapping("/find-by-fname/{firstName}")
    public EmployeeDto findByFiName(@PathVariable String firstName){
        return employeeService.findByFirstName(firstName);
    }
}
