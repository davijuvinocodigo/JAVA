package OOP._01_Objetos;

public class main {
    public static void main(String[] args) {
        /**
         *  Instanciando um objeto para uma primeira referência.
         */

        Conta minhaConta = new Conta(300, 1126, 134567123, "Titular");
        System.out.println(minhaConta);

        /**
         * Vejamos que no segundo objeto estamos recebendo uma cópia do primeiro objeto o mesmo passará a ser outra referência, ao objeto instanciado.
         */

        Conta outraConta = minhaConta;
        System.out.println(outraConta);
    }
}
