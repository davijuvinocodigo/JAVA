package OOP._09_Polimorfismo_Herancao_Construtores;

public class ContaCorrente extends Conta {

    public ContaCorrente(int agencia, int numero) {
        super(agencia, numero);
    }

    @Override
    public boolean saca(double valor) {
        double taxa = valor + 0.2;
        return super.saca(taxa);
    }
}
