package _17Enumeracao;

import java.util.ArrayList;
import java.util.List;

// Enumeração para tipos de cliente
enum TipoCliente {
    PESSOA_FISICA("Pessoa Física", "CPF"),
    PESSOA_JURIDICA("Pessoa Jurídica", "CNPJ"),
    GOVERNAMENTAL("Governamental", "Inscrição Estadual");

    private final String descricao;
    private final String documento;

    TipoCliente(String descricao, String documento) {
        this.descricao = descricao;
        this.documento = documento;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDocumento() {
        return documento;
    }
}

// Enumeração para tipos de pagamento
enum TipoPagamento {
    CARTAO_CREDITO("Cartão de Crédito"),
    CARTAO_DEBITO("Cartão de Débito"),
    BOLETO("Boleto Bancário"),
    PIX("PIX"),
    DINHEIRO("Dinheiro");

    private final String descricao;

    TipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

// Classe Cliente
class Cliente {
    private String nome;
    private String documento;
    private TipoCliente tipo;
    private List<TipoPagamento> formasPagamento;

    // Construtor
    public Cliente(String nome, String documento, TipoCliente tipo) {
        this.nome = nome;
        this.documento = documento;
        this.tipo = tipo;
        this.formasPagamento = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public List<TipoPagamento> getFormasPagamento() {
        return formasPagamento;
    }

    public void adicionarFormaPagamento(TipoPagamento formaPagamento) {
        formasPagamento.add(formaPagamento);
    }

    // Sobrescrita do método toString()
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", tipo=" + tipo.getDescricao() +
                ", formasPagamento=" + formasPagamento +
                '}';
    }

    // Método para buscar cliente por documento
    public static Cliente buscarPorDocumento(List<Cliente> clientes, String documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }

    // Método para buscar clientes por tipo
    public static List<Cliente> buscarPorTipo(List<Cliente> clientes, TipoCliente tipo) {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getTipo() == tipo) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }
}

// Classe principal para teste
public class Enumeracao {
    public static void main(String[] args) {
        // Criando alguns clientes
        List<Cliente> clientes = new ArrayList<>();

        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00", TipoCliente.PESSOA_FISICA);
        cliente1.adicionarFormaPagamento(TipoPagamento.CARTAO_CREDITO);
        cliente1.adicionarFormaPagamento(TipoPagamento.PIX);
        clientes.add(cliente1);

        Cliente cliente2 = new Cliente("Empresa XYZ", "12.345.678/0001-99", TipoCliente.PESSOA_JURIDICA);
        cliente2.adicionarFormaPagamento(TipoPagamento.BOLETO);
        cliente2.adicionarFormaPagamento(TipoPagamento.CARTAO_DEBITO);
        clientes.add(cliente2);

        Cliente cliente3 = new Cliente("Prefeitura Municipal", "123456789", TipoCliente.GOVERNAMENTAL);
        cliente3.adicionarFormaPagamento(TipoPagamento.BOLETO);
        clientes.add(cliente3);

        // Testando os métodos
        System.out.println("Todos os clientes:");
        clientes.forEach(System.out::println);

        System.out.println("\nBusca por documento (123.456.789-00):");
        Cliente encontrado = Cliente.buscarPorDocumento(clientes, "123.456.789-00");
        System.out.println(encontrado != null ? encontrado : "Cliente não encontrado");

        System.out.println("\nClientes do tipo PESSOA_JURIDICA:");
        List<Cliente> juridicos = Cliente.buscarPorTipo(clientes, TipoCliente.PESSOA_JURIDICA);
        juridicos.forEach(System.out::println);
    }
}
