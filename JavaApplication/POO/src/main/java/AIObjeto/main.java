package AIObjeto;

public class main {
    public static void main(String[] args) {
        Caneta c1 = new Caneta();
        c1.cor = "Azeul";
        c1.ponta = 0.5f;
        System.out.println("Estado 1");
        c1.tampar();
        c1.rabiscar();
        c1.status();

        System.out.println();

        Caneta c2 = new Caneta();
        c1.cor = "Vermelha";
        c1.ponta = 0.5f;
        System.out.println("Estado 2");
        c1.destampar();
        c1.rabiscar();
        c1.status();

    }
}
