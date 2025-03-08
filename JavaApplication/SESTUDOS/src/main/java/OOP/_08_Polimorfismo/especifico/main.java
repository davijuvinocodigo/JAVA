package OOP._08_Polimorfismo.especifico;

public class main {
    public static void main(String[] args) {
        Veiculo m = new Moto();
        m.liga();

        Veiculo c = new Carro();
        c.liga();
    }
}
