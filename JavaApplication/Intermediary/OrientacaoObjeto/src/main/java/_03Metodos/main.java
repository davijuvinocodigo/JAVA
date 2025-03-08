package _03Metodos;

import _01Atributo.ClassObjetoAtributo;
import _02Coesao.ClassObjetoCoesao;
import _03Metodos.ClassObjetoMetodos;
import _03Metodos.ClassObjetoMetodosParametroTipoReferencia;

public class main {
    public static void main(String[] args) {

        //Classe Objeto Atributos
        ClassObjetoAtributo atributos = new ClassObjetoAtributo();
        atributos.idade = 18;
        atributos.nome = "AA";
        atributos.sexo = 'F';
        System.out.println(atributos.nome);


        //============================================================================
        //Classe Objeto Coesão
        // Nada mais é que separar classes especificas
        ClassObjetoCoesao coesao = new ClassObjetoCoesao();
        coesao.idade = 18;
        coesao.nome = "AA";
        coesao.sexo = 'F';
        System.out.println(coesao.nome);



        //============================================================================
        //Classe Objeto Metodos
        ClassObjetoMetodos metodos = new ClassObjetoMetodos();
        metodos.metodoVoid();
        metodos.metodoVoidComParametros("parametro");
        double result = metodos.metodoRetornoDouble(20,5);
        System.out.println(result);

        // Classe Varargs como parametro
        metodos.somaVarArgs(1,2,3);

        //Sempre é passado uma copia da variavel, então ainda nossa variavel
        //local continua estatíca, o que vai vir do metodo não importa o valor local não vai ser alterado.
        int num1 = 1;
        int num2 = 2;
        metodos.metodoRetornoIntVariavelCopiaMemoria(num1,num2);
        System.out.println(num1);
        System.out.println(num2);


        //Classe Objeto Metodos Parametro do tipo referencia
        ClassObjetoMetodosParametroTipoReferencia metodoParametroReferencia1 = new ClassObjetoMetodosParametroTipoReferencia();
        ClassObjetoMetodosParametroTipoReferencia metodoParametroReferencia2 = new ClassObjetoMetodosParametroTipoReferencia();
        ClassObjetoMetodosParametroTipoReferencia imprimir = new ClassObjetoMetodosParametroTipoReferencia();

        metodoParametroReferencia1.nome = "BBB";
        metodoParametroReferencia1.idade = 50;
        metodoParametroReferencia1.sexo = 'M';


        metodoParametroReferencia2.nome = "FFF";
        metodoParametroReferencia2.idade = 66;
        metodoParametroReferencia2.sexo = 'F';

        imprimir.imprime(metodoParametroReferencia1);
        System.out.println();
        imprimir.imprime(metodoParametroReferencia2);
    }
}
