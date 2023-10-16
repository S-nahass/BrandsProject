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
            System.out.println("8. Leave Review for Brand or Product");
            System.out.println("9. Check Brand/Product Reviews and Ratings");
            System.out.println("10. Check Brand's Performance Data");
            System.out.println("11. Exit to Main Menu");
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
                    leaveReview();
                    break;
                case 9:
                    viewReviews(scanner);
                    break;
                case 10:
                    //viewBrandPerformance(new PerformanceData());
                    break;
                case 11:
                    System.out.println("Exiting to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 11) ;
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

    public void leaveReview() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Leave a Review");
        System.out.println("1. Leave a review for a brand");
        System.out.println("2. Leave a review for a product");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice == 1) {
            leaveBrandReview(scanner);
        } else if (choice == 2) {
            leaveProductReview(scanner);
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }

    private void leaveBrandReview(Scanner scanner) {
        System.out.println("Available Brands:");
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
            System.out.println((i + 1) + ". " + brand.getName());
        }

        System.out.print("Enter the number of the brand you want to review: ");
        int brandNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (brandNumber < 1 || brandNumber > brands.size()) {
            System.out.println("Invalid brand number.");
            return;
        }

        Brand selectedBrand = brands.get(brandNumber - 1);

        System.out.print("Enter your review for " + selectedBrand.getName() + ": ");
        String reviewText = scanner.nextLine();

        System.out.print("Rate " + selectedBrand.getName() + " (1 to 5 stars): ");
        int rating = scanner.nextInt();
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Please enter a rating between 1 and 5.");
            return;
        }
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter your username (or leave it empty for 'Anonymous'): ");
        String userName = scanner.nextLine();

        // Create a UserReview object
        UserReview userReview = new UserReview(userName, selectedBrand, rating, reviewText);

        // Add the review to the brand
        selectedBrand.addUserReview(userReview);

        System.out.println("Review for " + selectedBrand.getName() + " has been submitted.");
    }


    private void leaveProductReview(Scanner scanner) {
        System.out.println("Available Brands:");
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
            System.out.println((i + 1) + ". " + brand.getName());
            List<Product> products = brand.getProducts();
            for (int j = 0; j < products.size(); j++) {
                System.out.println("   " + (j + 1) + ". " + products.get(j).getName());
            }
        }

        System.out.print("Enter the number of the brand you want to review: ");
        int brandNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (brandNumber < 1 || brandNumber > brands.size()) {
            System.out.println("Invalid brand number.");
            return;
        }

        Brand selectedBrand = brands.get(brandNumber - 1);
        List<Product> productsInBrand = selectedBrand.getProducts();

        System.out.print("Enter the number of the product you want to review: ");
        int productNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (productNumber < 1 || productNumber > productsInBrand.size()) {
            System.out.println("Invalid product number.");
            return;
        }

        Product selectedProduct = productsInBrand.get(productNumber - 1);

        System.out.print("Enter your review for " + selectedProduct.getName() + ": ");
        String reviewText = scanner.nextLine();

        System.out.print("Rate " + selectedProduct.getName() + " (1 to 5 stars): ");
        int rating = scanner.nextInt();
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Please enter a rating between 1 and 5.");
            return;
        }
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter your username (or leave it empty for 'Anonymous'): ");
        String userName = scanner.nextLine();

        // Create a UserReview object
        UserReview userReview = new UserReview(userName, selectedProduct, rating, reviewText);

        // Add the review to the product
        selectedProduct.addUserReview(userReview);

        System.out.println("Review for " + selectedProduct.getName() + " has been submitted.");
    }
    private void viewReviews(Scanner scanner) {
        System.out.println("What would you like to see reviews for?");
        System.out.println("1. Brands");
        System.out.println("2. Products");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                viewBrandReviews(scanner);
                break;
            case 2:
                viewProductReviews(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }

    private void viewBrandReviews(Scanner scanner) {
        System.out.println("Available Brands:");
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
            System.out.println((i + 1) + ". " + brand.getName());
        }

        System.out.print("Enter the number of the brand you want to see reviews for: ");
        int brandNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (brandNumber < 1 || brandNumber > brands.size()) {
            System.out.println("Invalid brand number.");
            return;
        }

        Brand selectedBrand = brands.get(brandNumber - 1);

        List<UserReview> brandReviews = selectedBrand.getBrandReviews();

        if (brandReviews.isEmpty()) {
            System.out.println("No reviews available for " + selectedBrand.getName());
        } else {
            System.out.println("Reviews for " + selectedBrand.getName() + ":");
            for (UserReview review : brandReviews) {
                System.out.println("Username: " + review.getUserName());
                System.out.println("Rating: " + review.getRating() + " stars");
                System.out.println("Review Text: " + review.getContent());
                System.out.println();
            }
        }
    }


    private void viewProductReviews(Scanner scanner) {
        // Display available products for the user to choose from
        System.out.println("Available Products:");
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
            System.out.println("Brand: " + brand.getName());
            List<Product> products = brand.getProducts();
            for (int j = 0; j < products.size(); j++) {
                Product product = products.get(j);
                System.out.println((i + 1) + "." + (j + 1) + ". " + product.getName());
            }
        }

        System.out.print("Enter the number of the brand and product you want to see reviews for (e.g., 1 2): ");
        int brandNumber = scanner.nextInt();
        int productNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (brandNumber < 1 || brandNumber > brands.size() || productNumber < 1) {
            System.out.println("Invalid brand or product number.");
            return;
        }

        Brand selectedBrand = brands.get(brandNumber - 1);
        List<Product> products = selectedBrand.getProducts();

        if (productNumber > products.size()) {
            System.out.println("Invalid product number for the selected brand.");
            return;
        }

        Product selectedProduct = products.get(productNumber - 1);

        List<UserReview> productReviews = selectedProduct.getReviews();

        if (productReviews.isEmpty()) {
            System.out.println("No reviews available for " + selectedProduct.getName() + " in the " + selectedBrand.getName() + " brand.");
        } else {
            System.out.println("Reviews for " + selectedProduct.getName() + " in the " + selectedBrand.getName() + " brand:");
            for (UserReview review : productReviews) {
                System.out.println("Username: " + review.getUserName());
                System.out.println("Rating: " + review.getRating() + " stars");
                System.out.println("Review Text: " + review.getContent());
                System.out.println();
            }
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


        System.out.println("End of Brand Performance and Product Sales.");
    }



}

