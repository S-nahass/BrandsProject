package Model;

public class Reviews {

    String brandName;
    String userName;
    int rating;
    String comment;

    // Constructor
    public Reviews(String brandName, String userName, int rating, String comment) {
        // Initialize
        this.brandName = brandName;
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters
    public String getBrandName() {
        return brandName;
    }

    public String getUserName() {
        return userName;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    // no need for setters
}
