package Exemplos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<BankTransactions> transaction = new ArrayList<>(
                List.of(new BankTransactions(1L, 500.0, "Deposit"),
                        new BankTransactions(2L, 1000.0, "Debito"),
                        new BankTransactions(3L, 12500.0, "Deposit"),
                        new BankTransactions(4L, 500.0, "Saque"),
                        new BankTransactions(5L, 1000.0, "Saque"),
                        new BankTransactions(6L, 12500.0, "Deposit")
                )
        );

        List<Long> transactionsIds = transaction.stream()
                .filter(e -> e.getType().equals("Deposit"))

                .sorted(Comparator.comparing(BankTransactions::getAmount).reversed())

                .map(BankTransactions::getId)
                .toList();

    }
}
