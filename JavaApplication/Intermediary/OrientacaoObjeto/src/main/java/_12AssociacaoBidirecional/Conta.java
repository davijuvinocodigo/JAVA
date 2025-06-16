package _12AssociacaoBidirecional;

public class Conta {
    private int numero;
    private double saldo;
    private Cliente cliente; // Associação bidirecional: Conta conhece Cliente

    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Método para definir cliente mantendo a bidirecionalidade
    public void setCliente(Cliente novoCliente) {
        // Remove esta conta do cliente atual (se houver)
        if (this.cliente != null) {
            this.cliente.removerConta(this);
        }

        // Atualiza a referência
        this.cliente = novoCliente;

        // Adiciona esta conta ao novo cliente (se não for nulo)
        if (novoCliente != null) {
            novoCliente.adicionarConta(this);
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta #" + numero + " (Saldo: R$ " + saldo + ")";
    }
}
