package org.example;

import org.example.trading.model.Trader;
import org.example.trading.model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 400),
                new Transaction(brian, 2012, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 410),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));


        // Question 1: Trouvez toutes les transactions en 2011 et les trier par valeur
        // (petite à élevée) stocker ces données dans une liste de transactions

        List<Transaction> transactions2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println("Transactions en 2011 triées par valeur : " + transactions2011);

        // Question 2: Quelles sont toutes les villes uniques où les traders travaillent
        //stocker ses données dans une liste de villes (chaîne de caractères). 2 possibilités
        // 5DONT UNE EN UTILISANT LES SET).
        //List<String> uniqueCities = traders.stream()
                //.map(Trader::getCity)
               // .distinct()
               // .collect(Collectors.toList());
        Set<String> uniqueCities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());

        System.out.println("Villes uniques où les traders travaillent : " + uniqueCities);

        // Question 3: Renvoyez une chaîne de noms de tous les traders triés par ordre alphabétique
        String traderNames = traders.stream()
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println("Noms des traders triés par ordre alphabétique : " + traderNames);

        // Question 4: Y a-t-il des commerçants basés à Milan
        boolean milanBased = transactions.stream()
                .anyMatch(t -> t.
                        getCity().equals("Milan"));

        System.out.println("Des commerçants sont-ils basés à Milan ? " + milanBased);

        // Question 5: Quelle est la valeur la plus élevée de toutes les transactions
        OptionalInt maxTransactionValue = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();

        System.out.println("Valeur la plus élevée de toutes les transactions : " + maxTransactionValue.orElse(0));

        // Question 6: Trouvez tous les traders de Cambridge et les triez par nom
        List<Trader> cambridgeTraders = traders.stream()
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        System.out.println("Traders de Cambridge triés par nom : " + cambridgeTraders);

        // Question 7: Trouvez toutes les valeurs des transactions des traders vivant à Cambridge
        List<Integer> cambridgeTransactionValues = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());

        System.out.println("Valeurs des transactions des traders de Cambridge : " + cambridgeTransactionValues);

        // Question 8: Recherchez la transaction avec la plus petite valeur
        Optional<Transaction> smallestTransaction = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue));

        System.out.println("Transaction avec la plus petite valeur : " + smallestTransaction.orElse(null));

    }
}