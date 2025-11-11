package com.email;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public EmailService(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    public void enviarNotificacao(String destinatario, String assunto,
                                  String nomeUsuario, String mensagem,
                                  LocalDateTime dataEvento, String urlBotao,
                                  String textoBotao, List<String> detalhes) {

        try {
            // Preparar o contexto do template
            Context context = new Context(new Locale("pt", "BR"));
            context.setVariable("titulo", "Notificação do Sistema");
            context.setVariable("nomeUsuario", nomeUsuario);
            context.setVariable("mensagem", mensagem);
            context.setVariable("dataEvento", dataEvento);
            context.setVariable("urlBotao", urlBotao);
            context.setVariable("textoBotao", textoBotao);
            context.setVariable("detalhes", detalhes);
            context.setVariable("dataEnvio", LocalDateTime.now());

            // Processar o template
            String htmlContent = templateEngine.process("email-notificacao", context);

            // Criar e enviar a mensagem
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(destinatario);
            helper.setSubject(assunto);
            helper.setText(htmlContent, true); // true = HTML

            mailSender.send(mimeMessage);

            System.out.println("E-mail enviado com sucesso para: " + destinatario);

        } catch (MessagingException e) {
            throw new RuntimeException("Falha ao enviar e-mail", e);
        }
    }

    // Método simplificado para uso rápido
    public void enviarNotificacaoSimples(String destinatario, String nomeUsuario, String mensagem) {
        enviarNotificacao(
                destinatario,
                "Notificação do Sistema",
                nomeUsuario,
                mensagem,
                LocalDateTime.now(),
                null,
                null,
                null
        );
    }
}
