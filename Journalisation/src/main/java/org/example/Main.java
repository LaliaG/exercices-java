package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Document realDocument = new RealDocument("Document 1");
        realDocument.open();
        realDocument.save();

        System.out.println();

        Document loggingDocument = new LoggingDocumentProxy("Document 2");
        loggingDocument.open();
        loggingDocument.save();
    }
}