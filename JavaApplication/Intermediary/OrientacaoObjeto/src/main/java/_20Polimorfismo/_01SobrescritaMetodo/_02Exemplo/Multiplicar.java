package _20Polimorfismo._01SobrescritaMetodo._02Exemplo;

public class Multiplicar extends Operacao{

    @Override
    public double calcular(double x, double y) {
        return x * y;
    }
}
