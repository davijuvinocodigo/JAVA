package _03Metodos;

public class ClassObjetoMetodosParametroTipoReferencia {

    public String nome;
    public int idade;
    public char sexo;

    public void imprime(ClassObjetoMetodosParametroTipoReferencia classObjetoMetodosParametroTipoReferencia) {
        //Referencia a classe this
        System.out.println(classObjetoMetodosParametroTipoReferencia.nome);
        System.out.println(classObjetoMetodosParametroTipoReferencia.idade);
        System.out.println(classObjetoMetodosParametroTipoReferencia.sexo);
    }
}
