import org.example.NotFoundException;
import org.example.Product;
import org.example.Shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class ShopTest {

    private List<Product> products;
    private Shop shop;

    @BeforeEach
    public void setUp() {
        products = new ArrayList<>();
        shop = new Shop(products);
    }

    @Test
    public void testProductNotFoundRaisesNotFoundException() {
        // Arrange
        Product product = new Product("normal", "Nonexistent Product", 10, 20);

        // Act & Assert
        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.update(product);
        });
    }

    @Test
    public void testNormalProductBeforeSellInDate() throws NotFoundException {
        // Arrange
        Product product = new Product("normal", "Normal Product", 10, 20);
        products.add(product);

        // Act
        shop.update(product);

        // Assert
        Assertions.assertEquals(9, product.getSellIn(), "SellIn should be decremented");
        Assertions.assertEquals(19, product.getQuality(), "Quality should be decremented");
    }

    @Test
    public void testNormalProductOnSellInDate() throws NotFoundException {
        // Arrange
        Product product = new Product("normal", "Normal Product", 0, 20);
        products.add(product);

        // Act
        shop.update(product);

        // Assert
        Assertions.assertEquals(-1, product.getSellIn(), "SellIn should be decremented");
        Assertions.assertEquals(18, product.getQuality(), "Quality should be decremented twice as fast after sellIn date");
    }

    @Test
    public void testNormalProductQualityNeverNegative() throws NotFoundException {
        // Arrange
        Product product = new Product("normal", "Normal Product", 10, 0);
        products.add(product);

        // Act
        shop.update(product);

        // Assert
        Assertions.assertEquals(9, product.getSellIn(), "SellIn should be decremented");
        Assertions.assertEquals(0, product.getQuality(), "Quality should never be negative");
    }

    @Test
    public void testBrieQualityIncreases() throws NotFoundException {
        // Arrange
        Product product = new Product("brie", "Aged Brie", 10, 20);
        products.add(product);

        // Act
        shop.update(product);

        // Assert
        Assertions.assertEquals(9, product.getSellIn(), "SellIn should be decremented");
        Assertions.assertEquals(21, product.getQuality(), "Quality of Brie should increase");
    }

    @Test
    public void testBrieQualityDoesNotExceedFifty() throws NotFoundException {
        // Arrange
        Product product = new Product("brie", "Aged Brie", 10, 50);
        products.add(product);

        // Act
        shop.update(product);

        // Assert
        Assertions.assertEquals(9, product.getSellIn(), "SellIn should be decremented");
        Assertions.assertEquals(50, product.getQuality(), "Quality should never exceed 50");
    }

    @Test
    public void testDairyProductDegradesTwiceAsFast() throws NotFoundException {
        // Arrange
        Product product = new Product("dairy", "Milk", 10, 20);
        products.add(product);

        // Act
        shop.update(product);

        // Assert
        Assertions.assertEquals(9, product.getSellIn(), "SellIn should be decremented");
        Assertions.assertEquals(18, product.getQuality(), "Quality of dairy products should degrade twice as fast");
    }
}
