package _12AssociacaoBidirecional;

public class Main {
    public static void main(String[] args) {
        // Criando clientes e contas
        Cliente cliente1 = new Cliente("João Silva");
        Cliente cliente2 = new Cliente("Maria Santos");

        Conta conta1 = new Conta(1001, 1500.00);
        Conta conta2 = new Conta(1002, 2500.00);
        Conta conta3 = new Conta(1003, 3500.00);

        System.out.println("=== Estabelecendo associações ===");

        // Associando contas ao cliente1 (bidirecional)
        cliente1.adicionarConta(conta1);
        cliente1.adicionarConta(conta2);

        // Associando conta3 ao cliente2 usando o setCliente (também bidirecional)
        conta3.setCliente(cliente2);

        // Verificando as associações
        System.out.println(cliente1);
        cliente1.getContas().forEach(System.out::println);

        System.out.println("\n" + cliente2);
        cliente2.getContas().forEach(System.out::println);

        System.out.println("\n=== Transferindo conta entre clientes ===");
        // Transferindo conta2 de cliente1 para cliente2
        conta2.setCliente(cliente2);

        // Verificando as associações após a transferência
        System.out.println(cliente1);
        cliente1.getContas().forEach(System.out::println);

        System.out.println("\n" + cliente2);
        cliente2.getContas().forEach(System.out::println);

        System.out.println("\n=== Removendo associações ===");
        // Removendo conta3 do cliente2
        cliente2.removerConta(conta3);

        // Verificando as associações após remoção
        System.out.println("Conta3: " + conta3);
        System.out.println("Cliente da Conta3: " + conta3.getCliente());
        System.out.println("\n" + cliente2);
        cliente2.getContas().forEach(System.out::println);
    }
}

/**
 * Princípios Importantes:
 *     Manutenção da Integridade:
 *         Todos os métodos que modificam o relacionamento (adicionarConta, removerConta, setCliente) garantem que ambas as extremidades da associação sejam atualizadas
 *     Prevenção de Loops Infinitos:
 *         Verificações como !contas.contains(conta) previnem chamadas recursivas infinitas
 *     Encapsulamento:
 *         A lista de contas é retornada como cópia para evitar modificações externas não controladas
 *     Consistência:
 *         Sempre que uma associação é removida de um lado, a referência inversa também é atualizada
 */
