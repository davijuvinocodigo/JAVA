package OOP._11_Interfaces.exemplo2;

public class CalculadoraImposto implements Tributavel {

    private double totalImposto;
    @Override
    public double getValorImposto() {
        return this.totalImposto;
    }

    public void registra(Tributavel t){
     double v = t.getValorImposto();
     this.totalImposto += v;
    }
}
