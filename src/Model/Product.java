package Model;

public class Product {
    private String brandName;
    private String name;
    private double price;
    private String description;
    private int inventoryLevel;
    private int popularityScore;

    // Constructor
    public Product(String brandName, String name, double price, String description, int inventoryLevel, int popularityScore) {

        this.brandName = brandName;
        this.name = name;
        this.price = price;
        this.description = description;
        this.inventoryLevel = inventoryLevel;
        this.popularityScore = popularityScore;

    }

    // Getters
    public String getBrandName() {
        return brandName;
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

    public int getInventoryLevel() {
        return inventoryLevel;
    }

    public int getPopularityScore() {
        return popularityScore;
    }

    // Setters

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInventoryLevel(int inventoryLevel) {
        this.inventoryLevel = inventoryLevel;
    }

    public void setPopularityScore(int popularityScore) {
        this.popularityScore = popularityScore;
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

