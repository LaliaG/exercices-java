package org.example.entity;

public class ZooVisitor implements Observer{
    private String name;

    public ZooVisitor(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println(name + ": " + event);

    }
}
