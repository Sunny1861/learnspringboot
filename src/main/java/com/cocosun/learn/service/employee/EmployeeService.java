package com.cocosun.learn.service.employee;

import com.cocosun.learn.exception.ResourceNotFoundException;
import com.cocosun.learn.model.employee.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final Map<Long, Employee> employeeMap = new HashMap<>();
    private long idCounter = 1;

    public Employee save(Employee employee) {
        employee.setId(idCounter++);
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public Employee findById(Long id) {
        return Optional.ofNullable(employeeMap.get(id))
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employeeMap.values());
    }
}
