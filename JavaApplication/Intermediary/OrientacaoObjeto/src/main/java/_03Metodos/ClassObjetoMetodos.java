package _03Metodos;

public class ClassObjetoMetodos {

    public void metodoVoid(){
        System.out.println("Void sem retorno");
    }

    public void metodoVoidComParametros(String p){
        System.out.println("Void sem retorno com " + p);
    }

    public double metodoRetornoDouble(int v, int x){
        return v/x;
    }

    public void metodoRetornoIntVariavelCopiaMemoria(int num1, int num2){
        num1 = 99;
        num2 = 100;
        System.out.println(num1);
        System.out.println(num2);
    }

    public void somaVarArgs(int... numeros){
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        System.out.println(soma);
    }
}
