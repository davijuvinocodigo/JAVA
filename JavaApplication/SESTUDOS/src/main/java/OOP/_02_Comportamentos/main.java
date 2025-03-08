package OOP._02_Comportamentos;

public class main {
    public static void main(String[] args) {
        /**
         *  Comportamento do objeto com metodos
         */

        Conta conta = new Conta(300, 1126, 134567123, "Titular");
        conta.deposita(400);
        conta.saca(24);
        System.out.println(conta);


        Conta outra = new Conta(300, 1126, 134567123, "Titular");
        outra.deposita(500);
        outra.saca(24);
        System.out.println(outra);

        conta.transfere(200, outra);


        System.out.println(outra);


    }
}
