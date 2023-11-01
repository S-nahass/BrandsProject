package Src;

public class ProductPopularity {
    private final String productName;
    private final int popularityScore;

    public ProductPopularity(String productName, int popularityScore) {
        this.productName = productName;
        this.popularityScore = popularityScore;
    }

    public String getProductName() {
        return productName;
    }

    public int getPopularityScore() {
        return popularityScore;
    }

}
