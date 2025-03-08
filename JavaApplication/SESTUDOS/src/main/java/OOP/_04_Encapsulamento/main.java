package OOP._04_Encapsulamento;

public class main {
    public static void main(String[] args) {
        /**
         *  Encapsulamento para objetos
         */

        Conta conta = new Conta(300, 1126, 134567123, new Cliente("nome","4343434343","pr"));
        conta.deposita(400);
        conta.saca(24);
        System.out.println(conta);


        Conta outra = new Conta(300, 1126, 134567123, new Cliente("nome1","43434343212143","pr1"));
        outra.deposita(500);
        outra.saca(24);
        System.out.println(outra);

        conta.transfere(200, outra);


        System.out.println(outra);


    }
}
