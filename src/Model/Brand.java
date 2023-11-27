package Model;

import java.util.List;
import java.util.ArrayList;

public class Brand {
    private String name;
    private String category;
    private int yearFounded;
    private String countryOfOrigin;
    private String brandHistory;
    private final List<Product> products;


    // Constructor
    public Brand(String name, String category, int yearFounded, String countryOfOrigin, String brandHistory) {
        // Initialize variables
        this.name = name;
        this.category = category;
        this.yearFounded = yearFounded;
        this.countryOfOrigin = countryOfOrigin;
        this.brandHistory = brandHistory;
        this.products = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public String getBrandHistory() {
        return brandHistory;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public void setBrandHistory(String brandHistory) {
        this.brandHistory = brandHistory;
    }


}
