package _04Modificadores;



class Banco {
    // Constante estática
    public static final String NOME_BANCO = "Banco Java";

    // Atributo estático
    private static int totalContas = 0;

    // Método estático
    public static int getTotalContas() {
        return totalContas;
    }

    // Classe interna estática
    public static class Conta {
        private final int numero;  // final - imutável após criação
        private double saldo;
        private String titular;

        public Conta(String titular) {
            this.titular = titular;
            this.numero = ++totalContas;  // Incrementa contador estático
        }

        // Métodos sincronizados para operações thread-safe
        public synchronized void depositar(double valor) {
            saldo += valor;
        }

        public synchronized void sacar(double valor) {
            if (saldo >= valor) {
                saldo -= valor;
            }
        }

        // Getters
        public int getNumero() {
            return numero;
        }

        public double getSaldo() {
            return saldo;
        }

        public String getTitular() {
            return titular;
        }
    }

    // Método abstrato (se a classe fosse abstract)
    // public abstract void metodoAbstrato();
}

// Classe final que não pode ser herdada
final class UtilitariosBanco {
    private UtilitariosBanco() {}  // Construtor privado para evitar instanciação

    public static String formatarMoeda(double valor) {
        return String.format("R$ %.2f", valor);
    }
}


public class Modificadores {
    public static void main(String[] args) {
        // Criando contas
        Banco.Conta conta1 = new Banco.Conta("João");
        Banco.Conta conta2 = new Banco.Conta("Maria");

        // Exibindo informações iniciais
        System.out.println("Banco: " + Banco.NOME_BANCO);
        System.out.println("Total de contas criadas: " + Banco.getTotalContas());
        System.out.println("Conta 1 - Titular: " + conta1.getTitular() + ", Número: " + conta1.getNumero() + ", Saldo: " + UtilitariosBanco.formatarMoeda(conta1.getSaldo()));
        System.out.println("Conta 2 - Titular: " + conta2.getTitular() + ", Número: " + conta2.getNumero() + ", Saldo: " + UtilitariosBanco.formatarMoeda(conta2.getSaldo()));

        // Operações nas contas
        conta1.depositar(500.0);
        conta2.depositar(1000.0);
        conta1.sacar(200.0);

        // Exibindo informações após operações
        System.out.println("Conta 1 - Saldo atualizado: " + UtilitariosBanco.formatarMoeda(conta1.getSaldo()));
        System.out.println("Conta 2 - Saldo atualizado: " + UtilitariosBanco.formatarMoeda(conta2.getSaldo()));
    }

}

/**
 *   Boas Práticas com Modificadores
 *     Encapsulamento:
 *         Prefira private para atributos
 *         Use métodos públicos (getters/setters) para acesso controlado
 *     Imutabilidade:
 *         Use final para constantes e objetos imutáveis
 *         Considere classes final quando a herança não é desejada
 *     Design Orientado a Objetos:
 *         Use protected cuidadosamente (expõe detalhes internos)
 *         Prefira composição sobre herança quando possível
 *     Organização:
 *         Métodos utilitários devem ser static
 *         Classes auxiliares podem ser final
 */
