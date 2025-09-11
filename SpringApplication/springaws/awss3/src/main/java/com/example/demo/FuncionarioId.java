package com.example.demo;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class FuncionarioId implements Serializable {

    private String departamentoCodigo;
    private String matricula;

}
