package com.example.spring_boot_backend.service;

import com.example.spring_boot_backend.ResourceNotFound;
import com.example.spring_boot_backend.model.Employee;
import com.example.spring_boot_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(
                        () -> new ResourceNotFound("Resource Not Found")
                );
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee.getId() != null)
            employee.setId(null);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        return employeeRepository
                .findById(employeeId)
                .map((employee1) -> {
                    employee.setId(employee1.getId());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(
                        () -> new ResourceNotFound("Resource Not Found")
                );
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository
                .findById(employeeId)
                .map((employee1) -> {
                    employeeRepository.delete(employee1);
                    return employee1;
                })
                .orElseThrow(
                        () -> new ResourceNotFound("Resource Not Found")
                );
    }

}
