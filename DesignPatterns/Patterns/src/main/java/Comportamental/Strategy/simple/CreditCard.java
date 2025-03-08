package Comportamental.Strategy.simple;

public class CreditCard implements PaymentCard {
    @Override
    public void pay(String buyer, int amount) {
        System.out.println("paying with CreditCard: Buyer = " + buyer + " Amount = " + amount);
    }
}
