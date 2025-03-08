package Comportamental.Strategy.simple;

/**
 * If you see this, PaymentContext is accepting any kind of card(PayCard)! If a new Card type comes,
 * no need to worry…Context will remain same..Only we need to add another Concrete strategy.
 *
 * This is anyway helps to achieve one of the SOLID principles also — Open Closed principle(Open for extension, but closed for modification)
 */
public class PaymentContext {
    private final PaymentCard strategy;
    public PaymentContext(PaymentCard strategy) {
        this.strategy = strategy;
    }
    public void doPayment(String buyer, int amount) {
        this.strategy.pay(buyer, amount);
    }
}
