package _11Associacao.MuitosParaUm;

public class main {
    public static void main(String[] args) {
        Professor p = new Professor("Professor1");
        Professor p2 = new Professor("Professor2");
        Professor[] professores = {p,p2};
        Escola e = new Escola("BB Escola", professores);

        e.imprimir();
    }
}
