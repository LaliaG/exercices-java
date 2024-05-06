package org.example;

public class RealDocument implements Document{
    private String name;

    public RealDocument(String name) {
        this.name = name;
    }
    @Override
    public void open() {
        System.out.println("Opening document: " + name);

    }

    @Override
    public void save() {
        System.out.println("Saving document: " + name);

    }
}
