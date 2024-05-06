package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Investor implements Observer<Stock> {
    @Getter
    private String name;
    private List<Stock> subscribedStocks = new ArrayList<>();
    private List<String> notifications = new ArrayList<>();


    public Investor(String name) {
        this.name = name;
    }

    public void subscribe(Stock stock) {
        stock.registerObserver(this);
        subscribedStocks.add(stock);
    }

    public void unsubscribe(Stock stock) {
        stock.removeObserver(this);
        subscribedStocks.remove(stock);
    }
    @Override
    public void update(Stock element) {
        String notification = name + " received notification: " + element.getName() + " price updated to " + element.getPrice();
        notifications.add(notification);
        System.out.println(notification);
    }

    public void clearNotifications() {
        notifications.clear();
    }

    public List<String> getNotifications() {
        return notifications;
    }

}
