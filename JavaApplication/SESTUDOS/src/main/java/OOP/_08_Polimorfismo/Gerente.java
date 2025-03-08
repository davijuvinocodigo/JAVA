package OOP._08_Polimorfismo;

public class Gerente extends Funcionario {

    private int senha;

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public boolean autentica(int senha){
        if(this.senha == senha){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public double getBonusMes() {
        System.out.println("Chamando bonus do GERENTE...");
        return super.getBonusMes() + super.getSalario();
    }
}
