package _21Aplicacao.Interface;

// Interface que define o contrato para todas as formas de pagamento
interface FormaPagamento {
    void processarPagamento(double valor);
    String obterDetalhes();
}

// Classe para pagamento com cartão de crédito
class CartaoCredito implements FormaPagamento {
    private String numero;
    private String dataValidade;
    private String cvv;

    public CartaoCredito(String numero, String dataValidade, String cvv) {
        this.numero = numero;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Cartão de Crédito");
        System.out.println("Número: " + numero.substring(0, 4) + " **** **** ****");
        // Lógica específica para cartão de crédito
    }

    @Override
    public String obterDetalhes() {
        return "Cartão de Crédito - Final " + numero.substring(numero.length() - 4);
    }
}

// Classe para pagamento com PIX
class Pix implements FormaPagamento {
    private String chave;

    public Pix(String chave) {
        this.chave = chave;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via PIX");
        System.out.println("Chave: " + chave);
        // Lógica específica para PIX
    }

    @Override
    public String obterDetalhes() {
        return "PIX - Chave: " + (chave.length() > 10 ? chave.substring(0, 10) + "..." : chave);
    }
}

// Classe para pagamento com boleto bancário
class BoletoBancario implements FormaPagamento {
    private String codigoBarras;

    public BoletoBancario(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Boleto Bancário");
        System.out.println("Código de Barras: " + codigoBarras);
        // Lógica específica para boleto
    }

    @Override
    public String obterDetalhes() {
        return "Boleto - " + codigoBarras.substring(0, 5) + "...";
    }
}

// Classe que representa um pagamento
class Pagamento {
    private double valor;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public void processarPagamento(FormaPagamento formaPagamento) {
        System.out.println("\nIniciando pagamento...");
        System.out.println("Forma: " + formaPagamento.obterDetalhes());
        formaPagamento.processarPagamento(this.valor);
        System.out.println("Pagamento concluído!");
    }
}

// Classe principal para testar o sistema
public class SistemaPagamento {
    public static void main(String[] args) {
        // Criando formas de pagamento
        FormaPagamento cartao = new CartaoCredito("1234 5678 9012 3456", "12/25", "123");
        FormaPagamento pix = new Pix("chave.pix@exemplo.com");
        FormaPagamento boleto = new BoletoBancario("34191.79001 01043.510047 91020.150008 7 00000000000000");

        // Criando um pagamento
        Pagamento pagamento1 = new Pagamento(150.50);
        Pagamento pagamento2 = new Pagamento(89.90);
        Pagamento pagamento3 = new Pagamento(1200.00);

        // Processando pagamentos
        pagamento1.processarPagamento(cartao);
        pagamento2.processarPagamento(pix);
        pagamento3.processarPagamento(boleto);
    }
}

/**
 * Principais diferenças e vantagens usando interfaces:
 *     Acoplamento mais fraco: As classes concretas implementam a interface, mas não estão presas a uma hierarquia de herança.
 *     Flexibilidade: Uma classe pode implementar múltiplas interfaces.
 *     Contrato claro: A interface define exatamente quais métodos devem ser implementados.
 *     Princípio da inversão de dependência: O sistema depende de abstrações (interface) e não de implementações concretas.
 *     Métodos adicionais: Adicionei o método obterDetalhes() para mostrar como podemos estender o contrato.
 * Padrões de projeto aplicáveis:
 *     Strategy: Podemos considerar cada forma de pagamento como uma estratégia diferente.
 *     Factory: Poderia ser usado para criar instâncias de formas de pagamento.
 *     Decorator: Poderia ser usado para adicionar funcionalidades extras como validações, logs, etc.
 * Este design é mais flexível e segue melhor os princípios SOLID, especialmente o princípio de segregação de interfaces e o princípio de inversão de dependência.
 */
