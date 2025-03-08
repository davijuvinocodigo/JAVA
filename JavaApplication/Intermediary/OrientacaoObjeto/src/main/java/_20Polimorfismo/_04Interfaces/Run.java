package _20Polimorfismo._04Interfaces;

public class Run {

    public static void area(AreaCalculavel o){
        System.out.println(o.calculaArea());
    }

    public static void main(String[] args) {
     area(new Quadrado(2));
    }
}
