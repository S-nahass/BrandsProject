import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private List<Brand> brands;
    private Scanner scanner;
    private List<PerformanceData> performanceDataList;
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
                    removeBrand(brands);
                    break;
                case 4:
                    // Add Product to Brand
                    addProductToBrand();
                    break;
                case 5:
                    // Remove Product from Brand
                    removeProductFromBrand();
                    break;
                case 6:
                    // Categorize Brands
                    categorizeBrand();
                    break;
                case 7:
                    // Track and Manage Product Inventory
                    manageOrTrackInventory();
                    break;
                case 8:
                    // Generate Reports
                    generateReports();
                    break;
                case 9:
                    // Monitor User Feedback
                    monitorUserFeedback();
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


    private Brand chooseBrand() {
        System.out.println("Available Brands:");
        for (int i = 0; i < brands.size(); i++) {
            System.out.println((i + 1) + ". " + brands.get(i).getName());
        }

        int choice;
        boolean isValidChoice = false;

        do {
            System.out.print("Enter the number of the brand: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            if (choice < 1 || choice > brands.size()) {
                System.out.println("Invalid choice. Please enter a valid number.");
            } else {
                isValidChoice = true;
            }
        } while (!isValidChoice);

        return brands.get(choice - 1);
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

    private void removeBrand(List<Brand> brands) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the brand you want to remove: ");
        String brandName = scanner.nextLine();

        Brand brandToRemove = null;
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                brandToRemove = brand;
                break;
            }
        }

        if (brandToRemove == null) {
            System.out.println("Brand not found.");
            return;
        }

        brands.remove(brandToRemove);
        System.out.println("Brand removed successfully.");
    }

    public void addProductToBrand() {
        System.out.println("Enter the name of the brand to which you want to add a product:");
        String brandName = scanner.nextLine();

        Brand selectedBrand = null;
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                selectedBrand = brand;
                break;
            }
        }

        if (selectedBrand != null) {
            System.out.print("Enter the name of the new product: ");
            String productName = scanner.nextLine();
            System.out.print("Enter the price of the new product: ");
            double productPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter the description of the new product: ");
            String productDescription = scanner.nextLine();

            // Create a new product
            Product newProduct = new Product(productName, productPrice, productDescription);

            // Add the new product to the selected brand
            selectedBrand.addProduct(newProduct);

            System.out.println("New product added to " + selectedBrand.getName() + ": " + productName);
        } else {
            System.out.println("Brand not found.");
        }
    }

    public void removeProductFromBrand() {
        System.out.println("Enter the name of the brand from which you want to remove a product:");
        String brandName = scanner.nextLine();

        Brand selectedBrand = null;
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                selectedBrand = brand;
                break;
            }
        }

        if (selectedBrand != null) {
            System.out.println("Products available in " + selectedBrand.getName() + ":");
            List<Product> products = selectedBrand.getProducts();
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i).getName());
            }

            System.out.print("Enter the number of the product you want to remove (0 to cancel): ");
            int productNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (productNumber >= 1 && productNumber <= products.size()) {
                Product productToRemove = products.get(productNumber - 1);

                // Remove the selected product from the brand
                selectedBrand.removeProduct(productToRemove);

                System.out.println("Product removed from " + selectedBrand.getName() + ": " + productToRemove.getName());
            } else if (productNumber == 0) {
                System.out.println("Operation canceled.");
            } else {
                System.out.println("Invalid product number. Please enter a valid option.");
            }
        } else {
            System.out.println("Brand not found.");
        }
    }

    public void categorizeBrand() {
        System.out.println("Enter the name of the brand you want to categorize:");
        String brandName = scanner.nextLine();

        Brand selectedBrand = null;
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                selectedBrand = brand;
                break;
            }
        }

        if (selectedBrand != null) {
            System.out.print("Enter the new category for " + selectedBrand.getName() + ": ");
            String newCategory = scanner.nextLine();

            selectedBrand.setCategory(newCategory);

            System.out.println(selectedBrand.getName() + " has been categorized as " + newCategory);
        } else {
            System.out.println("Brand not found.");
        }
    }

    public void updateProductInventory() {
        System.out.println("Enter the name of the brand:");
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
            System.out.println("Available products for " + selectedBrand.getName() + ":");

            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                System.out.println((i + 1) + ". " + product.getName());
            }

            System.out.print("Enter the number of the product to manage inventory: ");
            int productChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (productChoice > 0 && productChoice <= products.size()) {
                Product selectedProduct = products.get(productChoice - 1);
                System.out.println("Current inventory level of " + selectedProduct.getName() + ": " + selectedProduct.getInventoryLevel());
                System.out.print("Enter the new inventory level: ");
                int newInventoryLevel = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                selectedProduct.setInventoryLevel(newInventoryLevel);

                System.out.println(selectedProduct.getName() + " inventory level has been updated to " + newInventoryLevel);
            } else {
                System.out.println("Invalid product choice.");
            }
        } else {
            System.out.println("Brand not found.");
        }
    }

    public void viewProductInventory() {
        System.out.println("Enter the name of the brand to view product inventory:");
        String brandName = scanner.nextLine();

        Brand selectedBrand = null;
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                selectedBrand = brand;
                break;
            }
        }

        if (selectedBrand != null) {
            System.out.println("Product Inventory for " + selectedBrand.getName() + ":");
            List<Product> products = selectedBrand.getProducts();
            for (Product product : products) {
                System.out.println("Name: " + product.getName());
                System.out.println("Inventory Level: " + product.getInventoryLevel());
                System.out.println();
            }
        } else {
            System.out.println("Brand not found.");
        }
    }

    public void manageOrTrackInventory() {


        System.out.println("choose from the following:");
        System.out.println("1. Manage inventory");
        System.out.println("2. View inventory");

            int inventoryChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (inventoryChoice) {
                case 1:
                    // manage
                    updateProductInventory();
                    break;
                case 2:
                    // view
                    viewProductInventory();
                    break;
            }


    }

    public void generateReports() {

        System.out.println("Choose the type of report to generate:");
        System.out.println("1. Brand Performance Report");
        System.out.println("2. Product Sales Report");

        int reportChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (reportChoice) {
            case 1:
                generateBrandPerformanceReport();
                break;
            case 2:
                generateProductSalesReport();
                break;
            default:
                System.out.println("Invalid report choice.");
                break;
        }
    }

    private void generateBrandPerformanceReport() {
        // Logic to generate the brand performance report
        Brand selectedBrand = chooseBrand();
        System.out.println("Brand Performance Report for " + selectedBrand.getName() + ":");

        // Retrieve performance data for the brand
            PerformanceData performanceData = getPerformanceData(selectedBrand.getName());

            if (performanceData != null) {
                // Display sales records
                List<SalesRecord> salesHistory = performanceData.getSalesHistory();
                System.out.println("Sales Records:");
                for (SalesRecord salesRecord : salesHistory) {
                    System.out.println("Year: " + salesRecord.getYear());
                    System.out.println("Quantity Sold: " + salesRecord.getQuantitySold());
                    System.out.println("Total Revenue: " + salesRecord.getTotalRevenue());
                }

                // Display product popularity
                List<ProductPopularity> productPopularity = performanceData.getProductPopularity();
                System.out.println("Product Popularity:");
                for (ProductPopularity popularity : productPopularity) {
                    System.out.println("Product Name: " + popularity.getProductName());
                    System.out.println("Popularity Score: " + popularity.getPopularityScore());
                }
            } else {
                System.out.println("Performance data not available for this brand.");
            }
        }


    private void generateProductSalesReport() {

        Brand selectedBrand = chooseBrand();

        // Logic to generate the product sales report
        System.out.println("Product Sales Report:");
        for (Brand brand : brands) {
            List<Product> products = brand.getProducts();
            System.out.println("Brand: " + brand.getName());

            for (Product product : products) {
                // Retrieve performance data for the product
                PerformanceData performanceData = getPerformanceData(product.getName());

                if (performanceData != null) {
                    // Display sales records for the product
                    List<SalesRecord> salesHistory = performanceData.getSalesHistory();
                    System.out.println("Product: " + product.getName());
                    System.out.println("Sales Records:");
                    for (SalesRecord salesRecord : salesHistory) {
                        System.out.println("Year: " + salesRecord.getYear());
                        System.out.println("Quantity Sold: " + salesRecord.getQuantitySold());
                        System.out.println("Total Revenue: " + salesRecord.getTotalRevenue());
                    }
                } else {
                    System.out.println("Performance data not available for this product.");
                }
            }
        }

    }
    private PerformanceData getPerformanceData(String name) {
        for (PerformanceData data : performanceDataList) {
            if (data.getName().equalsIgnoreCase(name)) {
                return data;
            }
        }
        return null; // Data not found
    }

    public void monitorUserFeedback() {

    }


}