import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class UserMenu {
    private List<Brand> brands;
    private Scanner scanner;

    public UserMenu(List<Brand> brands) {
        this.brands = brands;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("User Menu");
            System.out.println("1. Browse Brands");
            System.out.println("2. Search Brands by Criteria");
            System.out.println("3. Exit to Main Menu");
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

        scanner.close();
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
}

