public class Operadores {

    public static void main(String[] args) {


        // + - / *

        int num1 = 10;
        int num2 = 20;

        double div = 20;
        double result = num1/div;
        System.out.println(result);

        // %
        int resto = 21 % 7;
        System.out.println(resto);

        // < > <= >= == !=
         boolean maior = 10 > 20;
         boolean menor = 10 < 20;
         System.out.println(maior);
         System.out.println(menor);

         // && (AND) || (OR) !
        int idade = 35;
        float salario = 3500F;
        boolean dentro = idade > 30 && salario >= 4612;
        boolean fora = idade < 30 && salario >= 3381;

        System.out.println(dentro);
        System.out.println(fora);

        double vcorrente = 200;
        double vpoupanca = 1000;

        float valorPlaystation = 600;

        boolean resultCompra = valorPlaystation > vcorrente || valorPlaystation > vpoupanca;
        System.out.println(resultCompra);


        // = += *= /= %=
        double bonus = 1800;
        bonus += 1000;
        System.out.println(bonus);

        int contador = 0;
        //Incrementacao antecipada
        System.out.println(++contador);



    }
}
