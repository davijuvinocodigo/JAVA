package OOP._02_Comportamentos;

public class Conta {
    private double saldo;
    private int agencia;
    private int numero;
    private String titular;

    public Conta() {
    }

    public Conta(double saldo, int agencia, int numero, String titular) {
        this.saldo = saldo;
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void deposita(double v){
        this.saldo += v;
    }

    public boolean saca(double v) {
        if (this.saldo >= v) {
            this.saldo -= v;
            return true;
        } else {
            return false;
        }
    }

    public boolean transfere(double v, Conta destino){
        if (this.saldo >= v){
            this.saldo -= v;
            destino.deposita(v);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", titular='" + titular + '\'' +
                '}';
    }
}
