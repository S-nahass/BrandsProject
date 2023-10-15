import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private List<Product> products;

    public ProductDatabase() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    // Other methods for updating, deleting, or querying products can be added here.

    // Method to add test data to the database
    public void addTestData() {
        Product product1 = new Product("Running Shoes", 99.99, "High-performance running shoes.");
        Product product2 = new Product("Sports T-Shirt", 29.99, "Moisture-wicking sports t-shirt.");
        Product product3 = new Product("Casual Jeans", 49.99, "Comfortable and stylish jeans.");
        Product product4 = new Product("Designer Sunglasses", 149.99, "UV-protective sunglasses.");

        // Add the test products to the database
        addProduct(product1);
        addProduct(product2);
        addProduct(product3);
        addProduct(product4);

    }
}
