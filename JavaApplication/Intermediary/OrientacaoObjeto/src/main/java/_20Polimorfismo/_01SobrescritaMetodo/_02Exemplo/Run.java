package _20Polimorfismo._01SobrescritaMetodo._02Exemplo;

public class Run {
    public static void main(String[] args) {
        Operacao.calculadora(new Multiplicar(), 2, 4);
        Operacao.calculadora(new Soma(), 3, 5);
    }
}
