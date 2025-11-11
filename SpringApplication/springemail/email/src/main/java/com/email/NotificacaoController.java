package com.email;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

    private final EmailService emailService;

    public NotificacaoController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/enviar")
    public String enviarNotificacao(@RequestBody NotificacaoRequest request) {
        try {
            emailService.enviarNotificacao(
                    request.getDestinatario(),
                    request.getAssunto(),
                    request.getNomeUsuario(),
                    request.getMensagem(),
                    request.getDataEvento(),
                    request.getUrlBotao(),
                    request.getTextoBotao(),
                    request.getDetalhes()
            );
            return "Notificação enviada com sucesso!";
        } catch (Exception e) {
            return "Erro ao enviar notificação: " + e.getMessage();
        }
    }

    @PostMapping("/exemplo")
    public String enviarExemplo() {
        List<String> detalhes = Arrays.asList(
                "Sistema atualizado para versão 2.0",
                "Novos recursos disponíveis",
                "Manutenção programada para o próximo sábado"
        );

        emailService.enviarNotificacao(
                "usuario@exemplo.com",
                "Atualização do Sistema - Versão 2.0",
                "João Silva",
                "Temos o prazer de informar que o sistema foi atualizado com novas funcionalidades.",
                LocalDateTime.now().plusDays(1),
                "https://meusistema.com/dashboard",
                "Acessar Sistema",
                detalhes
        );

        return "E-mail de exemplo enviado!";
    }

    // Classe interna para receber os dados da requisição
    public static class NotificacaoRequest {
        private String destinatario;
        private String assunto;
        private String nomeUsuario;
        private String mensagem;
        private LocalDateTime dataEvento;
        private String urlBotao;
        private String textoBotao;
        private List<String> detalhes;

        // Getters e Setters
        public String getDestinatario() { return destinatario; }
        public void setDestinatario(String destinatario) { this.destinatario = destinatario; }

        public String getAssunto() { return assunto; }
        public void setAssunto(String assunto) { this.assunto = assunto; }

        public String getNomeUsuario() { return nomeUsuario; }
        public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

        public String getMensagem() { return mensagem; }
        public void setMensagem(String mensagem) { this.mensagem = mensagem; }

        public LocalDateTime getDataEvento() { return dataEvento; }
        public void setDataEvento(LocalDateTime dataEvento) { this.dataEvento = dataEvento; }

        public String getUrlBotao() { return urlBotao; }
        public void setUrlBotao(String urlBotao) { this.urlBotao = urlBotao; }

        public String getTextoBotao() { return textoBotao; }
        public void setTextoBotao(String textoBotao) { this.textoBotao = textoBotao; }

        public List<String> getDetalhes() { return detalhes; }
        public void setDetalhes(List<String> detalhes) { this.detalhes = detalhes; }
    }
}
