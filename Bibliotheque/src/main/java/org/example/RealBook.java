package org.example;

public class RealBook implements Book {
    private String title;
    private String content;

    public RealBook(String title, String content) {
        this.title = title;
        this.content = content;
    }




    @Override
    public void readBook(String content) {
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);

    }
}
