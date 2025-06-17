package _16ModificadorFinal;

// Classe final que não pode ser estendida
final class ContaBancaria {
    // Atributos finais (só podem ser atribuídos uma vez)
    private final String numeroConta;
    private final String titular;
    private final double saldo;

    // Constante estática final
    public static final double LIMITE_SAQUE_DIARIO = 1000.00;

    // TesteCarro - única chance de atribuir valores aos campos finais
    public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Método final que não pode ser sobrescrito
    public final String getNumeroConta() {
        return numeroConta;
    }

    // Método final que não pode ser sobrescrito
    public final String getTitular() {
        return titular;
    }

    // Método final que não pode ser sobrescrito
    public final double getSaldo() {
        return saldo;
    }

    // Método que retorna um novo objeto (padrão imutável)
    public final ContaBancaria depositar(double valor) {
        return new ContaBancaria(numeroConta, titular, saldo + valor);
    }

    // Método final que retorna um novo objeto
    public final ContaBancaria sacar(double valor) {
        if (valor > LIMITE_SAQUE_DIARIO) {
            throw new IllegalArgumentException("Valor excede o limite diário");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        return new ContaBancaria(numeroConta, titular, saldo - valor);
    }

    // Método final que recebe um parâmetro final
    public final void transferirPara(final ContaBancaria destino, final double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
        ContaBancaria novaOrigem = this.sacar(valor);
        ContaBancaria novoDestino = destino.depositar(valor);

        System.out.printf("Transferência realizada: R$%.2f para %s%n",
                valor, destino.getTitular());
    }

    @Override
    public String toString() {
        return String.format("Conta %s - Titular: %s - Saldo: R$%.2f",
                numeroConta, titular, saldo);
    }
}

// Classe de teste
public class ModificadorFinal {
    public static void main(String[] args) {
        // Criando contas (objetos finais não significa objetos imutáveis,
        // mas a referência não pode apontar para outro objeto)
        final ContaBancaria contaJoao = new ContaBancaria("12345", "João Silva", 1500.00);
        final ContaBancaria contaMaria = new ContaBancaria("67890", "Maria Souza", 2500.00);

        System.out.println(contaJoao);
        System.out.println(contaMaria);

        // Tentativa de reatribuição (gera erro de compilação)
        // contaJoao = new ContaBancaria("11111", "João Silva", 2000.00);

        // Operações que retornam novas instâncias
        final ContaBancaria contaJoaoPosSaque = contaJoao.sacar(300.00);
        final ContaBancaria contaMariaPosDeposito = contaMaria.depositar(500.00);

        System.out.println("\nApós operações:");
        System.out.println(contaJoaoPosSaque);
        System.out.println(contaMariaPosDeposito);

        // Transferência
        contaJoaoPosSaque.transferirPara(contaMariaPosDeposito, 200.00);

        // Acessando constante final
        System.out.println("\nLimite de saque diário: R$" + ContaBancaria.LIMITE_SAQUE_DIARIO);
    }
}

/**
        modificador final com tipos de referência (objetos), classes e métodos.
 */


/**
 *  Pontos-chave do exemplo:
 *     Classe final: ContaBancaria não pode ser estendida
 *     Atributos finais: Só podem ser definidos no construtor
 *     Métodos finais: Não podem ser sobrescritos por subclasses (se houvesse)
 *     Parâmetros finais: No método transferirPara, os parâmetros são final
 *     Referência final: As variáveis contaJoao e contaMaria não podem apontar para outros objetos
 *     Constante estática final: LIMITE_SAQUE_DIARIO é uma constante da classe
 */