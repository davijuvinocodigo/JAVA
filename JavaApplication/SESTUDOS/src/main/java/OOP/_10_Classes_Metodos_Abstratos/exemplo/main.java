package OOP._10_Classes_Metodos_Abstratos.exemplo;

public class main {
    public static void main(String[] args) {

        System.out.println("-----------------------GERENTE------------------------------------");
        Gerente g1 = new Gerente();
        g1.setNome("Marco");
        g1.setCpf("235568413");
        g1.setSalario(5000.0);
        System.out.println(g1.getNome());
        System.out.println(g1.getCpf());
        System.out.println(g1.getSalario());
        System.out.println(g1.getBonusMes());

        System.out.println("---------------------------COODERNADO---------------------------------");
        Coodernador c1 = new Coodernador();
        c1.setNome("davi");
        c1.setCpf("235568413");
        c1.setSalario(5000.0);
        System.out.println(c1.getNome());
        System.out.println(c1.getCpf());
        System.out.println(c1.getSalario());
        System.out.println(c1.getBonusMes());

        System.out.println("-------------------------------ANALISTA-----------------------------");
        Analista a1 = new Analista();
        a1.setNome("samuel");
        a1.setCpf("235568413");
        a1.setSalario(5000.0);
        System.out.println(a1.getNome());
        System.out.println(a1.getCpf());
        System.out.println(a1.getSalario());
        System.out.println(a1.getBonusMes());


        System.out.println("-------------------------------CONTROLE BONUS--------------------------");
        ControleBonus controleBonus = new ControleBonus();
        controleBonus.registrar(g1);
        controleBonus.registrar(c1);
        controleBonus.registrar(a1);

        System.out.println("SOMA DO BONUS DOS FUNCIONARIOS TOTAL : " +  controleBonus.getSoma());


    }
}
