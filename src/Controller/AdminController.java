package Controller;

import Model.Brand;
import Model.Product;
import Model.Report;
import Model.Reviews;
import View.AdminLogin;
import View.AdminOptions;
import Util.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class AdminController {
    // Variables
    private Brand brandModel;
    private final AdminOptions adminView;

    // Constructor
    public AdminController(Brand brandModel, AdminOptions adminView) {
        this.brandModel = brandModel;
        this.adminView = adminView;
    }

    // Methods for handling various functionalities...
    public void handleAddBrand() {
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
                brandModel = new Brand(brandName, brandCategory, yearFounded, countryOfOrigin, "Brand History");
                CSVWriter.writeToCSV("C:/Users/USER/Desktop/BrandsProject/src/Brands.csv", brandModel);

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
        adminView.rightPanel.removeAll();
        adminView.rightPanel.setLayout(new GridBagLayout());
        adminView.rightPanel.add(formPanel);

        adminView.rightPanel.revalidate();
        adminView.rightPanel.repaint();

    }

    // Method to edit a brand
    public void handleEditBrand() {
        // Create a form to enter the brand name
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Enter the name of the brand you want to edit:");
        JTextField nameField = new JTextField(20);
        JButton findButton = new JButton("Find Brand");

        findButton.addActionListener(e -> {
            String brandName = nameField.getText().trim();

            Brand brandToEdit = CSVReader.getBrandFromFile(brandName);

            if (brandToEdit == null) {
                JOptionPane.showMessageDialog(null, "Brand not found.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Clear the right panel
                adminView.rightPanel.removeAll();
                adminView.rightPanel.revalidate();
                adminView.rightPanel.repaint();

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
        adminView.rightPanel.removeAll();
        adminView.rightPanel.setLayout(new GridBagLayout());
        adminView.rightPanel.add(containerPanel);
        adminView.rightPanel.revalidate();
        adminView.rightPanel.repaint();
    }

    // Method to edit a brand
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
                brandToEdit.setCountryOfOrigin(newCountry);
            }

            // Update brand details in the CSV file
            BrandDatabase.updateBrandInCSV(brandToEdit);
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

        gbc.gridy = 1; // Resetting the grid y constraint
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
        editPanel.add(formPanel, BorderLayout.CENTER);

// Remove all components from the right panel
        adminView.rightPanel.removeAll();

// Add the editPanel to the right panel
        adminView.rightPanel.add(editPanel);
        adminView.rightPanel.revalidate();
        adminView.rightPanel.repaint();

    }

    // Method to remove a brand
    public void handleRemoveBrand() {
        // Logic to remove a Brand from the model
        // Update the UI through the BrandView
            // Create a form to enter the brand name for removal
            JPanel formPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);

            JLabel nameLabel = new JLabel("Enter the name of the brand you want to remove:");
            JTextField nameField = new JTextField(20);
            JButton removeButton = new JButton("Remove Brand");

            removeButton.addActionListener(e -> {
                String brandName = nameField.getText().trim();
                Brand brandToRemove = CSVReader.getBrandFromFile(brandName);

                if (brandName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the brand name to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Confirm the removal with the admin
                    int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the brand: " + brandName + "?", "Confirm Removal", JOptionPane.YES_NO_OPTION);

                    if (confirmation == JOptionPane.YES_OPTION) {
                         brandToRemove = null;
                        for (Brand brand : BrandDatabase.getBrands()) {
                            if (brand.getName().equalsIgnoreCase(brandName)) {
                                brandToRemove = brand;
                                break;
                            }
                        }

                        if (brandToRemove == null) {
                            JOptionPane.showMessageDialog(null, "Brand not found.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            BrandDatabase.removeBrandFromCSV(brandToRemove);
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
            adminView.rightPanel.removeAll();
            adminView.rightPanel.add(formPanel);
            adminView.rightPanel.setLayout(new GridBagLayout());
            adminView.rightPanel.revalidate();
            adminView.rightPanel.repaint();
    }

    // Method to add a product
    public void handleAddProduct() {
        // Logic to add a Product to a Brand in the model
        // Update the UI through the BrandView
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

        JLabel inventoryLabel = new JLabel("Enter the inventory level:");
        JTextField inventoryField = new JTextField(20);
        JButton addButton = new JButton("Add Product");

        addButton.addActionListener(e -> {
            String brandName = brandNameField.getText().trim();
            String productName = productNameField.getText().trim();
            String priceStr = priceField.getText().trim();
            String description = descriptionField.getText().trim();
            String inventoryStr = inventoryField.getText().trim();

            // Validate input
            if (brandName.isEmpty() || productName.isEmpty() || priceStr.isEmpty() || description.isEmpty() || inventoryStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double productPrice;
            int inventoryLevel;

            try {
                productPrice = Double.parseDouble(priceStr);
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


            // assign random score between 0-100
            int popularityScore = new Random().nextInt(100);

            if (selectedBrand != null) {
                // Create a new product
                Product newProduct = new Product(brandName, productName, productPrice, description, inventoryLevel, popularityScore);
                // Add the new product to the selected brand
                BrandDatabase.addProductToCSV(newProduct);

                // Show a confirmation message
                JOptionPane.showMessageDialog(null, "New product added to " + selectedBrand.getName() + ": " + productName);

                // Clear input fields
                brandNameField.setText("");
                productNameField.setText("");
                priceField.setText("");
                descriptionField.setText("");
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
        formPanel.add(inventoryLabel, gbc);
        gbc.gridy = 9;
        formPanel.add(inventoryField, gbc);
        gbc.gridy = 10;
        formPanel.add(addButton, gbc);

        // Clear the right panel and add the formPanel
        adminView.rightPanel.removeAll();
        adminView.rightPanel.add(formPanel);
        adminView.rightPanel.setLayout(new GridBagLayout());
        adminView.rightPanel.revalidate();
        adminView.rightPanel.repaint();

    }

    // Logic to remove a Product from a Brand in the model
    public void handleRemoveProduct() {
        // Logic to remove a Product from a Brand in the model
        // Update the UI through the BrandView
        // Create a form to enter brand details for listing products
        JPanel brandFormPanel = new JPanel(new GridBagLayout());
        GridBagConstraints brandGBC = new GridBagConstraints();
        brandGBC.insets = new Insets(5, 5, 5, 5);

        JLabel brandLabel = new JLabel("Enter the name of the brand to view its products:");
        JTextField brandNameField = new JTextField(20);
        JButton viewProductsButton = new JButton("View Products");

        brandFormPanel.add(brandLabel, brandGBC);
        brandGBC.gridy = 1;
        brandFormPanel.add(brandNameField, brandGBC);
        brandGBC.gridy = 2;
        brandFormPanel.add(viewProductsButton, brandGBC);

        // Create a form to enter product details for removal
        JPanel productFormPanel = new JPanel(new GridBagLayout());
        GridBagConstraints productGBC = new GridBagConstraints();
        productGBC.insets = new Insets(5, 5, 5, 5);

        // Set initial visibility of product form
        productFormPanel.setVisible(false);

        viewProductsButton.addActionListener(e -> {
            productFormPanel.removeAll();
            String brandName = brandNameField.getText().trim();

            // Validate input
            if (brandName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in the brand name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Find the selected brand
            Brand selectedBrand = BrandDatabase.getBrands().stream()
                    .filter(brand -> brand.getName().equalsIgnoreCase(brandName))
                    .findFirst()
                    .orElse(null);

            if (selectedBrand != null) {

                // Create a list of products
                DefaultListModel<String> productList = new DefaultListModel<>();
                List<Product> products = CSVReader.getProductsByBrand(selectedBrand.getName(),"C:/Users/USER/Desktop/BrandsProject/src/Products.csv" );

                for (Product product : products) {
                    productList.addElement(product.getName()); // or any other property you want to display
                }


                // Create a JList to display products
                JList<String> productListDisplay = new JList<>(productList);
                JScrollPane productListScrollPane = new JScrollPane(productListDisplay);

                // Add the JList to the productFormPanel
                productFormPanel.add(productListScrollPane);

                // Display the products of the selected brand
                productFormPanel.setVisible(true);
                adminView.rightPanel.revalidate();
                adminView.rightPanel.repaint();

                // Get the selected product for removal
                productListDisplay.addListSelectionListener(listSelectionEvent -> {
                    if (!listSelectionEvent.getValueIsAdjusting()) {
                        String selectedProduct = productListDisplay.getSelectedValue();
                        if (selectedProduct != null) {
                            JButton removeButton = new JButton("Remove Product");

                            removeButton.addActionListener(removeEvent -> {
                                if (selectedProduct.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Please select a product to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }

                                // Find the selected product
                                Product productToRemove = null;
                                for (Product product : products) {
                                    if (product.getName().equalsIgnoreCase(selectedProduct)) {
                                        productToRemove = product;
                                        break;
                                    }
                                }


                                if (productToRemove != null) {
                                    // Confirm product removal
                                    int confirmDialogResult = JOptionPane.showConfirmDialog(null,
                                            "Are you sure you want to remove the product: " + selectedProduct + " from " + selectedBrand.getName() + "?",
                                            "Confirm Removal", JOptionPane.YES_NO_OPTION);
                                    if (confirmDialogResult == JOptionPane.YES_OPTION) {
                                        BrandDatabase.removeProductFromCSV(productToRemove);
                                        JOptionPane.showMessageDialog(null, "Product removed successfully.");

                                        // After removing the product, refresh the product list
                                        productList.removeElement(selectedProduct);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Product not found in the selected brand.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            });

                            // Clear the productNameField text for a clean user experience
                            brandNameField.setText("");

                            // Add the "Remove Product" button
                            productFormPanel.add(removeButton);
                            productFormPanel.revalidate();
                            productFormPanel.repaint();
                        }
                    }
                });
            } else {
                JOptionPane.showMessageDialog(null, "Brand not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add brand and product form panels to the right panel
        adminView.rightPanel.removeAll();
        adminView.rightPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        adminView.rightPanel.add(brandFormPanel, gbc);

        gbc.gridy = 1;
        adminView.rightPanel.add(productFormPanel, gbc);
        adminView.rightPanel.revalidate();
        adminView.rightPanel.repaint();
    }

    // Categorize brands
    public void handleCategorizeBrands() {
        // Logic to categorize Brands
        // Update the UI through the BrandView
        // Create a form to enter brand details for categorization
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel brandLabel = new JLabel("Enter the name of the brand to categorize:");
        JTextField brandNameField = new JTextField(20);

        JLabel categoryLabel = new JLabel("Enter the new category for the brand:");
        JTextField categoryField = new JTextField(20);

        JButton categorizeButton = new JButton("Categorize Brand");

        categorizeButton.addActionListener(e -> {
            String brandName = brandNameField.getText().trim();
            String newCategory = categoryField.getText().trim();

            // Validate input
            if (brandName.isEmpty() || newCategory.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
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
                // Set the new category for the brand
                selectedBrand.setCategory(newCategory);
                BrandDatabase.updateBrandInCSV(selectedBrand);
                JOptionPane.showMessageDialog(null, "Brand categorized successfully.");
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
        formPanel.add(categoryLabel, gbc);
        gbc.gridy = 3;
        formPanel.add(categoryField, gbc);
        gbc.gridy = 4;
        formPanel.add(categorizeButton, gbc);

        // Clear the right panel and add the formPanel
        adminView.rightPanel.removeAll();
        adminView.rightPanel.setLayout(new GridBagLayout());
        adminView.rightPanel.add(formPanel);
        adminView.rightPanel.revalidate();
        adminView.rightPanel.repaint();
    }

    // Manage Inventory
    public void handleManageInventory() {
        // Logic to generate reports
        // Update the UI through the BrandView
        // Create a form to enter the brand name
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel brandLabel = new JLabel("Enter the name of the brand:");
        JTextField brandNameField = new JTextField(20);
        JButton findBrandButton = new JButton("Find Brand");

        findBrandButton.addActionListener(e -> {
            String brandName = brandNameField.getText().trim();

            Brand selectedBrand = CSVReader.getBrandFromFile(brandName);
            // Find the selected brand


            // Create a list of products

            if (selectedBrand != null) {
                // Create a list of products
                DefaultListModel<String> productList = new DefaultListModel<>();
                List<Product> products = CSVReader.getProductsByBrand(selectedBrand.getName(),"C:/Users/USER/Desktop/BrandsProject/src/Products.csv" );

                for (Product product : products) {
                    productList.addElement(product.getName()); // or any other property you want to display

                }

                JList<String> productListDisplay = new JList<>(productList);
                JScrollPane productListScrollPane = new JScrollPane(productListDisplay);

                // Create a panel to display products
                JPanel productPanel = new JPanel(new BorderLayout());
                productPanel.add(productListScrollPane, BorderLayout.CENTER);

                // Create an "Update Inventory" button
                JButton updateInventoryButton = new JButton("Update Inventory");
                productPanel.add(updateInventoryButton, BorderLayout.SOUTH);

                // Display the products of the selected brand
                productPanel.setVisible(true);

                updateInventoryButton.addActionListener(updateEvent -> {
                    String selectedProduct = productListDisplay.getSelectedValue();
                    if (selectedProduct != null) {
                        int productChoice = productListDisplay.getSelectedIndex();
                        if (productChoice >= 0 && productChoice < products.size()) {
                            Product productToUpdate = products.get(productChoice);
                            int currentInventoryLevel = productToUpdate.getInventoryLevel();

                            String input = JOptionPane.showInputDialog(null,
                                    "Current inventory level of " + selectedProduct + ": " + currentInventoryLevel + "\n"
                                            + "Enter the new inventory level:");

                            if (input != null) {
                                try {
                                    int newInventoryLevel = Integer.parseInt(input);
                                    if (newInventoryLevel >= 0) {
                                        productToUpdate.setInventoryLevel(newInventoryLevel);
                                        JOptionPane.showMessageDialog(null,
                                                selectedProduct + " inventory level has been updated to " + newInventoryLevel);
                                        BrandDatabase.updateProductInCSV(productToUpdate);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Inventory level must be a non-negative integer.",
                                                "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.",
                                            "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }
                });
                // Clear the right panel and add the productPanel
                adminView.rightPanel.removeAll();
                adminView.rightPanel.setLayout(new BorderLayout());
                adminView.rightPanel.add(productPanel, BorderLayout.CENTER);
                adminView.rightPanel.revalidate();
                adminView.rightPanel.repaint();
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
        formPanel.add(findBrandButton, gbc);

        // Clear the right panel and add the formPanel
        adminView.rightPanel.removeAll();
        adminView.rightPanel.setLayout(new GridBagLayout());
        adminView.rightPanel.add(formPanel);
        adminView.rightPanel.revalidate();
        adminView.rightPanel.repaint();
    }

    // Performance
    public void handleGenerateReports() {

        // Create a form to enter the brand name for performance check
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel brandLabel = new JLabel("Enter the name of the brand to check its performance:");
        JTextField brandNameField = new JTextField(20);
        JButton checkPerformanceButton = new JButton("Check Performance");

        checkPerformanceButton.addActionListener(e -> {
            String brandName = brandNameField.getText().trim();

            // Find the selected brand
            Brand selectedBrand = CSVReader.getBrandFromFile(brandName);

            if (selectedBrand != null) {
                // Create a panel to display performance data
                JPanel performancePanel = new JPanel(new GridBagLayout());

                // Display brand performance data
                List<Report> performanceDataList = BrandDatabase.getReports();

                for (Report performanceData : performanceDataList) {
                    if (performanceData.getBrandName().equalsIgnoreCase(selectedBrand.getName())) {
                        JLabel brandNameLabel = new JLabel("Brand: " + performanceData.getBrandName());
                        performancePanel.add(brandNameLabel, gbc);
                        gbc.gridy++; // Move to the next row

                        // Display sales records
                        JLabel yearLabel = new JLabel("Year: " + performanceData.getYear());
                        performancePanel.add(yearLabel, gbc);
                        gbc.gridy++; // Move to the next row

                        JLabel quantitySoldLabel = new JLabel("Quantity Sold: " + performanceData.getQuantitySold());
                        performancePanel.add(quantitySoldLabel, gbc);
                        gbc.gridy++; // Move to the next row

                        JLabel totalRevenueLabel = new JLabel("Total Revenue: " + performanceData.getRevenue());
                        performancePanel.add(totalRevenueLabel, gbc);
                        gbc.gridy++; // Move to the next row

                        // Display product popularity
                        JLabel productNameLabel = new JLabel("Product Name: " + performanceData.getProductName());
                        performancePanel.add(productNameLabel, gbc);
                        gbc.gridy++; // Move to the next row

                        JLabel popularityScoreLabel = new JLabel("Popularity Score: " + performanceData.getProductPopularity());
                        performancePanel.add(popularityScoreLabel, gbc);
                        gbc.gridy++; // Move to the next row
                    }
                }

                // Clear the right panel and add the performancePanel
                adminView.rightPanel.removeAll();
                adminView.rightPanel.setLayout(new GridBagLayout());
                adminView.rightPanel.add(performancePanel, gbc);
                adminView.rightPanel.revalidate();
                adminView.rightPanel.repaint();
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
        formPanel.add(checkPerformanceButton, gbc);

        // Clear the right panel and add the formPanel
        adminView.rightPanel.removeAll();
        adminView.rightPanel.setLayout(new GridBagLayout());
        adminView.rightPanel.add(formPanel, gbc);
        adminView.rightPanel.revalidate();
        adminView.rightPanel.repaint();

    }

    // Monitor
    public void handleMonitorUserFeedback() {
        // Logic to monitor user feedback
        // Update the UI through the BrandView
        // Create a form panel to search for a brand
        JPanel searchBrandPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel searchLabel = new JLabel("Enter the name of the brand:");
        JTextField brandNameField = new JTextField(20);
        JButton searchButton = new JButton("Search Brand");

        searchBrandPanel.add(searchLabel, gbc);
        gbc.gridy = 1;
        searchBrandPanel.add(brandNameField, gbc);
        gbc.gridy = 2;
        searchBrandPanel.add(searchButton, gbc);

        // Create a panel to display the brand's reviews
        JPanel reviewsPanel = new JPanel();
        reviewsPanel.setLayout(new BoxLayout(reviewsPanel, BoxLayout.Y_AXIS));

        searchButton.addActionListener(e -> {
            String brandName = brandNameField.getText().trim();

            // Find the selected brand
            Brand selectedBrand = CSVReader.getBrandFromFile(brandName);

            if (selectedBrand != null) {
                // Clear the reviews panel and display the reviews
                reviewsPanel.removeAll();

                List<Reviews> brandReviews = BrandDatabase.getReviews();

                if (brandReviews.isEmpty()) {
                    reviewsPanel.add(new JLabel("No reviews available for " + selectedBrand.getName()));
                } else {
                    reviewsPanel.add(new JLabel("Reviews for " + selectedBrand.getName() + ":"));
                    for (Reviews review : brandReviews) {
                        if (review.getBrandName().equalsIgnoreCase(selectedBrand.getName())) {
                            reviewsPanel.add(new JLabel("Username: " + review.getUserName()));
                            reviewsPanel.add(new JLabel("Rating: " + review.getRating() + " stars"));
                            reviewsPanel.add(new JLabel("Review Text: " + review.getComment()));
                            reviewsPanel.add(new JLabel()); // Add some space between reviews
                        }
                    }
                }

                // Refresh the reviews panel
                reviewsPanel.revalidate();
                reviewsPanel.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Brand not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Clear the right panel and add the searchBrandPanel and reviewsPanel
        adminView.rightPanel.removeAll();
        adminView.rightPanel.setLayout(new BoxLayout(adminView.rightPanel, BoxLayout.Y_AXIS));
        adminView.rightPanel.add(searchBrandPanel);
        adminView.rightPanel.add(reviewsPanel);
        adminView.rightPanel.revalidate();
        adminView.rightPanel.repaint();
    }

    // Exit
    public void handleExitPage () {
        adminView.dispose();
        new AdminLogin();

    }


}
