package Util;

import Model.Brand;
import Model.Product;
import Model.Reviews;

import java.io.*;
import java.util.List;

public class CSVWriter {
    // Write a brand to a CSV file
    public static void writeToCSV(String filePath, Brand brand) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            StringBuilder line = new StringBuilder();

            // Assuming Brand has appropriate getter methods
            line.append(brand.getName()).append(",");
            line.append(brand.getCategory()).append(",");
            line.append(brand.getYearFounded()).append(",");
            line.append(brand.getCountryOfOrigin()).append(",");
            line.append("history").append(",");
            // Add more fields as needed

            line.deleteCharAt(line.length() - 1); // Remove the trailing comma
            writer.write(line + "\n");
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    // Write (overwrite) a list of brands to a CSV file
    public static void writeBrandsToCSV(List<Brand> brands, String filePath) {
        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            // Write the header
            writer.write("Name,Category,YearFounded,CountryOfOrigin,BrandHistory\n");

            // Write the brands
            for (Brand brand : brands) {
                String brandLine = brand.getName() + "," +
                        brand.getCategory() + "," +
                        brand.getYearFounded() + "," +
                        brand.getCountryOfOrigin() + "," +
                        brand.getBrandHistory() + ",\n";

                writer.write(brandLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Write a product to a CSV file
    public static void writeToProductsCSV(String filePath, Product product) {
        try (FileWriter writer = new FileWriter(filePath, true)) {

            // Assuming Product has appropriate getter methods
            String line = product.getBrandName() + "," +
                    product.getName() + "," +
                    product.getPrice() + "," +
                    product.getDescription() + "," +
                    product.getInventoryLevel();
            // Add more fields as needed

            writer.write(line + "\n");
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    // overwrite a product to a CSV file
    public static void updateProductsCSV(String filePath, List<Product> products) {
        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            // Write the header
            writer.write("BrandName,ProductName,ProductPrice,ProductDescription,InventoryLevel,ProductPopularity\n");

            // Write the products
            for (Product product : products) {
                String productLine = product.getBrandName() + "," +
                        product.getName() + "," +
                        product.getPrice() + "," +
                        product.getDescription() + "," +
                        product.getInventoryLevel() + "," +
                        product.getPopularityScore() + ",\n";

                writer.write(productLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }


    // Write a review to a CSV file
    public static void writeToReviewsCSV(String csvFilePath4, Reviews review) {
        try (FileWriter writer = new FileWriter(csvFilePath4, true)) {

            String line = review.getBrandName() + "," +
                    review.getUserName() + "," +
                    review.getRating() + "," +
                    review.getComment();
            // Add more fields as needed

            writer.write(line + "\n");
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}