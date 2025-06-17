package _10BlocoInicializacaoEstaticos;

public class TesteBanco {
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