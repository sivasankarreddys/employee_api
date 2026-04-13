package com.sivapoc.elt.employeelt.service;

import com.sivapoc.elt.employeelt.entity.Employee;
import com.sivapoc.elt.employeelt.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public Employee saveEmp(Employee emp){
       // emp.setId(null);
        return employeeRepository.save(emp);
    }
    public List<Employee> getAllEmp(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmpById(Long id){
        return employeeRepository.findById(id);
    }
    public void deleteEmp(Long id){
        employeeRepository.deleteById(id);
    }
    public Employee updateEmp(Long id, Employee empDetails){
        Employee e = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("employee not found"));
        e.setName(empDetails.getName());
        e.setDepartment(empDetails.getDepartment());
        e.setEmailId(empDetails.getEmailId());
        e.setMobileNo(empDetails.getMobileNo());
        return employeeRepository.save(e);
    }
}
