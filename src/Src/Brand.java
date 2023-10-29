package Src;

import java.util.List;
import java.util.ArrayList;

public class Brand {
    private String name;
    private String category;
    private int yearFounded;
    private String countryOfOrigin;
    private List<Product> products;
    //  private List<UserFeedback> feedback;
    private List<UserReview> brandReviews;

    private String brandHistory;

    public Brand(String name, String category, int yearFounded, String countryOfOrigin, String brandHistory) {
        this.name = name;
        this.category = category;
        this.yearFounded = yearFounded;
        this.countryOfOrigin = countryOfOrigin;
        this.brandHistory = brandHistory;
        this.products = new ArrayList<>();
        this.brandReviews = new ArrayList<>();
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public void setCountry(String country) {
        this.countryOfOrigin = country;
    }


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

    public List<Product> getProducts() {
        return products;
    }

    public List<UserReview> getBrandReviews() {
        return brandReviews;
    }

    public void addProduct(Product product) {
        products.add(product);
    }


    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void addUserReview(UserReview userReview) {
        brandReviews.add(userReview);
    }



    // for GUI results display
    @Override
    public String toString() {
        return name;
    }
}


