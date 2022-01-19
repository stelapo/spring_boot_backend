package com.example.spring_boot_backend.controller;

import com.example.spring_boot_backend.model.Employee;
import com.example.spring_boot_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "${api.base-path:/api}")
public class EmployeeApiController implements EmployeeApi {

    private final EmployeeService employeeService;

    public EmployeeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> createEmployee(Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(Long employeeId, Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeId, employee), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
