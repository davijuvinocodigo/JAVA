package com.musicstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String title;
    @Column(name = "reports_to")
    private Integer reportsTo;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "hire_date")
    private Date hireDate;
    private String address;
    private String city;
    private String state;
    private String country;
    @Column(name = "postal_code")
    private String postalCode;
    private String phone;
    private String fax;
    private String email;

    @ManyToOne
    @JoinColumn(name = "reports_to", referencedColumnName = "employee_id", insertable = false, updatable = false)
    private Employee supervisor;

}
