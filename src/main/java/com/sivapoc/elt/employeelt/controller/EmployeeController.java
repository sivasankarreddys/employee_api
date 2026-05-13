package com.sivapoc.elt.employeelt.controller;

import com.sivapoc.elt.employeelt.entity.Employee;
import com.sivapoc.elt.employeelt.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;
    @PostMapping()
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmp((employee));
    }
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmp();
    }
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
      return employeeService.getEmpById(id);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        return employeeService.updateEmp(id,employee);
    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmp(id);
        return "deleted Employee successfully";
    }


}
