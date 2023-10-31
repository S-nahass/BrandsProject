package Src;

import java.util.ArrayList;
import java.util.List;

public class PerformanceData {
    private final String name;  // Name of the brand or product
    private final List<SalesRecord> salesHistory;
    private final List<ProductPopularity> productPopularity;

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

}

class SalesRecord {
    private final int year;
    private final int quantitySold;
    private final double totalRevenue;

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
