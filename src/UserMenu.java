import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class UserMenu {
    private final List<Brand> brands;
    private final Scanner scanner;
    private final List<Brand> favoriteBrands; // Declare // favoriteBrands variable

    public UserMenu(List<Brand> brands) {
        this.brands = brands;
        this.favoriteBrands = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("User Menu");
            System.out.println("1. Browse Brands");
            System.out.println("2. Search Brands by Criteria");
            System.out.println("3. Inquire about Brand History");
            System.out.println("4. View product listing for a brand");
            System.out.println("5. Mark Brand as favorite");
            System.out.println("6. Show My favorite Brands");
            System.out.println("7. Purchase Products from Brand of choice");
            System.out.println("8. Leave review/rating for a brand");
            System.out.println("9. Check brand score");
            System.out.println("10. Leave review/rating for a product");
            System.out.println("11. Check Product score");
            System.out.println("12. Check Brand's Performance Data");
            System.out.println("13. Exit to Main Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Browse Brands
                    browseBrands(brands);
                    break;

                case 2:
                    System.out.println("1. Search Brands by Category");
                    System.out.println("2. Search Brands by Country of Origin");
                    System.out.println("3. Exit to the main menu.");
                    System.out.print("Enter your choice: ");
                    do {
                        choice = scanner.nextInt();
                        scanner.nextLine(); //
                        switch (choice) {
                            case 1:
                                searchBrandsByCategory(scanner);
                                break;
                            case 2:
                                searchBrandsByCountryOfOrigin(scanner);
                                break;
                            case 3:
                                System.out.println("Exiting to the main menu.");
                                break;
                        }

                    }    while (choice != 3) ;
                    break;
                case 3:
                    inquireBrandHistory(brands);
                    break;
                case 4:
                    // View product listing for a brand
                    viewAndInquireAboutProduct(brands);
                    break;
                case 5:
                    markBrandAsFavorite(new BrandDatabase());
                    break;
                case 6:
                    viewFavoriteBrands();
                    break;
                case 7:
                    purchaseProductsFromBrand();
                    break;
                case 8:
                    leaveBrandReview();
                    break;
                case 9:
                    viewBrandReviewsAndRatings();
                    break;
                case 10:
                    productReview();
                    break;
                case 11:
                    viewProductReviews();
                    break;
                case 12:
                    //viewBrandPerformance(new PerformanceData());
                    break;
                case 13:
                    System.out.println("Exiting to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 12) ;
    }



    private void browseBrands(List<Brand> brands) {
        System.out.println("Available Brands:");
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
            System.out.println((i + 1) + ". " + brand.getName());
        }

        Scanner scanner = new Scanner(System.in);
        int brandNumber = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Enter the brand number to view details (or press enter to go back to the menu):");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("Returning to the menu.");
                validInput = true;
            } else {

                try {
                    brandNumber = Integer.parseInt(input);
                    if (brandNumber >= 1 && brandNumber <= brands.size()) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid brand number. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        }

        if (brandNumber != 0) {
            Brand brand = brands.get(brandNumber - 1);
            viewBrandDetails(brand);
        }


    }

    private void viewBrandDetails(Brand brand) {
        System.out.println("Brand Details:");
        System.out.println("Name: " + brand.getName());
        System.out.println("Category: " + brand.getCategory());
        System.out.println("Year Founded: " + brand.getYearFounded());
        System.out.println("Country of Origin: " + brand.getCountryOfOrigin());
    }
    private void searchBrandsByCategory(Scanner scanner) {
        System.out.print("Enter the category to search for: ");
        String category = scanner.nextLine();


        List<Brand> matchingBrands = new ArrayList<>();
        for (Brand brand : brands) {
            if (brand.getCategory().equalsIgnoreCase(category)) {
                matchingBrands.add(brand);
            }
        }

        if (matchingBrands.isEmpty()) {
            System.out.println("No brands found with the specified category.");
        } else {
            System.out.println("Matching brands:");
            for (Brand brand : matchingBrands) {
                System.out.println(brand.getName());
            }
        }
    }

    private void searchBrandsByCountryOfOrigin(Scanner scanner) {
        System.out.print("Enter the country of origin to search for: ");
        String countryOfOrigin = scanner.nextLine();

        List<Brand> matchingBrands = new ArrayList<>();
        for (Brand brand : brands) {
            if (brand.getCountryOfOrigin().equalsIgnoreCase(countryOfOrigin)) {
                matchingBrands.add(brand);
            }
        }

        if (matchingBrands.isEmpty()) {
            System.out.println("No brands found with the specified country of origin.");
        } else {
            System.out.println("Matching brands:");
            for (Brand brand : matchingBrands) {
                System.out.println(brand.getName());
            }
        }
    }

    public void inquireBrandHistory(List<Brand> brands) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the brand you want to inquire about:");
        String brandName = scanner.nextLine();

        Brand selectedBrand = null;
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                selectedBrand = brand;
                break;
            }
        }

        if (selectedBrand != null) {
            System.out.println("Brand: " + selectedBrand.getName());
            System.out.println("History: " + selectedBrand.getBrandHistory());
        } else {
            System.out.println("Brand not found.");
        }
    }

    public void viewAndInquireAboutProduct(List<Brand> brands) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the brand to view its product listings:");
        String brandName = scanner.nextLine();

        Brand selectedBrand = null;
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                selectedBrand = brand;
                break;
            }
        }

        if (selectedBrand != null) {
            System.out.println("Products for " + selectedBrand.getName() + ":");
            List<Product> products = selectedBrand.getProducts();
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                System.out.println((i + 1) + ". " + product.getName());
            }

            System.out.print("Enter the number of the product to inquire about (0 to go back): ");
            int productChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (productChoice > 0 && productChoice <= products.size()) {
                Product selectedProduct = products.get(productChoice - 1);
                System.out.println("Product Name: " + selectedProduct.getName());
                System.out.println("Price: " + selectedProduct.getPrice());
                System.out.println("Description: " + selectedProduct.getDescription());
                // You can add more product details here if needed
            } else // User chose to go back
                if (productChoice == 0) return;
                else {
                System.out.println("Invalid product choice.");
            }
        } else {
            System.out.println("Brand not found.");
        }
    }
    public void markBrandAsFavorite(BrandDatabase brandDatabase) {
        // Display a list of available brands to the user
        List<Brand> brands = brandDatabase.getBrands();
        System.out.println("Available Brands:");
        for (int i = 0; i < brands.size(); i++) {
            System.out.println((i + 1) + ". " + brands.get(i).getName());
        }

        // Ask the user to select a brand to mark as a favorite
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the brand you want to mark as a favorite: ");
        int choice = scanner.nextInt();

        // Check if the user's choice is valid
        if (choice >= 1 && choice <= brands.size()) {
            Brand selectedBrand = brands.get(choice - 1);

            // Mark the selected brand as a favorite for the user
            favoriteBrands.add(selectedBrand); // Add the brand to the favoriteBrands list

            System.out.println(selectedBrand.getName() + " has been marked as a favorite.");
        } else {
            System.out.println("Invalid choice. Please select a valid brand.");
        }
    }

    public void viewFavoriteBrands() {

        if (favoriteBrands.isEmpty()) {
            System.out.println("You haven't marked any brands as favorites yet.");
        } else {
            System.out.println("Your Favorite Brands:");
            for (Brand brand : favoriteBrands) {
                System.out.println(brand.getName());
            }
        }
    }
    public void purchaseProductsFromBrand() {
        Scanner scanner = new Scanner(System.in);
        List<Product> purchasedProducts = new ArrayList<>(); // A list to track purchased products

        System.out.println("Enter the name of the brand you want to purchase products from:");
        String brandName = scanner.nextLine();

        Brand selectedBrand = null;
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                selectedBrand = brand;
                break;
            }
        }

        if (selectedBrand != null) {
            System.out.println("Products available from " + selectedBrand.getName() + ":");
            List<Product> products = selectedBrand.getProducts();

            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                System.out.println((i + 1) + ". " + product.getName() + " (Price: " + product.getPrice() + ")");
            }

            System.out.print("Enter the number of the product you want to purchase (0 to exit): ");
            int productChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (productChoice > 0 && productChoice <= products.size()) {
                Product selectedProduct = products.get(productChoice - 1);

                System.out.print("Enter the quantity you want to purchase: ");
                int quantity = scanner.nextInt();

                if (selectedProduct.purchase(quantity)) {
                    purchasedProducts.add(selectedProduct);
                    System.out.println("Purchase successful.");
                } else {
                    System.out.println("Purchase failed due to insufficient stock.");
                }
            } else if (productChoice == 0) {
                // User chose to go back
                return;
            } else {
                System.out.println("Invalid product choice.");
            }
        } else {
            System.out.println("Brand not found.");
        }

    }

    public void leaveBrandReview() {
        System.out.println("Enter the name of the brand you want to review:");
        String brandName = scanner.nextLine();

        Brand selectedBrand = null;
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                selectedBrand = brand;
                break;
            }
        }

        if (selectedBrand != null) {
            System.out.println("Enter your review for " + selectedBrand.getName() + ":");
            String review = scanner.nextLine();

            System.out.println("Enter your rating (1-5) for " + selectedBrand.getName() + ":");
            int rating = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (rating < 1 || rating > 5) {
                System.out.println("Invalid rating. Please enter a number between 1 and 5.");
            } else {
                // You can associate the review and rating with the brand
                selectedBrand.addReview(review, rating);
                System.out.println("Review and rating have been added successfully.");
            }
        } else {
            System.out.println("Brand not found.");
        }
    }


    public void viewBrandReviewsAndRatings() {
        System.out.println("Enter the name of the brand to see reviews:");
        String brandName = scanner.nextLine();

        Brand selectedBrand = null;
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                selectedBrand = brand;
                break;
            }
        }

       if (selectedBrand != null) {
            List<Review> brandReviews = selectedBrand.getBrandReviews();
            if (brandReviews.isEmpty()) {
                System.out.println("No reviews and ratings available for " + selectedBrand.getName() + ".");
            } else {
                System.out.println("Reviews and Ratings for " + selectedBrand.getName() + ":");
                for (int i = 0; i < brandReviews.size(); i++) {
                    Review review = brandReviews.get(i);
                    System.out.println("Review " + (i + 1) + ":");
                    System.out.println("Rating: " + review.getRating());
                    System.out.println("Review: " + review.getText());
                    System.out.println("-----");
                }
            }
        } else {
            System.out.println("Brand not found.");
        }
    }

    public void productReview() {
        System.out.println("Enter the name of the brand to review products:");
        String brandName = scanner.nextLine();

        Brand selectedBrand = null;
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                selectedBrand = brand;
                break;
            }
        }

        if (selectedBrand != null) {
            List<Product> products = selectedBrand.getProducts();

            System.out.println("Select a product from " + selectedBrand.getName() + " to review:");
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                System.out.println((i + 1) + ". " + product.getName());
            }

            int productChoice;
            do {
                System.out.print("Enter the number of the product to review (0 to cancel): ");
                productChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (productChoice == 0) {
                    System.out.println("Review canceled.");
                    return;
                } else if (productChoice < 0 || productChoice > products.size()) {
                    System.out.println("Invalid product choice. Please try again.");
                }
            } while (productChoice < 0 || productChoice > products.size());

            Product selectedProduct = products.get(productChoice - 1);

            System.out.println("Enter your review for " + selectedProduct.getName() + ":");
            String review = scanner.nextLine();

            System.out.println("Enter your rating (1-5) for " + selectedProduct.getName() + ":");
            int rating = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (rating < 1 || rating > 5) {
                System.out.println("Invalid rating. Please enter a number between 1 and 5.");
            } else {
                // You can associate the review and rating with the selected product
                selectedProduct.addReview(review, rating);
                System.out.println("Review and rating have been added successfully for " + selectedProduct.getName() + ".");
            }
        } else {
            System.out.println("Brand not found.");
        }
    }

        public void viewProductReviews() {
            System.out.println("Enter Brand of the product you want to view:");
            String brandName = scanner.nextLine();

            Brand selectedBrand = null;
            for (Brand brand : brands) {
                if (brand.getName().equalsIgnoreCase(brandName)) {
                    selectedBrand = brand;
                    break;
                }
            }

            if (selectedBrand != null) {
                List<Product> products = selectedBrand.getProducts();

                System.out.println("Select a product from " + selectedBrand.getName() + " to view reviews:");
                for (int i = 0; i < products.size(); i++) {
                    Product product = products.get(i);
                    System.out.println((i + 1) + ". " + product.getName());
                }

                int productChoice;
                do {
                    System.out.print("Enter the number of the product to view reviews (0 to cancel): ");
                    productChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (productChoice == 0) {
                        System.out.println("Review viewing canceled.");
                        return;
                    } else if (productChoice < 0 || productChoice > products.size()) {
                        System.out.println("Invalid product choice. Please try again.");
                    }
                } while (productChoice < 0 || productChoice > products.size());

                Product selectedProduct = products.get(productChoice - 1);

                System.out.println("Reviews for " + selectedProduct.getName() + ":");
                List<Review> reviews = selectedProduct.getReviews();
                if (reviews.isEmpty()) {
                    System.out.println("No reviews available for " + selectedProduct.getName() + ".");
                } else {
                    for (Review review : reviews) {
                        System.out.println("Rating: " + review.getRating() + " - Review: " + review.getText());
                    }
                }
            } else {
                System.out.println("Brand not found.");
            }
        }
    public void viewBrandPerformance(PerformanceData performanceData) {
        System.out.println("View Brand Performance and Product Sales");

        if (performanceData == null) {
            System.out.println("Performance data not available.");
            return;
        }

        System.out.println("Name: " + performanceData.getName());

        // Display past sales trends
        System.out.println("Past Sales Trends:");
        List<SalesRecord> salesHistory = performanceData.getSalesHistory();
        if (salesHistory.isEmpty()) {
            System.out.println("No sales data available.");
        } else {
            System.out.println("Year | Quantity Sold | Total Revenue");
            for (SalesRecord salesRecord : salesHistory) {
                System.out.println(salesRecord.getYear() + " | " + salesRecord.getQuantitySold() + " | $" + salesRecord.getTotalRevenue());
            }
        }

        // Display product popularity
        System.out.println("Product Popularity:");
        List<ProductPopularity> productPopularity = performanceData.getProductPopularity();
        if (productPopularity.isEmpty()) {
            System.out.println("No product popularity data available.");
        } else {
            System.out.println("Product | Popularity Score");
            for (ProductPopularity popularity : productPopularity) {
                System.out.println(popularity.getProductName() + " | " + popularity.getPopularityScore());
            }
        }

        // You can also display other relevant performance data here, such as user reviews and ratings.

        System.out.println("End of Brand Performance and Product Sales.");
    }



}

