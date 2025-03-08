package Comportamental.Strategy.exemplo;


import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart(List<Item> items) {
        this.items = items;
    }

    public void payment(Payment method){
        int total = cartTotal();
        method.pay(total);
    }

    private int cartTotal() {
        return items
                .stream()
                .mapToInt(Item::getValue)
                .sum();
    }
}
