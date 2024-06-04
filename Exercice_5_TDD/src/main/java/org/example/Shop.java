package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Shop /* extends Product*/ {
    private List<Product> products;

   // public Shop(String type, String name, int sellIn, int quality) {
       // super(type, name, sellIn, quality);
   // }

    public Shop(List<Product> products) {
        super();
        this.products = products;
    }


   /* public void update(Product product) throws ExecutionControl.NotImplementedException{
       /* throw new ExecutionControl.NotImplementedException("NOT IMPLEMENTS YET")}*/

    public void update(Product product) throws NotFoundException {
        if (!products.contains(product)) {
            throw new NotFoundException("Product not found in the shop.");
        }

        switch (product.getType()) {
            case "brie":
                updateBrie(product);
                break;
            case "dairy":
                updateDairy(product);
                break;
            default:
                updateNormalProduct(product);
                break;
        }
    }

    private void updateBrie(Product product) {
        product.setSellIn(product.getSellIn() - 1);
        if (product.getQuality() < 50) {
            product.setQuality(product.getQuality() + 1);
        }
    }

    private void updateDairy(Product product) {
        product.setSellIn(product.getSellIn() - 1);
        int qualityChange = product.getSellIn() < 0 ? -4 : -2;
        product.setQuality(Math.max(0, product.getQuality() + qualityChange));
    }

    private void updateNormalProduct(Product product) {
        product.setSellIn(product.getSellIn() - 1);
        int qualityChange = product.getSellIn() < 0 ? -2 : -1;
        product.setQuality(Math.max(0, product.getQuality() + qualityChange));
    }

    public List<Product> getProducts() {
        return products;
    }
}
