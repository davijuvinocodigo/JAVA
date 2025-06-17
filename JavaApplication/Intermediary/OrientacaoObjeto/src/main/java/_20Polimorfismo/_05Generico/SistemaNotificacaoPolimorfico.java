package _20Polimorfismo._05Generico;

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

    // Método default - exemplo de polimorfismo em interfaces
    default void marcarComoPrioritaria() {
        System.out.println("Marcando notificação como prioritária: " + getIdentificacao());
    }
}

// Enum para status da notificação
enum StatusNotificacao {
    PENDENTE, ENVIADA, FALHA, ENTREGUE;

    // Método em enum - outro exemplo de polimorfismo
    public String getDescricao() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}

// Classe abstrata base - demonstra polimorfismo com herança
abstract class NotificacaoBase<D, T> implements Notificacao<D, T> {
    protected D destinatario;
    protected T conteudo;
    protected StatusNotificacao status;

    public NotificacaoBase(D destinatario) {
        this.destinatario = destinatario;
        this.status = StatusNotificacao.PENDENTE;
    }

    @Override
    public D getDestinatario() {
        return destinatario;
    }

    @Override
    public void setDestinatario(D destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public T getConteudo() {
        return conteudo;
    }

    @Override
    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public StatusNotificacao getStatus() {
        return status;
    }

    // Método abstrato para formatação específica
    public abstract String formatar();
}

// Implementação concreta para e-mail
class NotificacaoEmail extends NotificacaoBase<String, String> {
    private String assunto;

    public NotificacaoEmail(String destinatario, String assunto) {
        super(destinatario);
        this.assunto = assunto;
    }

    @Override
    public void enviar() {
        System.out.println("[EMAIL] Enviando para: " + destinatario);
        System.out.println("Assunto: " + assunto);
        System.out.println("Corpo: " + formatar());
        status = StatusNotificacao.ENVIADA;
    }

    @Override
    public String formatar() {
        return "Prezado cliente,\n\n" + conteudo + "\n\nAtenciosamente,\nEquipe";
    }

    @Override
    public String getIdentificacao() {
        return "EMAIL:" + destinatario;
    }

    // Método específico - exemplo de polimorfismo por especialização
    public void adicionarAssinatura(String assinatura) {
        conteudo += "\n\n" + assinatura;
    }
}

// Implementação concreta para SMS
class NotificacaoSMS extends NotificacaoBase<String, String> {
    public NotificacaoSMS(String numero) {
        super(numero);
    }

    @Override
    public void enviar() {
        System.out.println("[SMS] Enviando para: " + destinatario);
        System.out.println("Conteúdo: " + formatar());
        status = StatusNotificacao.ENVIADA;
    }

    @Override
    public String formatar() {
        return conteudo.length() > 160 ? conteudo.substring(0, 157) + "..." : conteudo;
    }

    @Override
    public String getIdentificacao() {
        return "SMS:" + destinatario;
    }

    @Override
    public void setConteudo(String conteudo) {
        if (conteudo.length() > 160) {
            System.out.println("Aviso: SMS será truncado para 160 caracteres");
        }
        super.setConteudo(conteudo);
    }
}

// Implementação concreta para notificação push
class NotificacaoPush extends NotificacaoBase<String, JsonContent> {
    public NotificacaoPush(String dispositivoId) {
        super(dispositivoId);
    }

    @Override
    public void enviar() {
        System.out.println("[PUSH] Enviando para dispositivo: " + destinatario);
        System.out.println("Payload: " + formatar());
        status = StatusNotificacao.ENVIADA;
    }

    @Override
    public String formatar() {
        return conteudo != null ? conteudo.toJsonString() : "{}";
    }

    @Override
    public String getIdentificacao() {
        return "PUSH:" + destinatario;
    }

    // Sobrescrita do método default da interface
    @Override
    public void marcarComoPrioritaria() {
        System.out.println("Definindo prioridade alta para push");
        if (conteudo != null) {
            conteudo.setPrioridade(1);
        }
    }
}

// Classe para conteúdo JSON
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

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}

// Gerenciador de notificações com polimorfismo
class GerenciadorNotificacoes {

    // Método polimórfico que aceita qualquer Notificacao
    public void enviarNotificacao(Notificacao<?, ?> notificacao) {
        System.out.println("\nIniciando envio...");
        System.out.println("Tipo: " + notificacao.getClass().getSimpleName());
        notificacao.enviar();
        System.out.println("Status: " + notificacao.getStatus().getDescricao());
    }

    // Método genérico polimórfico para lista de notificações
    public <D, T> void enviarTodas(List<Notificacao<?, ?>> notificacoes) {
        System.out.println("\n=== ENVIANDO LOTE ===");
        notificacoes.forEach(this::enviarNotificacao);
    }

    // Método que demonstra polimorfismo com chamada de método específico
    public void processarEspecializacoes(Notificacao<?, ?> notificacao) {
        notificacao.marcarComoPrioritaria();

        if (notificacao instanceof NotificacaoEmail) {
            ((NotificacaoEmail) notificacao).adicionarAssinatura("Assinatura Digital");
        }
    }
}

// Classe principal demonstrando polimorfismo
public class SistemaNotificacaoPolimorfico {
    public static void main(String[] args) {
        // Criando notificações de diferentes tipos
        Notificacao<String, String> email = new NotificacaoEmail("cliente@exemplo.com", "Confirmação");
        email.setConteudo("Seu pedido foi confirmado com sucesso.");

        Notificacao<String, String> sms = new NotificacaoSMS("+5511987654321");
        sms.setConteudo("Seu código de verificação é 987654. Não compartilhe.");

        Notificacao<String, JsonContent> push = new NotificacaoPush("device-abc-123");
        push.setConteudo(new JsonContent("Atualização", "Nova mensagem recebida", 2));

        // Criando gerenciador
        GerenciadorNotificacoes gerenciador = new GerenciadorNotificacoes();

        // Demonstração de polimorfismo - tratando diferentes tipos de forma uniforme
        System.out.println("=== ENVIO INDIVIDUAL (POLIMORFISMO) ===");
        gerenciador.enviarNotificacao(email);
        gerenciador.enviarNotificacao(sms);
        gerenciador.enviarNotificacao(push);

        // Lista polimórfica
        List<Notificacao<?, ?>> notificacoes = new ArrayList<>();
        notificacoes.add(email);
        notificacoes.add(sms);
        notificacoes.add(push);

        // Envio em lote polimórfico
        System.out.println("\n=== ENVIO EM LOTE (POLIMORFISMO) ===");
        gerenciador.enviarTodas(notificacoes);

        // Processando especializações
        System.out.println("\n=== PROCESSAMENTO ESPECÍFICO ===");
        notificacoes.forEach(gerenciador::processarEspecializacoes);

        // Chamando método sobrescrito
        System.out.println("\n=== MÉTODO SOBRESCRITO ===");
        push.marcarComoPrioritaria();

        // Demonstração de polimorfismo com enum
        System.out.println("\n=== STATUS DAS NOTIFICAÇÕES ===");
        notificacoes.forEach(n ->
                System.out.println(n.getIdentificacao() + ": " + n.getStatus().getDescricao())
        );
    }
}


/**
 * Vou aprimorar o sistema anterior, destacando explicitamente o polimorfismo em ação com interfaces genéricas. O polimorfismo permite que objetos de diferentes classes sejam tratados de maneira uniforme através de uma interface comum.
 */

/**
 * Como o Polimorfismo é Aplicado
 *     Polimorfismo de Interface:
 *         Todas as notificações implementam Notificacao<D, T>
 *         O gerenciador trabalha com a interface, não com implementações concretas
 *     Polimorfismo de Herança:
 *         NotificacaoBase fornece implementação comum
 *         Classes derivadas especializam o comportamento
 *     Polimorfismo de Métodos:
 *         enviar() e formatar() têm implementações diferentes em cada classe
 *         marcarComoPrioritaria() demonstra método default e sobrescrita
 *     Polimorfismo com Genéricos:
 *         Métodos genéricos no gerenciador aceitam qualquer tipo de notificação
 *         Segurança de tipos mantida em tempo de compilação
 *     Polimorfismo em Enums:
 *         getDescricao() fornece comportamento polimórfico para status
 */

/**
 * Este exemplo demonstra como combinar polimorfismo com interfaces genéricas para criar um sistema flexível e type-safe, onde diferentes tipos de notificações podem ser tratadas de forma uniforme, enquanto cada uma mantém seu comportamento específico.
 */