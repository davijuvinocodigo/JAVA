package OOP._10_Classes_Metodos_Abstratos.Funcionario;

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

    public double getBonificacao(){
        return super.getBonificacao() + super.getSalario();
    }
}
