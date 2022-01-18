package com.example.spring_boot_backend.controller;

import com.example.spring_boot_backend.model.Employee;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface EmployeeApi {

    @RequestMapping(
            method = RequestMethod.GET,
            path = "list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Employee>> getEmployees();
}
