package com.musicstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String company;
    private String address;
    private String city;
    private String state;
    private String country;
    @Column(name = "postal_code")
    private String postalCode;
    private String phone;
    private String fax;
    private String email;
    @Column(name = "support_rep_id")
    private Integer supportRepId;

    @ManyToOne
    @JoinColumn(name = "support_rep_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    private Employee supportRep;
}
