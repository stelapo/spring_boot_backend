package com.example.spring_boot_backend.controller;

import com.example.spring_boot_backend.model.Employee;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface EmployeeApi {

    @GetMapping(
            path = "v1/employees",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Employee>> getEmployees();
}
