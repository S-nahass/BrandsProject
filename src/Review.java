public class Review {
    private String text;
    private int rating;

    public Review(String review) {
        this.text = review;
        this.rating = 0;
    }


    public void setText(String text) {
        this.text = text;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }


}
