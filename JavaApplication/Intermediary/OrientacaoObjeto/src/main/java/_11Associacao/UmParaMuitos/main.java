package _11Associacao.UmParaMuitos;

public class main {
    public static void main(String[] args) {
        Jogador j1 = new Jogador("A");
        Time time = new Time("Brasil");
        j1.setTime(time);
        j1.imprimir();

    }
}
