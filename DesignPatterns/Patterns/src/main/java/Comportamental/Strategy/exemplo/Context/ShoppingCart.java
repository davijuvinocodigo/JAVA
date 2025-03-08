package Comportamental.Strategy.exemplo.Context;

import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart(List<Item> items) {
        this.items = items;
    }

    public void pay(PaymentMethod method){

        int total = cartTotal();
        if (method == PaymentMethod.CREDIT){
            System.out.println("Pay with credit " + total);
        } else if (method == PaymentMethod.MONEY){
            System.out.println("Pay with money " + total);
        }
    }

    private int cartTotal() {
        return items
                .stream()
                .mapToInt(Item::getValue)
                .sum();
    }
}
