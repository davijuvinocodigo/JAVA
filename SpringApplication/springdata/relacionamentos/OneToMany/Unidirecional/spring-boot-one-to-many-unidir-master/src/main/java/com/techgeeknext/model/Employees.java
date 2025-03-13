package com.techgeeknext.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_seq_gen")
    @SequenceGenerator(name = "employees_seq_gen", sequenceName = "emp_seq")
    private long id;

    @Column(name = "name")
    private String name;
}
