package org.example;

public class LoggingDocumentProxy implements  Document{
    private RealDocument realDocument;

    public LoggingDocumentProxy(String name) {
        this.realDocument = new RealDocument(name);
    }

    @Override
    public void open() {
        log("Opening document");
        realDocument.open();

    }

    @Override
    public void save() {
        log("Saving document");
        realDocument.save();
    }
    private void log(String message) {
        System.out.println("[Log] " + message);
    }
}
