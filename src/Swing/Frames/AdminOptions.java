package Swing.Frames;

import Src.Brand;
import Src.BrandDatabase;
import Src.Product;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static java.awt.BorderLayout.*;

public class AdminOptions extends JFrame {

    private List<Brand> brands = new ArrayList<>();
    private JPanel rightPanel = new JPanel();
    BrandDatabase brandDatabase = new BrandDatabase();

    public AdminOptions() {
        // Set up the frame
        setTitle("Administrator Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create a panel to organize components
        JPanel panel = new JPanel(new BorderLayout());

        // Create a left panel for the menu
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(Color.darkGray);

        // Create buttons for admin functionalities
        JButton[] adminButtons = new JButton[10];
        String[] functionalityText = {
                "Add Brand",
                "Edit/Update Brand",
                "Remove Brand",
                "Add Product to Brand",
                "Remove Product from Brand",
                "Categorize Brands",
                "Manage Inventory",
                "Generate Reports",
                "Monitor User Feedback",
                "Exit to Main Menu"
        };

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        for (int i = 0; i < 10; i++) {
            adminButtons[i] = new JButton();
            adminButtons[i].setText(functionalityText[i]);
            adminButtons[i].setFont(new Font("Garamond", Font.BOLD, 16));
            adminButtons[i].setForeground(Color.white);
            adminButtons[i].setOpaque(false);
            adminButtons[i].setContentAreaFilled(false);
            adminButtons[i].setBorderPainted(false);

            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.weightx = 1.0; // Added this line to give buttons horizontal space
            leftPanel.add(adminButtons[i], gbc);

            final int index = i;
            adminButtons[i].addActionListener(e -> handleFunctionalityClick(index));
        }

        // Create a right panel for result display (initially empty)
        JLabel resultLabel = new JLabel("Results will be displayed here.");
        resultLabel.setFont(new Font("Garamond", Font.BOLD, 16));
        rightPanel.setBackground(new Color(203, 208, 210));
        rightPanel.setAlignmentY(CENTER_ALIGNMENT);

        // Add the left and right panels to the main panel
        panel.add(leftPanel, WEST);
        panel.add(rightPanel, CENTER);

        // Add the main panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);
    }

    // Handle button click events for admin functionalities
    private void handleFunctionalityClick(int index) {
        switch (index) {
            case 0:
                // Add Brand - Implement code for adding a brand
                addBrand(brands);
                break;
            case 1:
                // Edit/Update Brand - Implement code for editing/updating a brand
                editBrand(brands);
                break;
            case 2:
                // Remove Brand - Implement code for removing a brand
                removeBrand(brands);
                break;
            case 3:
                // Add Product to Brand - Implement code for adding a product to a brand
                addProductToBrand(brands);
                break;
            case 4:
                // Remove Product from Brand - Implement code for removing a product from a brand
                break;
            case 5:
                // Categorize Brands - Implement code for categorizing brands
                break;
            case 6:
                // Manage Inventory - Implement code for managing product inventory
                break;
            case 7:
                // Generate Reports - Implement code for generating reports
                break;
            case 8:
                // Monitor User Feedback - Implement code for monitoring user feedback
                break;
            case 9:
                // Exit to Main Menu - Implement code to return to the main menu
                break;
            default:
                break;
        }
    }

    // Method to add a brand using a Swing dialog


    // Method to add a brand using a Swing dialog
    private void addBrand(List<Brand> brands) {
        // Create form components for brand information
        JLabel nameLabel = new JLabel("Brand Name:");
        nameLabel.setFont(new Font("Garamond", Font.BOLD, 16));
        JTextField nameField = new JTextField(20);
        JLabel categoryLabel = new JLabel("Brand Category:");
        categoryLabel.setFont(new Font("Garamond", Font.BOLD, 16));
        JTextField categoryField = new JTextField(20);
        JLabel yearFoundedLabel = new JLabel("Year Founded:");
        yearFoundedLabel.setFont(new Font("Garamond", Font.BOLD, 16));
        JTextField yearFoundedField = new JTextField(20);
        JLabel countryOfOriginLabel = new JLabel("Country of Origin:");
        countryOfOriginLabel.setFont(new Font("Garamond", Font.BOLD, 16));
        JTextField countryOfOriginField = new JTextField(20);

        JButton addButton = new JButton("Add");
        addButton.setFont(new Font("Garamond", Font.BOLD, 16));

        addButton.addActionListener(e -> {
            String brandName = nameField.getText().trim();
            String brandCategory = categoryField.getText().trim();
            String yearFoundedStr = yearFoundedField.getText().trim();
            String countryOfOrigin = countryOfOriginField.getText().trim();

            if (brandName.isEmpty() || brandCategory.isEmpty() || yearFoundedStr.isEmpty() || countryOfOrigin.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Don't proceed with adding the brand
            }

            try {
                int yearFounded = Integer.parseInt(yearFoundedStr);
                if (yearFounded < 0) {
                    JOptionPane.showMessageDialog(null, "Year Founded must be a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Don't proceed with adding the brand
                }

                // Create a new brand and add it to the list of brands
                Brand newBrand = new Brand(brandName, brandCategory, yearFounded, countryOfOrigin, "Brand History");
                brands.add(newBrand);

                // Show a success message
                JOptionPane.showMessageDialog(null, "Brand added successfully.");

                // Clear input fields
                nameField.setText("");
                categoryField.setText("");
                yearFoundedField.setText("");
                countryOfOriginField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Year Founded must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        // Create a panel to organize the form components with GridBagLayout
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Add components to the form panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(nameLabel, gbc);
        gbc.gridy++;
        formPanel.add(nameField, gbc);
        gbc.gridy++;
        formPanel.add(categoryLabel, gbc);
        gbc.gridy++;
        formPanel.add(categoryField, gbc);
        gbc.gridy++;
        formPanel.add(yearFoundedLabel, gbc);
        gbc.gridy++;
        formPanel.add(yearFoundedField, gbc);
        gbc.gridy++;
        formPanel.add(countryOfOriginLabel, gbc);
        gbc.gridy++;
        formPanel.add(countryOfOriginField, gbc);

        // Add the "Add" button to the next row, and make it span multiple columns
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy++;
        formPanel.add(addButton, gbc);

        // Clear the right panel and add the formPanel, filling the available space
        rightPanel.removeAll();
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.add(formPanel);

        rightPanel.revalidate();
        rightPanel.repaint();
    }

    private void editBrand(List<Brand> brands) {
        // Create a form to enter the brand name
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Enter the name of the brand you want to edit:");
        JTextField nameField = new JTextField(20);
        JButton findButton = new JButton("Find Brand");

        findButton.addActionListener(e -> {
            String brandName = nameField.getText().trim();

            Brand brandToEdit = null;
            for (Brand brand : BrandDatabase.getBrands()) {
                if (brand.getName().equalsIgnoreCase(brandName)) {
                    brandToEdit = brand;
                    break;
                }
            }

            if (brandToEdit == null) {
                JOptionPane.showMessageDialog(null, "Brand not found.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Clear the right panel
                rightPanel.removeAll();
                rightPanel.revalidate();
                rightPanel.repaint();

                // Call a method to edit the found brand and display the form on the right panel
                editBrandDetails(brandToEdit);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(nameLabel, gbc);
        gbc.gridy = 1;
        formPanel.add(nameField, gbc);
        gbc.gridy = 2;
        formPanel.add(findButton, gbc);

        // Create a container panel for vertical centering
        JPanel containerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints containerGBC = new GridBagConstraints();
        containerGBC.gridx = 0;
        containerGBC.gridy = 0;
        containerGBC.weighty = 1.0; // Expand vertically
        containerGBC.anchor = GridBagConstraints.NORTH;
        containerPanel.add(formPanel, containerGBC);

        // Clear the right panel and add the formPanel, filling the available space
        rightPanel.removeAll();
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.add(containerPanel);
        rightPanel.revalidate();
        rightPanel.repaint();
    }

    private void editBrandDetails(Brand brandToEdit) {
        // Create a new right panel for editing
        JPanel editPanel = new JPanel(new BorderLayout());

        // Create form components for editing brand information
        JLabel nameLabel = new JLabel("Edit Brand Name (or leave blank to keep the same):");
        JTextField nameField = new JTextField(20);
        nameField.setText(brandToEdit.getName());

        JLabel categoryLabel = new JLabel("Edit Brand Category (or leave blank to keep the same):");
        JTextField categoryField = new JTextField(20);
        categoryField.setText(brandToEdit.getCategory());

        JLabel yearFoundedLabel = new JLabel("Edit Founding Year (or leave blank to keep the same):");
        JTextField yearFoundedField = new JTextField(20);
        yearFoundedField.setText(String.valueOf(brandToEdit.getYearFounded()));

        JLabel countryOfOriginLabel = new JLabel("Edit Country of Origin (or leave blank to keep the same):");
        JTextField countryOfOriginField = new JTextField(20);
        countryOfOriginField.setText(brandToEdit.getCountryOfOrigin());

        JButton saveButton = new JButton("Save Changes");

        saveButton.addActionListener(e -> {
            String newName = nameField.getText().trim();
            String newCategory = categoryField.getText().trim();
            String yearStr = yearFoundedField.getText().trim();
            String newCountry = countryOfOriginField.getText().trim();

            // Validate input
            if (newName.isEmpty() && newCategory.isEmpty() && yearStr.isEmpty() && newCountry.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No changes were made. Please update at least one field.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!newName.isEmpty()) {
                brandToEdit.setName(newName);
            }

            if (!newCategory.isEmpty()) {
                brandToEdit.setCategory(newCategory);
            }

            if (!yearStr.isEmpty()) {
                try {
                    int newYear = Integer.parseInt(yearStr);
                    brandToEdit.setYearFounded(newYear);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid year format. Brand details were not updated.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            if (!newCountry.isEmpty()) {
                brandToEdit.setCountry(newCountry);
            }

            // Show a success message
            JOptionPane.showMessageDialog(null, "Brand details updated successfully.");

            // Clear input fields
            nameField.setText("");
            categoryField.setText("");
            yearFoundedField.setText("");
            countryOfOriginField.setText("");
        });

        // Create a panel to organize the form components
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(nameLabel, gbc);
        gbc.gridy = 1;
        formPanel.add(nameField, gbc);
        gbc.gridy = 2;
        formPanel.add(categoryLabel, gbc);
        gbc.gridy = 3;
        formPanel.add(categoryField, gbc);
        gbc.gridy = 4;
        formPanel.add(yearFoundedLabel, gbc);
        gbc.gridy = 5;
        formPanel.add(yearFoundedField, gbc);
        gbc.gridy = 6;
        formPanel.add(countryOfOriginLabel, gbc);
        gbc.gridy = 7;
        formPanel.add(countryOfOriginField, gbc);
        gbc.gridy = 8;
        formPanel.add(saveButton, gbc);

        // Add the formPanel to the editPanel
        editPanel.add(formPanel, CENTER);

        // Replace the right panel with the editPanel
        rightPanel.remove(rightPanel);
        rightPanel.add(editPanel, CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();
    }

    private void removeBrand(List<Brand> brands) {
        // Create a form to enter the brand name for removal
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Enter the name of the brand you want to remove:");
        JTextField nameField = new JTextField(20);
        JButton removeButton = new JButton("Remove Brand");

        removeButton.addActionListener(e -> {
            String brandName = nameField.getText().trim();

            if (brandName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the brand name to remove.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Confirm the removal with the admin
                int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the brand: " + brandName + "?", "Confirm Removal", JOptionPane.YES_NO_OPTION);

                if (confirmation == JOptionPane.YES_OPTION) {
                    Brand brandToRemove = null;
                    for (Brand brand : BrandDatabase.getBrands()) {
                        if (brand.getName().equalsIgnoreCase(brandName)) {
                            brandToRemove = brand;
                            break;
                        }
                    }

                    if (brandToRemove == null) {
                        JOptionPane.showMessageDialog(null, "Brand not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        brands.remove(brandToRemove);
                        JOptionPane.showMessageDialog(null, "Brand removed successfully.");
                    }
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(nameLabel, gbc);
        gbc.gridy = 1;
        formPanel.add(nameField, gbc);
        gbc.gridy = 2;
        formPanel.add(removeButton, gbc);

        // Clear the right panel and add the formPanel
        rightPanel.removeAll();
        rightPanel.add(formPanel);
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.revalidate();
        rightPanel.repaint();
    }

    private void addProductToBrand(List<Brand> brands) {
        // Create a form to enter product details
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel brandLabel = new JLabel("Enter the name of the brand to which you want to add a product:");
        JTextField brandNameField = new JTextField(20);
        JLabel productLabel = new JLabel("Enter the name of the new product:");
        JTextField productNameField = new JTextField(20);
        JLabel priceLabel = new JLabel("Enter the price of the new product:");
        JTextField priceField = new JTextField(20);
        JLabel descriptionLabel = new JLabel("Enter the description of the new product:");
        JTextField descriptionField = new JTextField(20);
        JLabel quantityLabel = new JLabel("Enter the number of units in stock:");
        JTextField quantityField = new JTextField(20);
        JLabel inventoryLabel = new JLabel("Enter the inventory level:");
        JTextField inventoryField = new JTextField(20);
        JButton addButton = new JButton("Add Product");

        addButton.addActionListener(e -> {
            String brandName = brandNameField.getText().trim();
            String productName = productNameField.getText().trim();
            String priceStr = priceField.getText().trim();
            String description = descriptionField.getText().trim();
            String quantityStr = quantityField.getText().trim();
            String inventoryStr = inventoryField.getText().trim();

            // Validate input
            if (brandName.isEmpty() || productName.isEmpty() || priceStr.isEmpty() || description.isEmpty() || quantityStr.isEmpty() || inventoryStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double productPrice;
            int quantityInStock;
            int inventoryLevel;

            try {
                productPrice = Double.parseDouble(priceStr);
                quantityInStock = Integer.parseInt(quantityStr);
                inventoryLevel = Integer.parseInt(inventoryStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input format. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Find the selected brand
            Brand selectedBrand = null;
            for (Brand brand : BrandDatabase.getBrands()) {
                if (brand.getName().equalsIgnoreCase(brandName)) {
                    selectedBrand = brand;
                    break;
                }
            }

            if (selectedBrand != null) {
                // Create a new product
                Product newProduct = new Product(productName, productPrice, description, quantityInStock);

                // Add the new product to the selected brand
                selectedBrand.addProduct(newProduct);

                // Show a confirmation message
                JOptionPane.showMessageDialog(null, "New product added to " + selectedBrand.getName() + ": " + productName);

                // Clear input fields
                brandNameField.setText("");
                productNameField.setText("");
                priceField.setText("");
                descriptionField.setText("");
                quantityField.setText("");
                inventoryField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Brand not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(brandLabel, gbc);
        gbc.gridy = 1;
        formPanel.add(brandNameField, gbc);
        gbc.gridy = 2;
        formPanel.add(productLabel, gbc);
        gbc.gridy = 3;
        formPanel.add(productNameField, gbc);
        gbc.gridy = 4;
        formPanel.add(priceLabel, gbc);
        gbc.gridy = 5;
        formPanel.add(priceField, gbc);
        gbc.gridy = 6;
        formPanel.add(descriptionLabel, gbc);
        gbc.gridy = 7;
        formPanel.add(descriptionField, gbc);
        gbc.gridy = 8;
        formPanel.add(quantityLabel, gbc);
        gbc.gridy = 9;
        formPanel.add(quantityField, gbc);
        gbc.gridy = 10;
        formPanel.add(inventoryLabel, gbc);
        gbc.gridy = 11;
        formPanel.add(inventoryField, gbc);
        gbc.gridy = 12;
        formPanel.add(addButton, gbc);

        // Clear the right panel and add the formPanel
        rightPanel.removeAll();
        rightPanel.add(formPanel);
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.revalidate();
        rightPanel.repaint();
    }



    // Run the page
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminOptions::new);
    }

}
