import java.util.ArrayList;
import java.util.List;

public class PerformanceData {
    private String name;  // Name of the brand or product
    private List<SalesRecord> salesHistory;
    private List<ProductPopularity> productPopularity;

    public PerformanceData(String name) {
        this.name = name;
        this.salesHistory = new ArrayList<>();
        this.productPopularity = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<SalesRecord> getSalesHistory() {
        return salesHistory;
    }

    public List<ProductPopularity> getProductPopularity() {
        return productPopularity;
    }

    public void addSalesRecord(SalesRecord salesRecord) {
        salesHistory.add(salesRecord);
    }

    public void addProductPopularity(ProductPopularity popularity) {
        productPopularity.add(popularity);
    }

    public void setPerformanceData(PerformanceData brand1Data) {
        this.salesHistory.addAll(brand1Data.getSalesHistory());
        this.productPopularity.addAll(brand1Data.getProductPopularity());
    }
}

class SalesRecord {
    private int year;
    private int quantitySold;
    private double totalRevenue;

    public SalesRecord(int year, int quantitySold, double totalRevenue) {
        this.year = year;
        this.quantitySold = quantitySold;
        this.totalRevenue = totalRevenue;
    }

    public int getYear() {
        return year;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
}

class ProductPopularity {
    private String productName;
    private int popularityScore;

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
