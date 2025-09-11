package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class Controller {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CsvService csvService;

    @Autowired
    private CsvS3Service csvS3Service;


    @GetMapping("/com-departamentos")
    public ResponseEntity<List<FuncionarioDepartamentoDTO>> getFuncionariosComDepartamentos() {
        List<FuncionarioDepartamentoDTO> resultados = funcionarioRepository.findFuncionariosComDepartamentosNativo();
        return ResponseEntity.ok(resultados);
    }


    @GetMapping("/exportar-csv")
    public ResponseEntity<Void> processarCsvFuncionarios() {
        csvService.gerarCsvFuncionariosDepartamentos();
        return null;
    }

    @GetMapping("/gerar-csv")
    public ResponseEntity<String> gerarCsv() {
        List<FuncionarioDepartamentoEntity> funcionariosEntity = funcionarioRepository.findFuncionariosComDepartamentosProject();
        String fileName = "funcionarios_" + System.currentTimeMillis() + ".csv";
        csvS3Service.generateAndUploadCsv(funcionariosEntity, fileName);
        return ResponseEntity.ok("Arquivo " + fileName + " gerado e enviado para S3!");
    }
}
