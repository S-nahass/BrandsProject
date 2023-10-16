import java.util.List;
import java.util.ArrayList;
public class Product {
    private String name;
    private double price;
    private String description;
    private List<Review> productReviews;

    private int quantityInStock;   // Added field to track the quantity in stock
    private int quantityPurchased;  // Added field to track the quantity purchased



    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantityInStock = quantityInStock;
        this.quantityPurchased = 0;  // Initialize purchased quantity to 0
        this.productReviews = new ArrayList<>();
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

    public List<Review> getProductReviews() {
        return productReviews;
    }


    public void addReview(String review, int rating) {
        Review newReview = new Review(review);
        newReview.setRating(rating);
        newReview.setText(review);
        productReviews.add(newReview);    }

    public List<Review> getReviews() {
        return productReviews;
    }
}