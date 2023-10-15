import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class UserMenu {
    private List<Brand> brands;
    private Scanner scanner;
    private List<Brand> favoriteBrands; // Declare // favoriteBrands variable

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
            System.out.println(". Exit to Main Menu");
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
                    System.out.print("Enter your choice: ");
                    int subChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    switch (subChoice) {
                        case 1:
                            searchBrandsByCategory(scanner);
                            break;
                        case 2:
                            searchBrandsByCountryOfOrigin(scanner);
                            break;
                        case 4:
                            System.out.println("Exiting to the main menu.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                    }
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
                    System.out.println("Exiting to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 3) ;
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





}

