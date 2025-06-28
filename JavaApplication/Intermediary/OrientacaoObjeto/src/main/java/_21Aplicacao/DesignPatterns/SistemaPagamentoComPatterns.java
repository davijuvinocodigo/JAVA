package _21Aplicacao.DesignPatterns;

import java.util.HashMap;
import java.util.Map;

// 1. STRATEGY PATTERN - Para algoritmos de pagamento
interface PagamentoStrategy {
    void processarPagamento(double valor);
    String obterDetalhes();
}

// Implementações concretas das estratégias
class CartaoCreditoStrategy implements PagamentoStrategy {
    private String numero;
    private String dataValidade;
    private String cvv;

    public CartaoCreditoStrategy(String numero, String dataValidade, String cvv) {
        this.numero = numero;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Cartão de Crédito");
        System.out.println("Número: " + numero.substring(0, 4) + " **** **** ****");
    }

    @Override
    public String obterDetalhes() {
        return "Cartão de Crédito - Final " + numero.substring(numero.length() - 4);
    }
}

class PixStrategy implements PagamentoStrategy {
    private String chave;

    public PixStrategy(String chave) {
        this.chave = chave;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via PIX");
        System.out.println("Chave: " + chave);
    }

    @Override
    public String obterDetalhes() {
        return "PIX - Chave: " + (chave.length() > 10 ? chave.substring(0, 10) + "..." : chave);
    }
}

class BoletoStrategy implements PagamentoStrategy {
    private String codigoBarras;

    public BoletoStrategy(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Boleto Bancário");
        System.out.println("Código de Barras: " + codigoBarras);
    }

    @Override
    public String obterDetalhes() {
        return "Boleto - " + codigoBarras.substring(0, 5) + "...";
    }
}

// 2. FACTORY METHOD PATTERN - Para criação de estratégias
interface PagamentoFactory {
    PagamentoStrategy criarPagamento(String... dados);
}

class CartaoCreditoFactory implements PagamentoFactory {
    @Override
    public PagamentoStrategy criarPagamento(String... dados) {
        return new CartaoCreditoStrategy(dados[0], dados[1], dados[2]);
    }
}

class PixFactory implements PagamentoFactory {
    @Override
    public PagamentoStrategy criarPagamento(String... dados) {
        return new PixStrategy(dados[0]);
    }
}

class BoletoFactory implements PagamentoFactory {
    @Override
    public PagamentoStrategy criarPagamento(String... dados) {
        return new BoletoStrategy(dados[0]);
    }
}

// 3. ABSTRACT FACTORY PATTERN - Para famílias de objetos relacionados
interface PagamentoAbstractFactory {
    PagamentoStrategy criarEstrategiaPagamento();
    Notificacao criarNotificacao();
}

class PagamentoCartaoFactory implements PagamentoAbstractFactory {
    private String[] dadosCartao;

    public PagamentoCartaoFactory(String... dados) {
        this.dadosCartao = dados;
    }

    @Override
    public PagamentoStrategy criarEstrategiaPagamento() {
        return new CartaoCreditoFactory().criarPagamento(dadosCartao);
    }

    @Override
    public Notificacao criarNotificacao() {
        return new EmailNotificacao("cliente@exemplo.com");
    }
}

// 4. DECORATOR PATTERN - Para adicionar funcionalidades
abstract class PagamentoDecorator implements PagamentoStrategy {
    protected PagamentoStrategy estrategiaDecorada;

    public PagamentoDecorator(PagamentoStrategy estrategia) {
        this.estrategiaDecorada = estrategia;
    }

    @Override
    public void processarPagamento(double valor) {
        estrategiaDecorada.processarPagamento(valor);
    }

    @Override
    public String obterDetalhes() {
        return estrategiaDecorada.obterDetalhes();
    }
}

class PagamentoComValidacao extends PagamentoDecorator {
    public PagamentoComValidacao(PagamentoStrategy estrategia) {
        super(estrategia);
    }

    @Override
    public void processarPagamento(double valor) {
        validar();
        super.processarPagamento(valor);
    }

    private void validar() {
        System.out.println("Validando dados do pagamento...");
    }
}

class PagamentoComLog extends PagamentoDecorator {
    public PagamentoComLog(PagamentoStrategy estrategia) {
        super(estrategia);
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Log: Iniciando pagamento de R$" + valor);
        super.processarPagamento(valor);
        System.out.println("Log: Pagamento concluído");
    }
}

// 5. OBSERVER PATTERN - Para notificações
interface Notificacao {
    void enviar(String mensagem);
}

class EmailNotificacao implements Notificacao {
    private String email;

    public EmailNotificacao(String email) {
        this.email = email;
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando email para " + email + ": " + mensagem);
    }
}

class SMSNotificacao implements Notificacao {
    private String telefone;

    public SMSNotificacao(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS para " + telefone + ": " + mensagem);
    }
}

// 6. SINGLETON PATTERN - Para o gerenciador de pagamentos
class GerenciadorPagamento {
    private static GerenciadorPagamento instance;
    private Map<String, PagamentoFactory> factories;

    private GerenciadorPagamento() {
        // 7. PROTOTYPE PATTERN - Para registro de fábricas
        factories = new HashMap<>();
        registrarFactory("CARTAO", new CartaoCreditoFactory());
        registrarFactory("PIX", new PixFactory());
        registrarFactory("BOLETO", new BoletoFactory());
    }

    public static synchronized GerenciadorPagamento getInstance() {
        if (instance == null) {
            instance = new GerenciadorPagamento();
        }
        return instance;
    }

    public void registrarFactory(String tipo, PagamentoFactory factory) {
        factories.put(tipo, factory);
    }

    public PagamentoStrategy criarPagamento(String tipo, String... dados) {
        PagamentoFactory factory = factories.get(tipo);
        if (factory == null) {
            throw new IllegalArgumentException("Tipo de pagamento não suportado: " + tipo);
        }
        return factory.criarPagamento(dados);
    }

    public void processarPagamento(PagamentoStrategy estrategia, double valor, Notificacao... notificacoes) {
        System.out.println("\nIniciando pagamento...");
        System.out.println("Forma: " + estrategia.obterDetalhes());

        // Aplica decorators
        PagamentoStrategy estrategiaDecorada = new PagamentoComLog(
                new PagamentoComValidacao(estrategia)
        );

        estrategiaDecorada.processarPagamento(valor);

        // Notifica observadores
        for (Notificacao notificacao : notificacoes) {
            notificacao.enviar("Pagamento de R$" + valor + " realizado via " +
                    estrategia.obterDetalhes());
        }

        System.out.println("Pagamento concluído!");
    }
}

// Cliente
public class SistemaPagamentoComPatterns {
    public static void main(String[] args) {
        // Obtém instância singleton do gerenciador
        GerenciadorPagamento gerenciador = GerenciadorPagamento.getInstance();

        // Cria estratégias usando factory
        PagamentoStrategy cartao = gerenciador.criarPagamento("CARTAO",
                "1234 5678 9012 3456", "12/25", "123");

        PagamentoStrategy pix = gerenciador.criarPagamento("PIX",
                "chave.pix@exemplo.com");

        PagamentoStrategy boleto = gerenciador.criarPagamento("BOLETO",
                "34191.79001 01043.510047 91020.150008 7 00000000000000");

        // Cria notificações
        Notificacao email = new EmailNotificacao("cliente@exemplo.com");
        Notificacao sms = new SMSNotificacao("+5511999999999");

        // Processa pagamentos com diferentes combinações de notificação
        gerenciador.processarPagamento(cartao, 150.50, email, sms);
        gerenciador.processarPagamento(pix, 89.90, email);
        gerenciador.processarPagamento(boleto, 1200.00, sms);

        // Demonstração do Abstract Factory
        PagamentoAbstractFactory abstractFactory = new PagamentoCartaoFactory(
                "9876 5432 1098 7654", "06/24", "456");

        PagamentoStrategy estrategia = abstractFactory.criarEstrategiaPagamento();
        Notificacao notificacao = abstractFactory.criarNotificacao();

        gerenciador.processarPagamento(estrategia, 300.00, notificacao);
    }
}

/**
 * Design Patterns Aplicados:
 *     Strategy Pattern:
 *         Separa os algoritmos de pagamento em classes distintas (CartaoCreditoStrategy, PixStrategy, BoletoStrategy)
 *         Permite trocar o algoritmo em tempo de execução
 *     Factory Method Pattern:
 *         Define uma interface para criar objetos (PagamentoFactory)
 *         Delegamos a criação para subclasses (CartaoCreditoFactory, etc.)
 *     Abstract Factory Pattern:
 *         Fornece uma interface para criar famílias de objetos relacionados (PagamentoAbstractFactory)
 *         Cria estratégias de pagamento e notificações coerentes
 *     Decorator Pattern:
 *         Adiciona comportamentos dinamicamente (PagamentoComValidacao, PagamentoComLog)
 *         Permite combinar funcionalidades de forma flexível
 *     Observer Pattern:
 *         Implementa sistema de notificações (Notificacao interface)
 *         Permite múltiplos observadores serem notificados
 *     Singleton Pattern:
 *         Garante uma única instância do GerenciadorPagamento
 *         Ponto central de controle para todo o sistema
 *     Prototype Pattern:
 *         Registro de fábricas disponíveis no Gerenciador
 *         Permite extensão com novas fábricas sem modificar o código existente
 * Benefícios da Implementação:
 *     Flexibilidade: Fácil adição de novos métodos de pagamento
 *     Extensibilidade: Novas funcionalidades podem ser adicionadas via decorators
 *     Baixo acoplamento: Componentes são independentes e intercambiáveis
 *     Reuso de código: Lógica comum centralizada no gerenciador
 *     Manutenibilidade: Cada padrão encapsula uma responsabilidade específica
 * Esta implementação demonstra como combinar múltiplos padrões de projeto pode criar um sistema robusto, flexível e fácil de manter.
 */
