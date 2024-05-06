package org.example;

import java.util.List;

public class MarketSimulator {
    public static void runSimulation(List<Stock> stocks, int duration, int interval) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long durationInMillis = duration * 1000; // Convertir la durée en millisecondes
        while (System.currentTimeMillis() - startTime <= durationInMillis) {
            for (Stock stock : stocks) {
                stock.updatePrice();
            }
            Thread.sleep(interval * 1000);
        }
    }
}
