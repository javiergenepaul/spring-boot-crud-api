package com.crudpractice.crud.controller;

import com.crudpractice.crud.model.Employee;
import com.crudpractice.crud.model.Project;
import com.crudpractice.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
    @PostMapping
    public Employee create(@RequestBody Employee employee) {
         return employeeService.create(employee);
    }
    @PutMapping("/{empId}/project/{projectId}")
    public Employee assignProjectToEmployee(@PathVariable("empId") Long empId, @PathVariable("projectId") Long projectId) {
//        return projectId;
        return employeeService.assignProjectToEmployee(empId, projectId);
    }
}
