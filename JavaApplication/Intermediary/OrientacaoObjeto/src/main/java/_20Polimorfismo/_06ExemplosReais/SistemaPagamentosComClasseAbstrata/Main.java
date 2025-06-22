package _20Polimorfismo._06ExemplosReais.SistemaPagamentosComClasseAbstrata;

public class Main {
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
