package com.example.spring_boot_backend.controller;

import com.example.spring_boot_backend.model.Employee;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
public interface EmployeeApi {

    @GetMapping(
            path = "v1/employees",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Employee>> getEmployees();

    @PostMapping(
            path = "v1/employee",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Employee> createEmployee(@RequestBody Employee employee);

    @PutMapping(
            path = "v1/employee/{employeeId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employee);

    @DeleteMapping(
            path = "v1/employee/{employeeId}"
    )
    ResponseEntity<Void> deleteEmployee(@PathVariable("employeeId") Long employeeId);
}
