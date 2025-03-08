package BIVisibilidade;

public class Caneta {
    public String modelo;
    public String cor;
    public float ponta;
    protected int carga;
    private boolean tampada;

    public void status(){
        System.out.println("##################################################");
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Cor: " + this.cor);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga);
        System.out.println("Esta Tampada?: " + this.tampada);
        System.out.println("###################################################");

        System.out.println("");
        System.out.println("VISIBILIDADE DE ATRIBUTOS, METODOS");
        System.out.println("public todo acessivel a todos");
        System.out.println("privado acessivel somente a classe");
        System.out.println("protegido acessevel a classe e para todos os seus herdeiros");
    }
    public void rabiscar(){
        System.out.println((this.tampada == true) ? "ERRO! não posso rabiscar":"Estou rabiscando" );
    }
    protected void tampar(){
        this.tampada = true;
    }
    protected void destampar(){
        this.tampada = false;
    }
}
