package com.melo567.presence.check.services;

import com.melo567.presence.check.models.Employee;
import com.melo567.presence.check.repositories.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public Employee create(Employee employee) {
        return employeeDAO.save(employee);
    }

    public Iterable<Employee> getAllEmployee() {
        return employeeDAO.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeDAO.findById(id).orElseThrow(RuntimeException::new);
    }

    public Employee update(Employee employee) {
        return employeeDAO.save(employee);
    }

    public void delete(Long id) {
        employeeDAO.deleteById(id);
    }

    public void delete(Employee employee) {
        employeeDAO.delete(employee);
    }
}
