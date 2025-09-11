package com.example.demo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class CsvService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Value("${csv.output.directory:./csv_files}")
    private String outputDirectory;

    public void gerarCsvFuncionariosDepartamentos() {
        List<FuncionarioDepartamentoDTO> resultados = funcionarioRepository.findFuncionariosComDepartamentosNativo();
        escreverDadosNoCsv(resultados);
    }


    private void escreverDadosNoCsv(List<FuncionarioDepartamentoDTO> funcionarios) {

        String outputDirectory = "csv_files";
        java.nio.file.Path pasta = java.nio.file.Paths.get(outputDirectory);
        if (!java.nio.file.Files.exists(pasta)) {
            try {
                java.nio.file.Files.createDirectories(pasta);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao criar diretório: " + e.getMessage());
            }
        }

        java.nio.file.Path caminhoArquivo = pasta.resolve("funcionarios.csv");

        try (PrintWriter writer = new PrintWriter(caminhoArquivo.toFile());
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.builder()
                     .setDelimiter(';').build())) {

            funcionarios.forEach(funcionario -> {
                try {
                    csvPrinter.printRecord(
                            funcionario.getId(),
                            funcionario.getCargo(),
                            funcionario.getNomeFuncionario(),
                            funcionario.getMatricula(),
                            funcionario.getDepartamentoNome(),
                            funcionario.getDepartamentoDescricao()
                    );
                } catch (IOException e) {
                    throw new RuntimeException("Erro ao escrever registro no CSV: " + e.getMessage());
                }
            });

            csvPrinter.flush();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar CSV: " + e.getMessage());
        }
    }
}
