package Comportamental.Strategy.exemplo;

public class Money implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Pay with Money: " + amount);
    }
}
