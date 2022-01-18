package com.example.spring_boot_backend;

import com.example.spring_boot_backend.model.Employee;
import com.example.spring_boot_backend.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
public class SpringBootBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBackendApplication.class, args);
    }

    @Bean
    @Profile("dev")
    public CommandLineRunner loadData(EmployeeRepository repository) {
        return args -> {
            Employee e = new Employee();
            e.setFirstName("Mario");
            e.setLastName("Rossi");
            e.setEmail("m.rossi@pluto.yar");
            e.setBirthday(LocalDate.of(1982, 5, 1));
            repository.save(e);
        };
    }
}
