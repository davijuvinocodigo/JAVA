package _21Aplicacao.SOLID;


// 1. Princípio da Responsabilidade Única (SRP)
// Interface única para processamento de pagamento
interface ProcessadorPagamento {
    void processar(double valor);
}

// Interface única para obtenção de detalhes
interface DetalhesPagamento {
    String obterDetalhes();
    String obterDadosCompletos();
}

// 2. Princípio Aberto/Fechado (OCP)
// Classe base abstrata para formas de pagamento
abstract class FormaPagamento implements ProcessadorPagamento, DetalhesPagamento {
    protected double valor;

    public void setValor(double valor) {
        this.valor = valor;
    }
}

// 3. Princípio da Substituição de Liskov (LSP)
// Implementações concretas que são substituíveis pela classe base
class CartaoCredito extends FormaPagamento {
    private String numero;
    private String dataValidade;
    private String cvv;

    public CartaoCredito(String numero, String dataValidade, String cvv) {
        this.numero = numero;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
    }

    @Override
    public void processar(double valor) {
        setValor(valor);
        System.out.println("Processando pagamento de R$" + valor + " via Cartão de Crédito");
        validarCartao();
        autorizarTransacao();
    }

    private void validarCartao() {
        System.out.println("Validando cartão: " + numero.substring(0, 4) + " **** **** ****");
    }

    private void autorizarTransacao() {
        System.out.println("Autorizando transação no valor de R$" + valor);
    }

    @Override
    public String obterDetalhes() {
        return "Cartão de Crédito - Final " + numero.substring(numero.length() - 4);
    }

    @Override
    public String obterDadosCompletos() {
        return "Cartão: " + numero + " Validade: " + dataValidade;
    }
}

class Pix extends FormaPagamento {
    private String chave;

    public Pix(String chave) {
        this.chave = chave;
    }

    @Override
    public void processar(double valor) {
        setValor(valor);
        System.out.println("Processando pagamento de R$" + valor + " via PIX");
        gerarQRCode();
        confirmarTransacao();
    }

    private void gerarQRCode() {
        System.out.println("Gerando QR Code para chave: " + chave);
    }

    private void confirmarTransacao() {
        System.out.println("Confirmando transação PIX no valor de R$" + valor);
    }

    @Override
    public String obterDetalhes() {
        return "PIX - Chave: " + (chave.length() > 10 ? chave.substring(0, 10) + "..." : chave);
    }

    @Override
    public String obterDadosCompletos() {
        return "Chave PIX: " + chave;
    }
}

class BoletoBancario extends FormaPagamento {
    private String codigoBarras;

    public BoletoBancario(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void processar(double valor) {
        setValor(valor);
        System.out.println("Processando pagamento de R$" + valor + " via Boleto Bancário");
        gerarBoleto();
        registrarPagamento();
    }

    private void gerarBoleto() {
        System.out.println("Gerando boleto com código: " + codigoBarras.substring(0, 5) + "...");
    }

    private void registrarPagamento() {
        System.out.println("Registrando pagamento de boleto no valor de R$" + valor);
    }

    @Override
    public String obterDetalhes() {
        return "Boleto - " + codigoBarras.substring(0, 5) + "...";
    }

    @Override
    public String obterDadosCompletos() {
        return "Código de barras: " + codigoBarras;
    }
}

// 4. Princípio da Segregação de Interfaces (ISP)
// Interface específica para notificações
interface Notificador {
    void enviarNotificacao(String mensagem);
}

// Implementação de notificação por email
class NotificadorEmail implements Notificador {
    private String email;

    public NotificadorEmail(String email) {
        this.email = email;
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("Enviando email para " + email + ": " + mensagem);
    }
}

// 5. Princípio da Inversão de Dependência (DIP)
// Classe de alto nível dependendo de abstrações
class GerenciadorPagamento {
    private final Notificador notificador;

    public GerenciadorPagamento(Notificador notificador) {
        this.notificador = notificador;
    }

    public void executarPagamento(FormaPagamento formaPagamento, double valor) {
        System.out.println("\nIniciando processo de pagamento...");

        // Processa o pagamento
        formaPagamento.processar(valor);

        // Obtém detalhes
        System.out.println("Detalhes: " + formaPagamento.obterDetalhes());
        System.out.println("Dados completos: " + formaPagamento.obterDadosCompletos());

        // Notifica
        notificador.enviarNotificacao("Pagamento de R$" + valor + " realizado com sucesso via " +
                formaPagamento.obterDetalhes());

        System.out.println("Pagamento concluído com sucesso!");
    }
}

// Classe principal
public class SistemaPagamentoSOLID {
    public static void main(String[] args) {
        // Configuração das dependências
        Notificador notificador = new NotificadorEmail("cliente@exemplo.com");
        GerenciadorPagamento gerenciador = new GerenciadorPagamento(notificador);

        // Criação das formas de pagamento
        FormaPagamento cartao = new CartaoCredito("1234 5678 9012 3456", "12/25", "123");
        FormaPagamento pix = new Pix("chave.pix@exemplo.com");
        FormaPagamento boleto = new BoletoBancario("34191.79001 01043.510047 91020.150008 7 00000000000000");

        // Execução dos pagamentos
        gerenciador.executarPagamento(cartao, 150.50);
        gerenciador.executarPagamento(pix, 89.90);
        gerenciador.executarPagamento(boleto, 1200.00);
    }
}


/**
 * Aplicação dos Princípios SOLID:
 *     Single Responsibility Principle (SRP)
 *         Separei as interfaces em ProcessadorPagamento e DetalhesPagamento, cada uma com uma única responsabilidade
 *         Cada classe tem apenas um motivo para mudar
 *     Open/Closed Principle (OCP)
 *         A classe abstrata FormaPagamento está fechada para modificação
 *         Novas formas de pagamento podem ser adicionadas sem modificar o código existente
 *     Liskov Substitution Principle (LSP)
 *         Todas as subclasses (CartaoCredito, Pix, BoletoBancario) podem substituir a classe base FormaPagamento sem quebrar o comportamento
 *     Interface Segregation Principle (ISP)
 *         Interfaces pequenas e específicas (ProcessadorPagamento, DetalhesPagamento, Notificador)
 *         Clientes não são forçados a depender de interfaces que não usam
 *     Dependency Inversion Principle (DIP)
 *         GerenciadorPagamento depende de abstrações (Notificador, FormaPagamento)
 *         Dependências são injetadas via construtor
 *         Módulos de alto nível não dependem de módulos de baixo nível
 * Benefícios Adicionais:
 *     Melhor encapsulamento das operações específicas de cada forma de pagamento
 *     Mais fácil de testar (podemos mockar as dependências)
 *     Mais flexível para adicionar novas formas de pagamento ou notificações
 *     Código mais coeso e menos acoplado
 * Esta implementação segue os melhores princípios de design orientado a objetos e padrões de projeto, resultando em um sistema mais robusto, flexível e maintainable.
 * New chat
 */
