package Src;

import java.util.List;
import java.util.ArrayList;

public class Product {
    private String name;
    private double price;
    private String description;
    private List<UserReview> productReviews;

    private int inventoryLevel; // Add an inventoryLevel field



    public Product(String name, double price, String description,int inventoryLevel) {

        this.name = name;
        this.price = price;
        this.description = description;
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

    public boolean purchase(int quantity) {
        if (quantity <= inventoryLevel) {
            inventoryLevel -= quantity;
            return true;
        } else {
            return false;
        }
    }
}