package _19Interfaces._05InterfaceVsAbstrato.SistemaPagamentoAbstrato;

abstract class MetodoPagamento {
    protected String identificacao;

    public MetodoPagamento(String identificacao) {
        this.identificacao = identificacao;
    }

    // Método abstrato (deve ser implementado pelas subclasses)
    public abstract void processarPagamento(double valor);

    // Método concreto com implementação padrão
    public boolean validar() {
        return identificacao != null && !identificacao.isEmpty();
    }

    // Outro método concreto
    public void registrarTransacao(double valor) {
        System.out.println("Registrando transação de R$" + valor);
    }
}





class CartaoCredito extends MetodoPagamento {
    private String cvv;

    public CartaoCredito(String numero, String cvv) {
        super(numero);
        this.cvv = cvv;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando R$" + valor + " via cartão de crédito " + identificacao.substring(12));
        registrarTransacao(valor);
    }

    @Override
    public boolean validar() {
        return super.validar() && identificacao.length() == 16 && cvv.length() == 3;
    }
}





class Pix extends MetodoPagamento {
    public Pix(String chave) {
        super(chave);
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando R$" + valor + " via PIX para chave " + identificacao);
        registrarTransacao(valor);
    }
}




class SistemaPagamento {
    public void realizarPagamento(MetodoPagamento metodo, double valor) {
        if (metodo.validar()) {
            metodo.processarPagamento(valor);
        } else {
            System.out.println("Método de pagamento inválido!");
        }
    }
}



public class SistemaPagamentoAbstrato {
    public static void main(String[] args) {
        SistemaPagamento sistema = new SistemaPagamento();

        MetodoPagamento cartao = new CartaoCredito("1234567812345678", "123");
        sistema.realizarPagamento(cartao, 150.50);

        MetodoPagamento pix = new Pix("email@exemplo.com");
        sistema.realizarPagamento(pix, 200.75);
    }
}



/*
   Quando usar classes abstratas vs interfaces:

Use classes abstratas quando:
    Você quer compartilhar código entre classes relacionadas
    Precisa declarar campos não estáticos/finais
    Quer fornecer implementações padrão para alguns métodos
    Precisa de métodos com diferentes níveis de acesso (protected, private)

Use interfaces quando:
    Espera que classes não relacionadas implementem sua interface
    Quer especificar o comportamento de um tipo de dados
    Quer aproveitar a herança múltipla (uma classe pode implementar várias interfaces)
    Está trabalhando com lambdas e APIs funcionais

Estes exemplos mostram como classes abstratas permitem maior reuso de código através de implementações compartilhadas, enquanto ainda mantêm a flexibilidade do polimorfismo.
 */
