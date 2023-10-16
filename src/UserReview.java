import java.util.Date;

public class UserReview {
    private String userName;
    private Date date;
    private Product product;
    private int rating;
    private String content;

    public UserReview(String userName, Date date, Product product, int rating, String content) {
        this.userName = userName;
        this.date = date;
        this.product = product;
        this.rating = rating;
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
                ", date=" + date +
                ", product=" + product +
                ", rating=" + rating +
                ", content='" + content + '\'' +
                '}';
    }
}
