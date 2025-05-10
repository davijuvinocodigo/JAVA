package Comportamental.Strategy.simple;

/**
 * https://salithachathuranga94.medium.com/
 * Referencia: https://salithachathuranga94.medium.com/strategy-design-pattern-with-java-175e03864a35
 */
public class StrategyDemo {
    public static void main(String[] args) {
        Comportamental.Strategy.simple.PaymentContext paymentContext = new PaymentContext(new CreditCard());
        paymentContext.doPayment("salitha", 100);

        paymentContext = new PaymentContext(new DebitCard());
        paymentContext.doPayment("salitha", 100);
    }
}
