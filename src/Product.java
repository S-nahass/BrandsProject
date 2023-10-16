import java.util.List;
import java.util.ArrayList;
public class Product {
    private String name;
    private double price;
    private String description;
    private List<UserReview> productReviews;

    private int quantityInStock;   // Added field to track the quantity in stock
    private int quantityPurchased;  // Added field to track the quantity purchased

    private int inventoryLevel; // Add an inventoryLevel field



    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantityInStock = quantityInStock;
        this.quantityPurchased = 0;  // Initialize purchased quantity to 0
        this.productReviews = new ArrayList<>();
        this.inventoryLevel = inventoryLevel;

    }



    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public boolean purchase(int quantity) {
        return false;
    }
    public int getQuantityInStock() {
        return quantityInStock;
    }

    public int getQuantityPurchased() {
        return quantityPurchased;
    }

    public List<UserReview> getProductReviews() {
        return productReviews;
    }

    public void setInventoryLevel(int inventoryLevel) {
        this.inventoryLevel = inventoryLevel;
    }

    public int getInventoryLevel() {
        return inventoryLevel;
    }





    public List<UserReview> getReviews() {
        return productReviews;
    }

    public void addUserReview(UserReview userReview) {
        productReviews.add(userReview);
    }
}