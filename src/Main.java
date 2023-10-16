import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BrandDatabase brandDatabase = new BrandDatabase();
        AdminMenu adminMenu = new AdminMenu(brandDatabase.getBrands());
        UserMenu userMenu = new UserMenu(brandDatabase.getBrands());


        int choice;
        do {
            System.out.println("Main Menu");
            System.out.println("1. Administrator Mode");
            System.out.println("2. User Mode");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Administrator Mode
                    adminMenu.displayMenu();
                    break;
                case 2:
                    // User Mode
                    userMenu.displayMenu();
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 3);

        scanner.close();
    }
}