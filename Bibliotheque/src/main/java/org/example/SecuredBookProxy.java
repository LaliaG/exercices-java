package org.example;

public class SecuredBookProxy implements Book{
    private RealBook realBook;
    private boolean isUserPremium = true;
    public SecuredBookProxy(String title, String content, boolean isUserPremium) {
        this.realBook = new RealBook(title, content);
        this.isUserPremium = isUserPremium;
    }
    @Override
    public void readBook(String content) {
        if(isUserPremium) {
            realBook.readBook();
        } else {
            System.out.println("Access denied. Premium membership required.");
        }

    }
}
