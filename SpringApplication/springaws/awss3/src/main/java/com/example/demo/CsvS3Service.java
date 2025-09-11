package com.example.demo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.util.List;

@Service
public class CsvS3Service {

    private final S3Client s3Client;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    public CsvS3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public void generateAndUploadCsv(List<FuncionarioDepartamentoEntity> funcionarios, String fileName) {
        // Gerar CSV em memória
        byte[] csvData = generateCsvBytes(funcionarios);
        uploadToS3(fileName, csvData);
    }

    private byte[] generateCsvBytes(List<FuncionarioDepartamentoEntity> funcionarios) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter printer = new CSVPrinter(
                     new PrintWriter(out), CSVFormat.DEFAULT.builder().setDelimiter(';').build())) {

            funcionarios.forEach(func -> {
                try {
                    printer.printRecord(
                            func.getDepartamentoCodigo(),
                            func.getCargo(),
                            func.getNomeFuncionario(),
                            func.getMatricula(),
                            func.getDepartamentoNome(),
                            func.getDepartamentoDescricao()
                    );
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });

            printer.flush();
            return out.toByteArray();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar CSV", e);
        }
    }

    private void uploadToS3(String fileName, byte[] data) {
        try {

            String s3Key = "outbound/" + fileName;
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(s3Key)
                    .contentType("text/csv")
                    .build();

            s3Client.putObject(putObjectRequest, RequestBody.fromBytes(data));
            System.out.println("Arquivo " + s3Key + " enviado com sucesso para S3.");

        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar arquivo para S3", e);
        }
    }
}