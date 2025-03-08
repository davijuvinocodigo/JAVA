package _20Polimorfismo._01SobrescritaMetodo._02Exemplo;

public class Operacao {
    public double calcular(double x, double y){
        return 0;
    }

    static void calculadora(Operacao o, double x, double y){
        System.out.println(o.calcular(x,y));
    }
}
