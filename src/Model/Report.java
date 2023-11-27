package Model;

public class Report {

    private final String brandName;
    private final int year;
    private final int quantitySold;
    private final double revenue;
    private final String productName;
    private final int productPopularity;

    // Constructor
    public Report(String brandName, int year, int quantitySold, double revenue, String productName, int productPopularity) {
        // Set the values
        this.brandName = brandName;
        this.year = year;
        this.quantitySold = quantitySold;
        this.revenue = revenue;
        this.productName = productName;
        this.productPopularity = productPopularity;

    }

    // Getters
    public String getBrandName() {
        return brandName;
    }

    public int getYear() {
        return year;
    }
    public int getQuantitySold() {
        return quantitySold;
    }

    public double getRevenue() {
        return revenue;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPopularity() {
        return productPopularity;
    }

    // no need for setters as the values won't change

}
