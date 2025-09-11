package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, FuncionarioId> {
    
    @Query(value = "SELECT f.*, d.nome as departamento_nome, d.descricao as departamento_descricao " +
            "FROM mydb.funcionarios f INNER JOIN mydb.departamentos d ON d.codigo = f.departamento_codigo",
            nativeQuery = true)
    List<FuncionarioDepartamentoDTO> findFuncionariosComDepartamentosNativo();


    @Query(value = "SELECT " +
            "f.departamento_codigo as departamentoCodigo," +
            "f.matricula," +
            "f.cargo," +
            "f.nome as nome_funcionario," +
            "d.nome as departamento_nome," +
            "d.descricao as departamento_descricao " +
            "FROM mydb.funcionarios f INNER JOIN mydb.departamentos d ON d.codigo = f.departamento_codigo",
            nativeQuery = true)
    List<FuncionarioDepartamentoEntity> findFuncionariosComDepartamentosProject();
}


