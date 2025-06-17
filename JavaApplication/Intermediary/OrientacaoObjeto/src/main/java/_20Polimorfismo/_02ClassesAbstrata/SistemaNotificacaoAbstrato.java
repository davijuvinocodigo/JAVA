package _20Polimorfismo._02ClassesAbstrata;

import java.util.ArrayList;
import java.util.List;

// Classe abstrata base para todas as notificações
abstract class Notificacao {
    protected String destinatario;
    protected String mensagem;

    public Notificacao(String destinatario, String mensagem) {
        this.destinatario = destinatario;
        this.mensagem = mensagem;
    }

    // Método abstrato que deve ser implementado pelas subclasses
    public abstract void enviar();

    // Método concreto que pode ser usado por todas as subclasses
    public String getMensagemFormatada() {
        return "Mensagem: " + mensagem;
    }

    // Outro método concreto
    public String getDestinatario() {
        return destinatario;
    }
}

// Classes concretas de notificação
class NotificacaoEmail extends Notificacao {
    public NotificacaoEmail(String email, String mensagem) {
        super(email, mensagem);
    }

    @Override
    public void enviar() {
        System.out.println("Enviando e-mail para: " + destinatario);
        System.out.println(getMensagemFormatada());
        System.out.println("Assunto: Notificação importante");
        // Lógica específica para e-mail
    }

    // Método específico para e-mail
    public void adicionarAnexo(String anexo) {
        System.out.println("Anexando arquivo: " + anexo + " ao e-mail");
    }
}

class NotificacaoSMS extends Notificacao {
    public NotificacaoSMS(String telefone, String mensagem) {
        super(telefone, mensagem);
    }

    @Override
    public void enviar() {
        System.out.println("Enviando SMS para: " + destinatario);
        System.out.println(getMensagemFormatada());
        // Lógica específica para SMS
    }

    // Método específico para SMS
    public void confirmarLeitura() {
        System.out.println("Solicitando confirmação de leitura do SMS");
    }
}

class NotificacaoPush extends Notificacao {
    private String titulo;

    public NotificacaoPush(String dispositivoId, String mensagem, String titulo) {
        super(dispositivoId, mensagem);
        this.titulo = titulo;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando push para dispositivo: " + destinatario);
        System.out.println("Título: " + titulo);
        System.out.println(getMensagemFormatada());
        // Lógica específica para push notification
    }

    // Método específico para push
    public void definirPrioridade(int nivel) {
        System.out.println("Definindo prioridade da notificação para: " + nivel);
    }
}

// Gerenciador que trabalha com a classe abstrata
class GerenciadorNotificacoes {
    public void enviarTodas(List<Notificacao> notificacoes) {
        System.out.println("\n=== ENVIANDO TODAS AS NOTIFICAÇÕES ===");
        for (Notificacao notificacao : notificacoes) {
            notificacao.enviar();
            System.out.println("---");
        }
    }

    // Método polimórfico
    public void processarNotificacao(Notificacao notificacao) {
        System.out.println("\nProcessando notificação...");
        notificacao.enviar();

        // Verificação do tipo real para métodos específicos
        if (notificacao instanceof NotificacaoEmail) {
            ((NotificacaoEmail) notificacao).adicionarAnexo("documento.pdf");
        } else if (notificacao instanceof NotificacaoSMS) {
            ((NotificacaoSMS) notificacao).confirmarLeitura();
        } else if (notificacao instanceof NotificacaoPush) {
            ((NotificacaoPush) notificacao).definirPrioridade(2);
        }

        System.out.println("Processamento completo!\n");
    }
}

// Classe principal
public class SistemaNotificacaoAbstrato {
    public static void main(String[] args) {
        // Criando o gerenciador
        GerenciadorNotificacoes gerenciador = new GerenciadorNotificacoes();

        // Criando diferentes tipos de notificações
        Notificacao email = new NotificacaoEmail("cliente@empresa.com", "Sua fatura está disponível");
        Notificacao sms = new NotificacaoSMS("+5511988887777", "Confirmação de agendamento");
        Notificacao push = new NotificacaoPush("device_xyz123", "Novas atualizações disponíveis", "Atualização");

        // Usando polimorfismo com classe abstrata
        System.out.println("=== ENVIO INDIVIDUAL ===");
        gerenciador.processarNotificacao(email);
        gerenciador.processarNotificacao(sms);
        gerenciador.processarNotificacao(push);

        // Usando polimorfismo com lista
        List<Notificacao> todasNotificacoes = new ArrayList<>();
        todasNotificacoes.add(email);
        todasNotificacoes.add(sms);
        todasNotificacoes.add(push);

        gerenciador.enviarTodas(todasNotificacoes);

        // Demonstração de métodos da classe base
        System.out.println("\n=== INFORMAÇÕES DAS NOTIFICAÇÕES ===");
        for (Notificacao notificacao : todasNotificacoes) {
            System.out.println("Tipo: " + notificacao.getClass().getSimpleName());
            System.out.println("Destinatário: " + notificacao.getDestinatario());
            System.out.println(notificacao.getMensagemFormatada());
            System.out.println("---");
        }
    }
}

/**
 * Principais Diferenças em Relação à Interface
 *     Classe Abstrata:
 *         Pode conter métodos concretos (implementados) e abstratos
 *         Pode ter campos/propriedades
 *         Pode ter construtores
 *         Estabelece uma relação "é um" mais forte
 *     Vantagens demonstradas:
 *         Reúso de código: Métodos como getMensagemFormatada() são herdados
 *         Estado compartilhado: Campos destinatario e mensagem são comuns a todas
 *         Flexibilidade: Combina implementações fixas com pontos de variação obrigatórios
 */


/**
 * Quando Usar Classe Abstrata vs Interface
 * Use classe abstrata quando:
 *     Há código comum que pode ser compartilhado entre subclasses
 *     Você precisa definir campos comuns
 *     As subclasses têm uma relação forte de "é um" com a classe base
 * Use interface quando:
 *     Você precisa que classes completamente diferentes implementem o mesmo comportamento
 *     Precisa de múltiplas "heranças" de tipo
 *     Quer definir um contrato sem implementação padrão
 * Este exemplo mostra como o polimorfismo funciona com classes abstratas, mantendo todos os benefícios da versão com interface, mas com mais recursos de reutilização de código e estrutura hierárquica.
 */
