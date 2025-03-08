package Comportamental.Strategy.exemplo.Funcional;

import java.util.List;
import java.util.function.Consumer;

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart(List<Item> items) {
        this.items = items;
    }

    public void payment(Consumer<Integer> method){
        int total = cartTotal();
        method.accept( total );

    }

    private int cartTotal() {
        return items
                .stream()
                .mapToInt(e -> e.getValue())
                .sum();
    }
}
