package Comportamental.Strategy.exemplo;

public class DebitCard implements Payment{
    @Override
    public void pay(int amount) {
        System.out.println("Pay with DebitCards: " + amount);
    }
}
