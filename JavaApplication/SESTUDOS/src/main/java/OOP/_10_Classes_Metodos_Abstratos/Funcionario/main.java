package OOP._10_Classes_Metodos_Abstratos.Funcionario;

public class main {
    public static void main(String[] args) {

        Funcionario g1 = new Gerente();
        g1.setNome("Marco");
        g1.setCpf("235568413");
        g1.setSalario(5000.0);

        System.out.println(g1.getNome());
        System.out.println(g1.getCpf());
        System.out.println(g1.getSalario());

        System.out.println(g1.getBonificacao());

    }
}
