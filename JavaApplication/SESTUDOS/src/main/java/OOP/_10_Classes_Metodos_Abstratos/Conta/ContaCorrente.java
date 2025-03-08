package OOP._10_Classes_Metodos_Abstratos.Conta;

public class ContaCorrente extends Conta {

    public ContaCorrente(int agencia, int numero) {
        super(agencia, numero);
    }

    @Override
    public void deposita(double valor) {
        super.saldo += valor;
    }

    @Override
    public boolean saca(double valor) {
        double taxa = valor + 0.2;
        return super.saca(taxa);
    }

}
