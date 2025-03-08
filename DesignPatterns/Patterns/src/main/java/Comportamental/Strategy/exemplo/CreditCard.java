package Comportamental.Strategy.exemplo;

public class CreditCard implements Payment{
    @Override
    public void pay(int amount) {
        System.out.println("Pay with Credit: " + amount);
    }
}
