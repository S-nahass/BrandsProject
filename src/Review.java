public class Review {
    private String user;
    private String text;
    private int rating;

    public Review(String user) {
        this.user = user;

    }


    public void setUser(String user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }


}
