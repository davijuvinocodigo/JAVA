package _10BlocoInicializacaoEstaticos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Banco {
    // Constantes estáticas
    public static final String NOME_BANCO = "JavaBank";
    private static final int AGENCIA_PADRAO = 1;

    // Variáveis estáticas
    private static Map<Integer, Conta> contas;
    private static double taxaJurosPoupanca;
    private static double taxaJurosChequeEspecial;
    private static int proximoNumeroConta;

    // Bloco de inicialização estático
    static {
        System.out.println("Inicializando sistema bancário...");

        // Inicializa as coleções
        contas = new HashMap<>();

        // Carrega configurações (simulado)
        carregarConfiguracoes();

        // Gera número inicial para contas
        proximoNumeroConta = new Random().nextInt(1000) + 1000;

        System.out.println("Banco inicializado com sucesso!");
        System.out.println("Taxa de juros poupança: " + taxaJurosPoupanca);
        System.out.println("Taxa de cheque especial: " + taxaJurosChequeEspecial);
    }

    // Método estático para simular carregamento de configurações
    private static void carregarConfiguracoes() {
        // Em um sistema real, isso viria de um arquivo de configuração ou banco de dados
        taxaJurosPoupanca = 0.005; // 0.5% ao mês
        taxaJurosChequeEspecial = 0.02; // 2% ao mês
    }

    // Métodos estáticos para operações bancárias
    public static Conta criarConta(String titular, String tipoConta, double saldoInicial) {
        int numeroConta = proximoNumeroConta++;
        Conta novaConta;

        switch (tipoConta.toLowerCase()) {
            case "poupanca":
                novaConta = new ContaPoupanca(numeroConta, AGENCIA_PADRAO, titular, saldoInicial);
                break;
            case "corrente":
                novaConta = new ContaCorrente(numeroConta, AGENCIA_PADRAO, titular, saldoInicial);
                break;
            default:
                throw new IllegalArgumentException("Tipo de conta inválido: " + tipoConta);
        }

        contas.put(numeroConta, novaConta);
        return novaConta;
    }

    public static Conta buscarConta(int numeroConta) {
        return contas.get(numeroConta);
    }

    public static void aplicarJuros() {
        System.out.println("\nAplicando juros em todas as contas...");
        for (Conta conta : contas.values()) {
            conta.aplicarJuros();
        }
    }

    public static double getTaxaJurosPoupanca() {
        return taxaJurosPoupanca;
    }

    public static double getTaxaJurosChequeEspecial() {
        return taxaJurosChequeEspecial;
    }

    public static void listarContas() {
        System.out.println("\n=== CONTAS DO BANCO ===");
        for (Conta conta : contas.values()) {
            System.out.println(conta);
        }
    }
}

// Classe base abstrata para Conta
abstract class Conta {
    protected int numero;
    protected int agencia;
    protected String titular;
    protected double saldo;

    public Conta(int numero, int agencia, String titular, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado na conta " + numero);
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado na conta " + numero);
        } else {
            System.out.println("Saldo insuficiente na conta " + numero);
        }
    }

    public abstract void aplicarJuros();

    @Override
    public String toString() {
        return String.format("[%d] Ag: %d - %s - Saldo: R$%.2f",
                numero, agencia, titular, saldo);
    }
}

// Classe Conta Poupança
class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, int agencia, String titular, double saldo) {
        super(numero, agencia, titular, saldo);
    }

    @Override
    public void aplicarJuros() {
        double juros = saldo * Banco.getTaxaJurosPoupanca();
        saldo += juros;
        System.out.println("Juros de R$" + juros + " aplicados na conta poupança " + numero);
    }
}

// Classe Conta Corrente
class ContaCorrente extends Conta {
    private static final double LIMITE_CHEQUE_ESPECIAL = 1000.00;

    public ContaCorrente(int numero, int agencia, String titular, double saldo) {
        super(numero, agencia, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= (saldo + LIMITE_CHEQUE_ESPECIAL)) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado na conta corrente " + numero);

            if (saldo < 0) {
                double juros = -saldo * Banco.getTaxaJurosChequeEspecial();
                saldo -= juros;
                System.out.println("Juros de cheque especial: R$" + juros);
            }
        } else {
            System.out.println("Limite de saque excedido na conta " + numero);
        }
    }

    @Override
    public void aplicarJuros() {
        if (saldo < 0) {
            double juros = -saldo * Banco.getTaxaJurosChequeEspecial();
            saldo -= juros;
            System.out.println("Juros de cheque especial de R$" + juros + " aplicados na conta " + numero);
        }
    }
}



public class BlocoInicializacaoEstaticos {
    public static void main(String[] args) {
        // O bloco estático é executado automaticamente quando a classe Banco é carregada

        // Criando contas
        Conta conta1 = Banco.criarConta("João Silva", "corrente", 500.00);
        Conta conta2 = Banco.criarConta("Maria Souza", "poupanca", 1000.00);
        Conta conta3 = Banco.criarConta("Carlos Oliveira", "corrente", 200.00);

        // Operações nas contas
        conta1.depositar(300.00);
        conta1.sacar(1000.00); // Usa cheque especial
        conta2.depositar(200.00);
        conta3.sacar(300.00); // Excede limite

        // Listando todas as contas
        Banco.listarContas();

        // Aplicando juros
        Banco.aplicarJuros();

        // Listando contas após juros
        Banco.listarContas();
    }
}


/**
 * Principais Pontos Demonstrados:
 *     Bloco estático inicializa variáveis compartilhadas por todas as instâncias
 *     Carregamento de configurações simulando leitura de arquivo externo
 *     Inicialização de coleções que armazenam todas as contas
 *     Métodos estáticos para operações bancárias globais
 *     Hierarquia de classes com Conta, ContaCorrente e ContaPoupanca
 *     Aplicação de juros usando as taxas definidas no bloco estático
 * Este exemplo mostra como os blocos de inicialização estáticos são úteis para configurar o ambiente antes que qualquer objeto seja criado, garantindo que todos os recursos compartilhados estejam prontos para uso.
 */
