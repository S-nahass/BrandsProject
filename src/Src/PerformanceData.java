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

