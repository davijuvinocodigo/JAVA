package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departamentos")
public class Departamento {
    @Id
    private String codigo;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionarios;
}
