package _11Associacao.Bidirecional.bicontacliente;

import java.util.ArrayList;
import java.util.List;

class Cliente {
    private String nome;
    private List<Conta> contas; // Associação bidirecional: Cliente conhece Conta

    public Cliente(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return new ArrayList<>(contas); // Retorna cópia para evitar modificações externas
    }

    // Método para adicionar conta mantendo a bidirecionalidade
    public void adicionarConta(Conta conta) {
        if (conta != null && !contas.contains(conta)) {
            contas.add(conta);
            conta.setCliente(this); // Estabelece a referência inversa
        }
    }

    // Método para remover conta mantendo a bidirecionalidade
    public void removerConta(Conta conta) {
        if (conta != null && contas.contains(conta)) {
            contas.remove(conta);
            conta.setCliente(null); // Remove a referência inversa
        }
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " (Contas: " + contas.size() + ")";
    }
}