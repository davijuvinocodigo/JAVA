package Comportamental.Strategy.simple;

public class DebitCard implements PaymentCard {

    @Override
    public void pay(String buyer, int amount) {
        System.out.println("paying with DebitCard: Buyer = " + buyer + " Amount = " + amount);
    }
}
