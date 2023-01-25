package com.crudpractice.crud.service;

import com.crudpractice.crud.model.Employee;
import com.crudpractice.crud.model.Project;
import com.crudpractice.crud.repository.EmployeeRepository;
import com.crudpractice.crud.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee assignProjectToEmployee(Long empId, Long projectId) {
        Set<Project> projectSet = null;
        Employee employee = employeeRepository.findById(empId).get();
        Project project = projectRepository.findById(projectId).get();
        projectSet = employee.getAssignedProjects();
        projectSet.add(project);
        employee.setAssignedProjects(projectSet);
        return employeeRepository.save(employee);
    }
}
