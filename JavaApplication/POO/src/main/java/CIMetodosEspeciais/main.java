package CIMetodosEspeciais;

public class main {
    public static void main(String[] args) {
        Caneta c1 = new Caneta("","Azul",0.5f,0);
        System.out.println("Estado 1");
        c1.tampar();
        c1.rabiscar();
        c1.status();

        System.out.println();

        Caneta c2 = new Caneta("","Vermelho",0.5f,0);;
        System.out.println("Estado 2");
        c1.destampar();
        c1.rabiscar();
        c1.status();

    }
}
