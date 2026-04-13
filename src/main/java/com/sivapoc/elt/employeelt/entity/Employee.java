package com.sivapoc.elt.employeelt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="EMPLOYEE")
@Data
public class Employee {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="department")
    private String department;
    @Column(name="EMAILID")
    private String emailId;
    @Column(name="MOBILENO")
    private Long mobileNo;


}
