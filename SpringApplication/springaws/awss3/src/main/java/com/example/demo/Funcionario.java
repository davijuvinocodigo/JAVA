package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "funcionarios")
public class Funcionario {

    @EmbeddedId
    private FuncionarioId id;
    private String nome;
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "departamentoCodigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    private Departamento departamento;

    public Funcionario() {
    }

    public Funcionario(FuncionarioId id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }

}