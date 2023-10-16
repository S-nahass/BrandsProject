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
    private PerformanceData performanceData;

    public Brand(String name, String category, int yearFounded, String countryOfOrigin, String brandHistory) {
        this.name = name;
        this.category = category;
        this.yearFounded = yearFounded;
        this.countryOfOrigin = countryOfOrigin;
        this.brandHistory = brandHistory;
        this.products = new ArrayList<>();
        this.brandReviews = new ArrayList<>();
        this.performanceData = new PerformanceData(this.name);
    }

    public Brand(String name, String category, int yearFounded, String countryOfOrigin) {

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

    public void setBrandHistory(String brandHistory) {
        this.brandHistory = brandHistory;
    }

    public void setPerformanceData(PerformanceData performanceData) {
        this.performanceData = performanceData;
    }

    public void setBrandReviews(List<UserReview> brandReviews) {
      this.brandReviews = brandReviews;
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

    public PerformanceData getPerformanceData() {
        return performanceData;
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



  /* public void addReview(String review, int rating) {
        UserReview newReview = new Review(review);
        newReview.setRating(rating);
        newReview.setText(review);
        brandReviews.add(newReview);
    }*/


    public void setBrandPerformance(PerformanceData brand1Performance) {
        this.performanceData = brand1Performance;
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void addUserReview(UserReview userReview) {
        brandReviews.add(userReview);
    }
}


  /*  public List<Product> getProducts() {
        return products;
    }

    public List<UserFeedback> getFeedback() {
        return feedback;
    }



    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void addFeedback(UserFeedback userFeedback) {
        feedback.add(userFeedback);
    }
}
*/