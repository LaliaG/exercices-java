package org.example.entity;

public interface ZooSubject {
    void registerObserver(ZooVisitor observer);
    void removeObserver(ZooVisitor observer);
    void notifyObservers(String event);
}
