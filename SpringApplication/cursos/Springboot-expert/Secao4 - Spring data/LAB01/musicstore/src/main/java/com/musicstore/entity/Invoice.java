package com.musicstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_id")
    private Integer invoiceId;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "invoice_date")
    private Date invoiceDate;
    @Column(name = "billing_address")
    private String billingAddress;
    @Column(name = "billing_city")
    private String billingCity;
    @Column(name = "billing_state")
    private String billingState;
    @Column(name = "billing_country")
    private String billingCountry;
    @Column(name = "billing_postal_code")
    private String billingPostalCode;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    private Customer customer;
}
