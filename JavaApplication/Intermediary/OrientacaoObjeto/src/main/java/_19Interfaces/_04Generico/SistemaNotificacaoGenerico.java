package _19Interfaces._04Generico;

import java.util.ArrayList;
import java.util.List;

// Interface genérica para o conteúdo da notificação
interface ConteudoNotificacao<T> {
    T getConteudo();
    void setConteudo(T conteudo);
    String formatar();
}

// Interface genérica para o destinatário
interface Destinatario<D> {
    D getDestinatario();
    void setDestinatario(D destinatario);
    String getIdentificacao();
}

// Interface principal genérica para notificações
interface Notificacao<D, T> extends Destinatario<D>, ConteudoNotificacao<T> {
    void enviar();
    StatusNotificacao getStatus();
}

// Enum para status da notificação
enum StatusNotificacao {
    PENDENTE, ENVIADA, FALHA, ENTREGUE
}

// Implementação de notificação por e-mail
class NotificacaoEmail implements Notificacao<String, String> {
    private String destinatario;
    private String assunto;
    private String mensagem;
    private StatusNotificacao status;

    public NotificacaoEmail(String destinatario, String assunto) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.status = StatusNotificacao.PENDENTE;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando e-mail para: " + destinatario);
        System.out.println("Assunto: " + assunto);
        System.out.println("Mensagem: " + formatar());
        this.status = StatusNotificacao.ENVIADA;
    }

    @Override
    public String getConteudo() {
        return mensagem;
    }

    @Override
    public void setConteudo(String conteudo) {
        this.mensagem = conteudo;
    }

    @Override
    public String formatar() {
        return "E-mail:\nPara: " + destinatario + "\nAssunto: " + assunto + "\n\n" + mensagem;
    }

    @Override
    public String getDestinatario() {
        return destinatario;
    }

    @Override
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String getIdentificacao() {
        return "EMAIL:" + destinatario;
    }

    @Override
    public StatusNotificacao getStatus() {
        return status;
    }

    public void adicionarAnexo(String arquivo) {
        System.out.println("Anexo adicionado: " + arquivo);
    }
}

// Implementação de notificação por SMS
class NotificacaoSMS implements Notificacao<String, String> {
    private String numero;
    private String mensagem;
    private StatusNotificacao status;

    public NotificacaoSMS(String numero) {
        this.numero = numero;
        this.status = StatusNotificacao.PENDENTE;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando SMS para: " + numero);
        System.out.println("Conteúdo: " + formatar());
        this.status = StatusNotificacao.ENVIADA;
    }

    @Override
    public String getConteudo() {
        return mensagem;
    }

    @Override
    public void setConteudo(String conteudo) {
        if (conteudo.length() > 160) {
            System.out.println("Aviso: SMS será truncado para 160 caracteres");
            this.mensagem = conteudo.substring(0, 160);
        } else {
            this.mensagem = conteudo;
        }
    }

    @Override
    public String formatar() {
        return "SMS para " + numero + ": " + mensagem;
    }

    @Override
    public String getDestinatario() {
        return numero;
    }

    @Override
    public void setDestinatario(String destinatario) {
        this.numero = destinatario;
    }

    @Override
    public String getIdentificacao() {
        return "SMS:" + numero;
    }

    @Override
    public StatusNotificacao getStatus() {
        return status;
    }
}

// Implementação de notificação push com conteúdo JSON
class NotificacaoPush implements Notificacao<String, JsonContent> {
    private String dispositivoId;
    private JsonContent conteudo;
    private StatusNotificacao status;

    public NotificacaoPush(String dispositivoId) {
        this.dispositivoId = dispositivoId;
        this.status = StatusNotificacao.PENDENTE;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando push para dispositivo: " + dispositivoId);
        System.out.println("Payload: " + formatar());
        this.status = StatusNotificacao.ENVIADA;
    }

    @Override
    public JsonContent getConteudo() {
        return conteudo;
    }

    @Override
    public void setConteudo(JsonContent conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String formatar() {
        return conteudo != null ? conteudo.toJsonString() : "{}";
    }

    @Override
    public String getDestinatario() {
        return dispositivoId;
    }

    @Override
    public void setDestinatario(String destinatario) {
        this.dispositivoId = destinatario;
    }

    @Override
    public String getIdentificacao() {
        return "PUSH:" + dispositivoId;
    }

    @Override
    public StatusNotificacao getStatus() {
        return status;
    }
}

// Classe para representar conteúdo JSON
class JsonContent {
    private String titulo;
    private String corpo;
    private int prioridade;

    public JsonContent(String titulo, String corpo, int prioridade) {
        this.titulo = titulo;
        this.corpo = corpo;
        this.prioridade = prioridade;
    }

    public String toJsonString() {
        return String.format("{\"titulo\":\"%s\",\"corpo\":\"%s\",\"prioridade\":%d}",
                titulo, corpo, prioridade);
    }
}

// Gerenciador genérico de notificações
class GerenciadorNotificacoes {
    public <D, T> void enviarTodas(List<Notificacao<?, ?>> notificacoes) {
        System.out.println("\n=== ENVIANDO NOTIFICAÇÕES ===");
        for (Notificacao<?, ?> notificacao : notificacoes) {
            try {
                notificacao.enviar();
                System.out.println("---");
            } catch (Exception e) {
                System.err.println("Falha ao enviar notificação: " +
                        notificacao.getIdentificacao());
            }
        }
    }

    public <D, T> List<String> getIdentificacoes(List<Notificacao<?, ?>> notificacoes) {
        List<String> ids = new ArrayList<>();
        for (Notificacao<?, ?> notificacao : notificacoes) {
            ids.add(notificacao.getIdentificacao());
        }
        return ids;
    }

    public <D, T> void imprimirFormatado(Notificacao<D, T> notificacao) {
        System.out.println("\nNotificação formatada:");
        System.out.println(notificacao.formatar());
    }
}

// Classe principal
public class SistemaNotificacaoGenerico {
    public static void main(String[] args) {
        // Criando o gerenciador
        GerenciadorNotificacoes gerenciador = new GerenciadorNotificacoes();

        // Criando notificações de diferentes tipos
        Notificacao<String, String> email = new NotificacaoEmail("cliente@exemplo.com", "Promoção especial");
        email.setConteudo("Confira nossas novas ofertas exclusivas!");

        Notificacao<String, String> sms = new NotificacaoSMS("+5511987654321");
        sms.setConteudo("Seu código de acesso é 654321");

        Notificacao<String, JsonContent> push = new NotificacaoPush("device-xyz-123");
        push.setConteudo(new JsonContent("Atualização", "Nova versão disponível", 2));

        // Lista de notificações genéricas
        List<Notificacao<?, ?>> notificacoes = new ArrayList<>();
        notificacoes.add(email);
        notificacoes.add(sms);
        notificacoes.add(push);

        // Enviando notificações
        gerenciador.enviarTodas(notificacoes);

        // Obtendo identificações
        System.out.println("\nIdentificações das notificações:");
        List<String> ids = gerenciador.getIdentificacoes(notificacoes);
        ids.forEach(System.out::println);

        // Imprimindo formatado
        gerenciador.imprimirFormatado(email);
        gerenciador.imprimirFormatado(push);
    }
}
