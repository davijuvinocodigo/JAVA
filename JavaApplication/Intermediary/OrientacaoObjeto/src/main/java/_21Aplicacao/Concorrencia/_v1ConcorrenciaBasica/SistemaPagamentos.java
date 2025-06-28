package _21Aplicacao.Concorrencia._v1ConcorrenciaBasica;


import java.util.concurrent.*;
import java.util.*;

// Interface que define como um método de pagamento deve funcionar
interface MetodoPagamento {
    CompletableFuture<Boolean> pagar(double valor);
}

// Implementação para pagamento com cartão de crédito
class CartaoCredito implements MetodoPagamento {
    private String numero;

    public CartaoCredito(String numero) {
        this.numero = numero;
    }

    public CompletableFuture<Boolean> pagar(double valor) {
        return CompletableFuture.supplyAsync(() -> {
            // Simula processamento
            System.out.println("Processando cartão... " + numero.substring(12));
            return new Random().nextDouble() > 0.1; // 90% de sucesso
        });
    }
}

// Implementação para pagamento com PIX
class Pix implements MetodoPagamento {
    private String chave;

    public Pix(String chave) {
        this.chave = chave;
    }

    public CompletableFuture<Boolean> pagar(double valor) {
        return CompletableFuture.supplyAsync(() -> {
            // Simula processamento
            System.out.println("Processando PIX... " + chave.substring(0, 5));
            return new Random().nextDouble() > 0.05; // 95% de sucesso
        });
    }
}

// Classe que gerencia os pagamentos
class ProcessadorPagamentos {
    public CompletableFuture<Void> processar(List<MetodoPagamento> metodos, double valor) {
        List<CompletableFuture<Boolean>> resultados = new ArrayList<>();

        for (MetodoPagamento metodo : metodos) {
            resultados.add(metodo.pagar(valor));
        }

        return CompletableFuture.allOf(resultados.toArray(new CompletableFuture[0]));
    }
}

public class SistemaPagamentos {
    public static void main(String[] args) throws Exception {
        ProcessadorPagamentos processador = new ProcessadorPagamentos();

        List<MetodoPagamento> metodos = Arrays.asList(
                new CartaoCredito("1111222233334444"),
                new Pix("chave@exemplo.com"),
                new CartaoCredito("5555666677778888")
        );

        CompletableFuture<Void> processamento = processador.processar(metodos, 100.0);
        processamento.get(); // Espera todos terminarem
        System.out.println("Todos os pagamentos processados!");
    }
}

/**
 *     Interface MetodoPagamento: Define um contrato que todas as formas de pagamento devem implementar, com um método pagar().
 *     Implementações:
 *         CartaoCredito: Simula pagamento com cartão (90% de sucesso)
 *         Pix: Simula pagamento com PIX (95% de sucesso)
 *     ProcessadorPagamentos:
 *         Gerencia vários pagamentos simultaneamente
 *         Usa CompletableFuture para operações assíncronas
 *         allOf() espera todos os pagamentos terminarem
 *     Funcionamento:
 *         Cada pagamento é processado em paralelo
 *         O sistema imprime mensagens durante o processamento
 *         No final, mostra quando todos completaram
 * Conceitos importantes:
 *     Programação assíncrona: Permite que múltiplos pagamentos sejam processados ao mesmo tempo
 *     Polimorfismo: Trata diferentes métodos de pagamento de forma uniforme
 *     CompletableFuture: Representa uma operação que será completada no futuro
 */


/**
 * O Proximo detalhes (como tempo de espera e shutdown do executor).
 */