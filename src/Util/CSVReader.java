package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Model.Brand;
import Model.Product;
import Model.Report;
import Model.Reviews;

// Read a CSV file
public class CSVReader {

    // Read brands from a CSV file
    public static List<Brand> readBrandsFromCSV(String fileName) {
        List<Brand> brands = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Skip the header
            reader.readLine();

            // Read the brands
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 4) {
                    String name = fields[0];
                    String category = fields[1];
                    int yearFounded = Integer.parseInt(fields[2]);
                    String countryOfOrigin = fields[3];
                    String brandHistory = fields[4];
                    Brand brand = new Brand(name, category, yearFounded, countryOfOrigin, brandHistory);
                    brands.add(brand);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
        }

        return brands;
    }

    // Fetch a brand from the CSV file
    public static Brand getBrandFromFile(String brandName) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/USER/Desktop/BrandsProject/src/Brands.csv"))) {
            // Skip the header
            br.readLine();

            // Read the brands
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming brand name is the first field in the CSV
                String name = line.split(",")[0];
                if (name.equalsIgnoreCase(brandName)) {
                    // Assuming the Brand constructor takes the brand name, category, year founded, and country of origin as parameters
                    String[] fields = line.split(",");
                    return new Brand(fields[0], fields[1], Integer.parseInt(fields[2]), fields[3], fields[4]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Read products from a CSV file
    public static List<Product> readProductsFromCSV(String filePath) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Skip the header line
            String header = reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) { // Assuming there are at least five fields
                    String brandName = data[0].trim();
                    String productName = data[1].trim();
                    double productPrice = Double.parseDouble(data[2].trim());
                    String productDescription = data[3].trim();
                    int inventoryLevel = Integer.parseInt(data[4].trim());
                    int popularity = Integer.parseInt(data[5].trim());

                    Product product = new Product(brandName, productName, productPrice, productDescription, inventoryLevel, popularity);
                    products.add(product);
                } else {
                    // Handle incomplete or invalid data as needed
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return products;
    }

    // get products by brand name
    public static List<Product> getProductsByBrand(String brandName, String filePath) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                // Assuming the brand name is the first field in the CSV
                if (fields[0].equalsIgnoreCase(brandName)) {
                    // Assuming the Product constructor takes the brand name, product name, product price, product description, and inventory level as parameters
                    Product product = new Product(fields[0], fields[1], Double.parseDouble(fields[2]), fields[3], Integer.parseInt(fields[4]), Integer.parseInt(fields[5]));
                    products.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    // Read reports from a CSV file
    public static List<Report> readReportsFromCSV(String filePath) {
        List<Report> reports = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // Assuming Report has a constructor that takes Brand Name, Year, Quantity Sold, Total Revenue, Product Name, and Popularity Score
                Report report = new Report(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]), Double.parseDouble(values[3]), values[4], Integer.parseInt(values[5]));
                reports.add(report);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reports;
    }

    // Read reviews from a CSV file
    public static List<Reviews> readReviewsFromCSV(String filePath) {
        List<Reviews> reviews = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // Assuming Review has a constructor that takes Brand Name, User Name, Rating, and Comment
                Reviews review = new Reviews(values[0], values[1], Integer.parseInt(values[2]), values[3]);
                reviews.add(review);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reviews;

    }

}
