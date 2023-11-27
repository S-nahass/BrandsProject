package Util;

import Model.Brand;
import Model.Product;
import Model.Report;
import Model.Reviews;

import java.util.List;


public class BrandDatabase {
    private static final String CSV_FILE_PATH = "C:/Users/USER/Desktop/BrandsProject/src/Brands.csv";
    private static final String CSV_FILE_PATH2 = "C:/Users/USER/Desktop/BrandsProject/src/Products.csv";
    private static final String CSV_FILE_PATH3 = "C:/Users/USER/Desktop/BrandsProject/src/Report.csv";
    private static final String CSV_FILE_PATH4 = "C:/Users/USER/Desktop/BrandsProject/src/Reviews.csv";
    private static final List<Brand> brands;
    private static final List<Product> products;
    private static final List<Report> reports;
    private static final List<Reviews> reviews;

    // Load brands from the CSV file during application startup
    static {
        brands = CSVReader.readBrandsFromCSV(CSV_FILE_PATH);
    }

    // Load products from the CSV file during application startup
    static {
        products = CSVReader.readProductsFromCSV(CSV_FILE_PATH2);
    }

    // Load reports from the CSV file during application startup
    static {
        reports = CSVReader.readReportsFromCSV(CSV_FILE_PATH3);
    }

    // Load reviews from the CSV file during application startup
    static {
        reviews = CSVReader.readReviewsFromCSV(CSV_FILE_PATH4);
    }

    // Return a list of brands
    public static List<Brand> getBrands() {
        return brands;
    }

    // Return a list of reports
    public static List<Report> getReports() {
        return reports;
    }

    // Return a list of products
    public static List<Reviews> getReviews() {
        return reviews;
    }

    // Update a brand in the CSV file
    public static void updateBrandInCSV(Brand updatedBrand) {
        List<Brand> brands = CSVReader.readBrandsFromCSV(CSV_FILE_PATH);

        // Find the brand to be updated and replace it with the updated brand
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
            if (brand.getName().equals(updatedBrand.getName())) {
                brands.set(i, updatedBrand);
                break;
            }
        }

        // Write the updated list of brands back to the CSV file
        CSVWriter.writeBrandsToCSV(brands, CSV_FILE_PATH);
    }

    // Remove a brand from the CSV file
    public static void removeBrandFromCSV(Brand brandToRemove) {
        List<Brand> brands = CSVReader.readBrandsFromCSV(CSV_FILE_PATH);

        // Remove the brand
        brands.removeIf(brand -> brand.getName().equals(brandToRemove.getName()));

        // Write the updated list of brands back to the CSV file
        CSVWriter.writeBrandsToCSV(brands, CSV_FILE_PATH);
    }

    // Add a product to csv
    public static void addProductToCSV(Product product) {
        List<Product> products = CSVReader.readProductsFromCSV(CSV_FILE_PATH2);

        products.add(product);

        CSVWriter.writeToProductsCSV(CSV_FILE_PATH2, product);
    }

    // remove a product from csv
    public static void removeProductFromCSV(Product product) {
        List<Product> products = CSVReader.readProductsFromCSV(CSV_FILE_PATH2);

        products.removeIf(prod -> prod.getName().equals(product.getName()));

        CSVWriter.updateProductsCSV(CSV_FILE_PATH2, products);

    }

    // Update a product in the CSV file
    public static void updateProductInCSV(Product updatedProduct) {
        List<Product> products = CSVReader.readProductsFromCSV(CSV_FILE_PATH2);

        // Find the product to be updated and replace it with the updated product
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getName().equals(updatedProduct.getName())) {
                products.set(i, updatedProduct);
                break;
            }
        }

        // Write the updated list of products back to the CSV file
        CSVWriter.updateProductsCSV( CSV_FILE_PATH2, products);
    }

    // Add a review to csv
    public static void addReviewToCSV(Reviews review) {
        List<Reviews> reviews = CSVReader.readReviewsFromCSV(CSV_FILE_PATH4);

        reviews.add(review);

        CSVWriter.writeToReviewsCSV(CSV_FILE_PATH4, review);
    }



}

