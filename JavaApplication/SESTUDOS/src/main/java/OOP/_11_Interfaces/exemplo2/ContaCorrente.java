package OOP._11_Interfaces.exemplo2;

public class ContaCorrente extends Conta implements Tributavel {

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

    @Override
    public double getValorImposto() {
        return super.saldo * 0.5;
    }
}
