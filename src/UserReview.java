import java.util.Date;

public class UserReview {
    private String userName;
    private Product product;
    private int rating;
    private String content;
    private Brand brand;

    public UserReview(String userName, Product product, int rating, String content) {
        this.userName = userName;
        this.product = product;
        this.rating = rating;
        this.content = content;
    }


    public UserReview(String userName, Brand selectedBrand, int rating, String reviewText) {
        this.userName = userName;
        this.brand = selectedBrand;
        this.rating = rating;
        this.content = reviewText;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "UserReview{" +
                "userName='" + userName + '\'' +
                ", product=" + product +
                ", rating=" + rating +
                ", content='" + content + '\'' +
                '}';
    }
}
