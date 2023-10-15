import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private List<Brand> brands;
    private Scanner scanner;

    public AdminMenu(List<Brand> brands) {
        this.brands = brands;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("Administrator Menu");
            System.out.println("1. Add Brand");
            System.out.println("2. Edit/Update Brand");
            System.out.println("3. Remove Brand");
            System.out.println("4. Add Product to Brand");
            System.out.println("5. Remove Product from Brand");
            System.out.println("6. Categorize Brands");
            System.out.println("7. Track and Manage Product Inventory");
            System.out.println("8. Generate Reports");
            System.out.println("9. Monitor User Feedback");
            System.out.println("10. Exit to Main Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Add Brand
                    addBrand(brands);
                    break;
                case 2:
                    // Edit/Update Brand
                    editBrand(brands);
                    break;
                case 3:
                    // Remove Brand
                    // TODO: Implement removeBrand method
                    break;
                case 4:
                    // Add Product to Brand
                    // TODO: Implement addProductToBrand method
                    break;
                case 5:
                    // Remove Product from Brand
                    // TODO: Implement removeProductFromBrand method
                    break;
                case 6:
                    // Categorize Brands
                    // TODO: Implement categorizeBrands method
                    break;
                case 7:
                    // Track and Manage Product Inventory
                    // TODO: Implement trackAndManageInventory method
                    break;
                case 8:
                    // Generate Reports
                    // TODO: Implement generateReports method
                    break;
                case 9:
                    // Monitor User Feedback
                    // TODO: Implement monitorUserFeedback method
                    break;
                case 10:
                    System.out.println("Exiting to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 10);
    }

    private void addBrand(List<Brand> brands) {
        System.out.println("Adding a New Brand");
        System.out.print("Enter the brand name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the brand category: ");
        String category = scanner.nextLine();

        System.out.print("Enter the year the brand was founded: ");
        int yearFounded = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the country of origin: ");
        String countryOfOrigin = scanner.nextLine();


        // Create a new brand and add it to the list of brands
        Brand newBrand = new Brand(name, category, yearFounded, countryOfOrigin);
        brands.add(newBrand);

        System.out.println("Brand added successfully.");
    }

    private void editBrand(List<Brand> brands) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the brand you want to edit: ");
        String brandName = scanner.nextLine();

        Brand brandToEdit = null;
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                brandToEdit = brand;
                break;
            }
        }

        if (brandToEdit == null) {
            System.out.println("Brand not found.");
            return;
        }

        System.out.println("Editing Brand: " + brandToEdit.getName());
        System.out.print("Enter new name (or press Enter to keep the same): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            brandToEdit.setName(newName);
        }

        System.out.print("Enter new category (or press Enter to keep the same): ");
        String newCategory = scanner.nextLine();
        if (!newCategory.isEmpty()) {
            brandToEdit.setCategory(newCategory);
        }

        System.out.print("Enter new founding year (or press Enter to keep the same): ");
        String yearStr = scanner.nextLine();
        if (!yearStr.isEmpty()) {
            try {
                int newYear = Integer.parseInt(yearStr);
                brandToEdit.setYearFounded(newYear);
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format. Brand details were not updated.");
            }
        }

        System.out.print("Enter new country of origin (or press Enter to keep the same): ");
        String newCountry = scanner.nextLine();
        if (!newCountry.isEmpty()) {
            brandToEdit.setCountry(newCountry);
        }


        System.out.println("Brand details updated successfully.");
    }

}