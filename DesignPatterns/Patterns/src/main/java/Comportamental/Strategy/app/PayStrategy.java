package Comportamental.Strategy.app;

/**
 * Common interface for all strategies.
 */

public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
