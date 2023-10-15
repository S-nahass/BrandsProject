public class Brand {
    private String name;
    private String category;
    private int yearFounded;

    private String countryOfOrigin;
    //private List<Product> products;
    //  private List<UserFeedback> feedback;

    public Brand(String name, String category, int yearFounded, String countryOfOrigin) {
        this.name = name;
        this.category = category;
        this.yearFounded = yearFounded;
        this.countryOfOrigin = countryOfOrigin;
        //this.products = new ArrayList<>();
        // this.feedback = new ArrayList<>();
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
}
  /*  public List<Product> getProducts() {
        return products;
    }

    public List<UserFeedback> getFeedback() {
        return feedback;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void addFeedback(UserFeedback userFeedback) {
        feedback.add(userFeedback);
    }
}
*/