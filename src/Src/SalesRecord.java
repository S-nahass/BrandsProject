package Src;

public class SalesRecord {
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
