package AIObjeto;

public class Caneta {
    String modelo;
    String cor;
    float ponta;
    int carga;
    boolean tampada;

    void status(){
        System.out.println("##################################################");
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Cor: " + this.cor);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga);
        System.out.println("Esta Tampada?: " + this.tampada);
        System.out.println("###################################################");
    }
    void rabiscar(){
        System.out.println((this.tampada == true) ? "ERRO! não posso rabiscar":"Estou rabiscando" );
    }
    void tampar(){
        this.tampada = true;
    }
    void destampar(){
        this.tampada = false;
    }
}
