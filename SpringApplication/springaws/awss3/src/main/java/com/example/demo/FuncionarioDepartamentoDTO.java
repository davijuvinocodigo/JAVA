package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FuncionarioDepartamentoDTO {

    private String id;
    private String matricula;
    private String cargo;
    private String nomeFuncionario;
    private String departamentoNome;
    private String departamentoDescricao;

}
