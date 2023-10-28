package Src;

public class UserReview {
    private String userName;
    private Product product;
    private int rating;
    private String content;

    public UserReview(String userName, Product product, int rating, String content) {
        this.userName = userName;
        this.product = product;
        this.rating = rating;
        this.content = content;
    }


    public UserReview(String userName, Brand selectedBrand, int rating, String reviewText) {
        this.userName = userName;
        this.rating = rating;
        this.content = reviewText;
    }

    public String getUserName() {
        return userName;
    }


    public Product getProduct() {
        return product;
    }

    public int getRating() {
        return rating;
    }

    public String getContent() {
        return content;
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
