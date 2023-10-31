package Swing.Frames;
import Src.Brand;
import Src.BrandDatabase;
import Src.UserReview;
import Src.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;


public class HomeFrame extends JFrame {
    private static String username;
    private final String password;
    private final List<String> favorites = new ArrayList<>();
    private List<Brand> brands; // Assuming you have a list of Brand objects
    private final List<UserReview> userReviews = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();
    private final List<Product> purchasedProducts = new ArrayList<>(); // A list to track purchased products



    public HomeFrame(String username) {
        HomeFrame.username = username;
        this.password = username;


        // Set up the frame
        setTitle("Clothing Retail App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the frame on the screen
        getContentPane().setBackground(Color.gray); // Set the background color

        // Create a large title label
        JLabel titleLabel = new JLabel("Welcome " + username + "!");
        titleLabel.setFont(new Font("Forte", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // Add the title label to the center of the frame
        add(titleLabel, BorderLayout.CENTER);


        // Create menu
        JPanel bottomMenu = createBottomMenu();
        // Add the bottom menu to the frame
        add(bottomMenu, BorderLayout.SOUTH);

        // Create the search bar using a method
        JPanel searchBar = createSearchBar(this);

        // Create a JTextArea to display search results
        JTextArea resultsArea = new JTextArea(10, 30);
        resultsArea.setWrapStyleWord(true);
        resultsArea.setLineWrap(true);
        resultsArea.setEditable(false);

        // Add the search bar and results area to the frame
        add(searchBar, BorderLayout.NORTH);
        //add(new JScrollPane(resultsArea), BorderLayout.CENTER);

        // Show the frame
        setVisible(true);

    }

    // Method to create the bottom menu
    public JPanel createBottomMenu() {
        JPanel bottomMenu = new JPanel();
        bottomMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10)); // Adjust the layout manager as needed


        // Create buttons for the menu options
        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font("garamond", Font.BOLD, 15));
        homeButton.setBackground(Color.gray);
        homeButton.setForeground(Color.black);

        // Create buttons for the menu options
        JButton brandsButton = new JButton("Brands");
        brandsButton.setFont(new Font("garamond", Font.BOLD, 15));
        brandsButton.setBackground(Color.gray);
        brandsButton.setForeground(Color.black);

        // Create buttons for the menu options
        JButton favoritesButton = new JButton("Favorites");
        favoritesButton.setFont(new Font("garamond", Font.BOLD, 15));
        favoritesButton.setBackground(Color.gray);
        favoritesButton.setForeground(Color.black);

        // Create buttons for the menu options
        JButton profileButton = new JButton("Profile");
        profileButton.setFont(new Font("garamond", Font.BOLD, 15));
        profileButton.setBackground(Color.gray);
        profileButton.setForeground(Color.black);

        // Add ActionListeners to the buttons
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if home button is clicked, redirect to default homeFrame
                SwingUtilities.invokeLater(() -> {
                    new HomeFrame(username); // Pass the username to the HomeFrame constructor
                    dispose();
                });
            }
        });

        brandsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the Brands button click
                // Show List of Brands
                viewAvailableBrands();
                System.out.println("Brands button clicked");
            }
        });

        favoritesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the Favorites button click
                // show favorited brands
                showFavorites();
                System.out.println("Favorites button clicked");
            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the Profile button click
                showProfileOptions();
                System.out.println("Profile button clicked");
            }
        });


        // Add the buttons to the bottom menu
        bottomMenu.add(homeButton);
        bottomMenu.add(brandsButton);
        bottomMenu.add(favoritesButton);
        bottomMenu.add(profileButton);

        return bottomMenu;
    }

    // Method to create the search bar
    public JPanel createSearchBar(JFrame frame) {
        JPanel searchBar = new JPanel();
        searchBar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Create a JTextField for the search field
        JTextField searchField = new JTextField(20);
        searchField.setFont(new Font("garamond", Font.BOLD, 15));
        searchField.setToolTipText("Search Brands");
        searchBar.add(searchField);

        // Create a search button and add an ActionListener
        JButton searchButton = new JButton("Search Brands");
        searchButton.setFont(new Font("garamond", Font.BOLD, 15));
        searchButton.setBackground(Color.gray);
        searchButton.setForeground(Color.black);
        searchBar.add(searchButton);

        // Add ActionListeners to handle the search logic
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                if (searchTerm != null && !searchTerm.isEmpty()) {
                    List<Brand> searchResults = performBrandSearch(searchTerm);
                    showBrandSearchResults(searchResults);
                }
            }
        });

        return searchBar;
    }

    private List<Brand> performBrandSearch(String searchTerm) {
        List<Brand> searchResults = new ArrayList<>();
        BrandDatabase brandDatabase = new BrandDatabase();

        // Simulate a brand search using your existing data
        for (Brand brand : BrandDatabase.getBrands()) {
            if (brand.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(brand);
            }
        }

        if (searchResults.isEmpty()) {
            UIManager.put("OptionPane.messageFont", new Font("garamond", Font.BOLD, 15));
            UIManager.put("OptionPane.messageForeground", Color.black);
            UIManager.put("OptionPane.buttonFont", new Font("garamond", Font.BOLD, 15));
            UIManager.put("OptionPane.buttonForeground", Color.black);
            // No results were found
            JOptionPane.showMessageDialog(null, "No results found", "Search Results", JOptionPane.INFORMATION_MESSAGE);
        }

        return searchResults;
    }

    private void showBrandSearchResults(List<Brand> searchResults) {
        // Remove previous content from the frame
        getContentPane().removeAll();

        // Create a custom table model to hold the search results
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1; // Only the checkbox column is editable
            }
        };
        tableModel.addColumn("Brand Name");
        tableModel.addColumn("Mark Favorite");
        tableModel.addColumn("Category");
        tableModel.addColumn("Country");

        // Add the search results to the table model
        for (Brand brand : searchResults) {
            tableModel.addRow(new Object[]{brand.getName(), false, brand.getCategory(), brand.getCountryOfOrigin()});
        }

        // Create a JTable with the custom table model
        JTable table = new JTable(tableModel);

        // Set table appearance and behavior
        table.setRowHeight(30); // Set the row height
        table.getTableHeader().setFont(new Font("garamond", Font.BOLD, 20)); // Set the header font
        table.setFont(new Font("garamond", Font.PLAIN, 20)); // Set the cell font

        // Create a scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the results panel
        JPanel resultsPanel = new JPanel(new BorderLayout());
        resultsPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the results panel to the frame
        getContentPane().add(resultsPanel, BorderLayout.CENTER);

        // Create menu
        JPanel bottomMenu = createBottomMenu();
        // Add the bottom menu to the frame
        add(bottomMenu, BorderLayout.SOUTH);
        // Create the search bar using a method
        JPanel searchBar = createSearchBar(this);
        add(searchBar, BorderLayout.NORTH);

        revalidate(); // Refresh the UI to show the added results panel

        // Add a checkbox column to the table
        table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Object getCellEditorValue() {
                int selectedRow = table.getSelectedRow();
                String brandName = (String) table.getValueAt(selectedRow, 0);
                Boolean isFavorite = (Boolean) super.getCellEditorValue();
                if (isFavorite) {
                    addToFavorites(brandName);
                } else {
                    removeFromFavorites(brandName);
                }
                return super.getCellEditorValue();
            }
        });

        // Add a listener to the table
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                int selectedColumn = table.getSelectedColumn();
                if (selectedRow >= 0 && selectedColumn == 0) { // Check if the selected column is 0 (first column)
                    String brandName = (String) table.getValueAt(selectedRow, 0);
                    showBrandOptions(brandName);
                }
            }
        });
    }

    private void showProfileOptions() {
        UIManager.put("OptionPane.messageFont", new Font("garamond", Font.BOLD, 15));
        UIManager.put("OptionPane.messageForeground", Color.black);
        UIManager.put("OptionPane.buttonFont", new Font("garamond", Font.BOLD, 15));
        UIManager.put("OptionPane.buttonForeground", Color.black);

        String[] options = {"View Purchases", "Logout"};
        int choice = JOptionPane.showOptionDialog(
                this,
                "Choose an option:",
                "Profile Options",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == 0) {
            // View Purchases option is selected
            viewPurchases(purchasedProducts);

        } else if (choice == 1) {
            // Logout option user and send him back to previous frame
            this.dispose();
            new LoginFrame();
            System.out.println("Logout selected");
        }
    }

    private void viewAvailableBrands() {
        // Remove previous content from the frame

        BrandDatabase brandDatabase = new BrandDatabase();
        List<Brand> availableBrands = BrandDatabase.getBrands(); // Use the instance method

        // Create a custom table model to hold the available brands
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1; // Make only the second column editable
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 1) {
                    return Boolean.class; // Set the class of the second column to Boolean (checkbox)
                }
                return super.getColumnClass(columnIndex);
            }
        };
        tableModel.addColumn("Brand Name(click for details)");
        tableModel.addColumn("Mark Favorite");
        tableModel.addColumn("Category");
        tableModel.addColumn("Country");

        // Add the available brands to the table model
        for (Brand brand : availableBrands) {
            tableModel.addRow(new Object[]{brand.getName(), false, brand.getCategory(), brand.getCountryOfOrigin()});
        }

        // Create a JTable with the custom table model
        JTable table = new JTable(tableModel);

        // Set table appearance and behavior
        table.setRowHeight(30); // Set the row height
        table.getTableHeader().setFont(new Font("garamond", Font.BOLD, 15)); // Set the header font
        table.setFont(new Font("garamond", Font.PLAIN, 20)); // Set the cell font
        table.setBackground(Color.lightGray);

        // Create a scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Remove any existing components in the contentPanel
        getContentPane().removeAll();

        // Create menu
        JPanel bottomMenu = createBottomMenu();
        // Add the bottom menu to the frame
        add(bottomMenu, BorderLayout.SOUTH);
        // Create the search bar using a method
        JPanel searchBar = createSearchBar(this);
        add(searchBar, BorderLayout.NORTH);

        // Add the scrollPane with the table to the contentPanel
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().revalidate();
        getContentPane().repaint();

        // Add a listener to the table
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                int selectedColumn = table.getSelectedColumn();
                if (selectedRow >= 0 && selectedColumn == 0) { // Check if the selected column is 0 (first column)
                    String brandName = (String) table.getValueAt(selectedRow, 0);
                    showBrandOptions(brandName);
                }
            }
        });

        // Add a checkbox column to the table
        table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Object getCellEditorValue() {
                int selectedRow = table.getSelectedRow();
                String brandName = (String) table.getValueAt(selectedRow, 0);
                Boolean isFavorite = (Boolean) super.getCellEditorValue();
                if (isFavorite) {
                    addToFavorites(brandName);
                } else {
                    removeFromFavorites(brandName);
                }
                return super.getCellEditorValue();
            }
        });

    }

    private void addToFavorites(String brandName) {
        if (!favorites.contains(brandName)) {
            favorites.add(brandName);
            System.out.println("Added '" + brandName + "' to favorites.");
        }
    }

    private void removeFromFavorites(String brandName) {
        if (favorites.contains(brandName)) {
            favorites.remove(brandName);
            System.out.println("Removed '" + brandName + "' from favorites.");
        }
    }

    private void showBrandOptions(String brandName) {
        JDialog brandOptionsDialog = createBrandOptionsDialog(brandName);
        JPanel brandOptionsPanel = createBrandOptionsPanel();

        // Create buttons for brand options
        JButton seeBrandDetailsButton = new JButton("See More Brand Details");
        JButton seeProductsButton = new JButton("See Products");
        JButton leaveBrandReviewButton = new JButton("Leave Brand Review");
        JButton seeBrandReviewsButton = new JButton("See Brand Reviews");

        // Set font and background color for buttons
        Font buttonFont = new Font("garamond", Font.BOLD, 15);
        Color buttonColor = new Color(255, 255, 255); // Example color - modify as desired

        seeBrandDetailsButton.setFont(buttonFont);
        seeBrandDetailsButton.setBackground(buttonColor);

        seeProductsButton.setFont(buttonFont);
        seeProductsButton.setBackground(buttonColor);

        leaveBrandReviewButton.setFont(buttonFont);
        leaveBrandReviewButton.setBackground(buttonColor);

        seeBrandReviewsButton.setFont(buttonFont);
        seeBrandReviewsButton.setBackground(buttonColor);

        // Add action listeners to the buttons to handle user interactions
        seeBrandDetailsButton.addActionListener(e -> {
            // Handle "See Brand Details" button click
            String selectedBrandName = brandName;
            viewBrandDetails(selectedBrandName);
        });

        seeProductsButton.addActionListener(e -> {
            // Handle "See Products" button click
            showProducts(brandName);

        });


        leaveBrandReviewButton.addActionListener(e -> {
            // Handle "Leave Brand Review" button click
            String selectedBrandName = brandName;
            leaveBrandReview(selectedBrandName);
        });

        seeBrandReviewsButton.addActionListener(e -> {
            // Handle "See Products" button click
            displayBrandReviews(brandName);

        });


        // Add the buttons to the brand options panel
        brandOptionsPanel.add(seeBrandDetailsButton);
        brandOptionsPanel.add(seeProductsButton);
        brandOptionsPanel.add(leaveBrandReviewButton);
        brandOptionsPanel.add(seeBrandReviewsButton);

        // Add the brand options panel to the brandOptionsDialog's content pane
        brandOptionsDialog.getContentPane().add(brandOptionsPanel);

        // Set frame properties and make it visible
        brandOptionsDialog.setSize(400, 300);
        brandOptionsDialog.setLocationRelativeTo(null);
        brandOptionsDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        brandOptionsDialog.setModal(true); // Set dialog as modal to prevent user interaction
        brandOptionsDialog.setVisible(true);


    }

    private JDialog createBrandOptionsDialog(String brandName) {
        JDialog brandOptionsDialog = new JDialog();
        brandOptionsDialog.setTitle("Brand Options: " + brandName);
        return brandOptionsDialog;
    }

    private JPanel createBrandOptionsPanel() {
        JPanel brandOptionsPanel = new JPanel();
        brandOptionsPanel.setLayout(new GridLayout(0, 1));
        return brandOptionsPanel;
    }

    private void showFavorites() {
        BrandDatabase brandDatabase = new BrandDatabase();
        List<String> favorites = getFavorites(); // Use the instance method

        // Create a custom table model to hold the favorited brands
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells uneditable
            }
        };
        tableModel.addColumn("Favorited Brands");

        // Add the favorited brands to the table model
        for (String brand : favorites) {
            tableModel.addRow(new Object[]{brand});
        }

        // check if the table is empty
        if (tableModel.getRowCount() == 0) {
            tableModel.addRow(new Object[]{"No brands favorited yet."});
        }

        // Create a JTable with the custom table model
        JTable table = new JTable(tableModel);

        // Set table appearance and behavior
        table.setRowHeight(30); // Set the row height
        table.getTableHeader().setFont(new Font("garamond", Font.BOLD, 20)); // Set the header font
        table.setFont(new Font("garamond", Font.PLAIN, 20)); // Set the cell font
        table.setBackground(Color.lightGray);

        // Create a scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a dialog to display the favorites
        JDialog dialog = new JDialog();
        dialog.setTitle("Favorites");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(scrollPane);

        // Set dialog size and visibility
        dialog.pack();
        dialog.setLocationRelativeTo(null); // Center the dialog on the screen
        dialog.setModal(true); // Make the dialog modal

        // Show the dialog
        dialog.setVisible(true);
    }

    private List<String> getFavorites() {
        return favorites;
    }

    private void viewBrandDetails(String brandName) {
        BrandDatabase brandDatabase = new BrandDatabase();
        List<Brand> brands = BrandDatabase.getBrands(); // Use the instance method

        Brand selectedBrand = null;

        // Find the brand with the matching name
        for (Brand brand : brands) {
            if (brand.getName().equals(brandName)) {
                selectedBrand = brand;
                break; // Stop searching once the brand is found
            }
        }

        if (selectedBrand != null) {
            // Create a modal dialog to display brand details
            JDialog brandDetailsDialog = new JDialog((Frame) null, "Brand Details: " + brandName, true);
            brandDetailsDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            // Create a panel to hold brand details
            JPanel brandDetailsPanel = new JPanel();
            brandDetailsPanel.setLayout(new BorderLayout());

            // Create labels to display brand information
            Font labelFont = new Font("Garamond", Font.PLAIN, 20); // Adjust the font and sizing here

            JLabel yearLabel = new JLabel("Year of Origin: " + selectedBrand.getYearFounded());
            yearLabel.setFont(labelFont); // Apply the font to the label

            JLabel historyLabel = new JLabel("Brand History: " + selectedBrand.getBrandHistory());
            historyLabel.setFont(labelFont); // Apply the font to the label

            // Add labels to the brand details panel
            brandDetailsPanel.add(yearLabel, BorderLayout.NORTH);
            brandDetailsPanel.add(historyLabel, BorderLayout.CENTER);

            // Add the brand details panel to the dialog
            brandDetailsDialog.add(brandDetailsPanel);

            // Set dialog properties and make it visible
            brandDetailsDialog.pack();
            brandDetailsDialog.setLocationRelativeTo(null);
            brandDetailsDialog.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Brand not found: " + brandName, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void leaveBrandReview(String brandName) {
        BrandDatabase brandDatabase = new BrandDatabase();
        List<Brand> brands = BrandDatabase.getBrands();

        Brand selectedBrand = null;

        // Find the brand with the matching name
        for (Brand brand : brands) {
            if (brand.getName().equals(brandName)) {
                selectedBrand = brand;
                break; // Stop searching once the brand is found
            }
        }

        if (selectedBrand != null) {

            // Create a dialog to collect review input
            JDialog reviewDialog = new JDialog(this, "Leave a Review for " + brandName, true);
            reviewDialog.setFont(new Font("Garamond", Font.PLAIN, 16));
            reviewDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            reviewDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

            // Create a panel to hold review input components
            JPanel reviewPanel = new JPanel();
            reviewPanel.setBackground(Color.WHITE);
            reviewPanel.setLayout(new GridLayout(0, 1));

            // Create a text area for the user to input their review
            JTextArea reviewTextArea = new JTextArea(5, 30);
            reviewTextArea.setLineWrap(true);
            reviewTextArea.setWrapStyleWord(true);
            reviewTextArea.setFont(new Font("Garamond", Font.PLAIN, 16));
            reviewTextArea.setForeground(Color.BLACK);
            reviewTextArea.setBackground(new Color(210, 203, 203));

            // Create a rating scale using radio buttons
            JPanel ratingPanel = new JPanel();
            ratingPanel.setBackground(Color.WHITE);
            ratingPanel.setLayout(new FlowLayout());

            JLabel ratingLabel = new JLabel("Rating: ");
            ratingLabel.setFont(new Font("Garamond", Font.PLAIN, 16));
            ratingLabel.setForeground(Color.BLACK);
            ratingPanel.add(ratingLabel);

            ButtonGroup ratingGroup = new ButtonGroup();

            for (int i = 1; i <= 5; i++) {
                JRadioButton radioButton = new JRadioButton(String.valueOf(i));
                radioButton.setFont(new Font("Garamond", Font.PLAIN, 16));
                radioButton.setForeground(Color.BLACK);
                radioButton.setBackground(Color.WHITE);
                ratingGroup.add(radioButton);
                ratingPanel.add(radioButton);
            }

            // Create a "Submit" button to submit the review
            JButton submitButton = new JButton("Submit");
            submitButton.setFont(new Font("Garamond", Font.PLAIN, 16));
            submitButton.setForeground(Color.WHITE);
            submitButton.setBackground(Color.darkGray);

            Brand finalSelectedBrand = selectedBrand;
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String userReview = reviewTextArea.getText();
                    int userRating = 0;

                    // Get the selected rating value from the radio buttons
                    for (Enumeration<AbstractButton> buttons = ratingGroup.getElements(); buttons.hasMoreElements(); ) {
                        AbstractButton button = buttons.nextElement();

                        if (button.isSelected()) {
                            userRating = Integer.parseInt(button.getText());
                            break;
                        }
                    }

                    // Create a UserReview object
                    UserReview userReviewSubmitted = new UserReview(username, brandName, userRating, userReview);
                    finalSelectedBrand.addUserReview(userReviewSubmitted);


                    System.out.println("Review submitted: " + userReview);
                    System.out.println("Rating submitted: " + userRating);
                    reviewDialog.dispose();
                }
            });


            // Add components to the review panel
            JLabel reviewLabel = new JLabel("Your Review:");
            reviewLabel.setFont(new Font("Garamond", Font.PLAIN, 16));
            reviewLabel.setForeground(Color.BLACK);

            reviewPanel.add(reviewLabel);
            reviewPanel.add(reviewTextArea);
            reviewPanel.add(ratingPanel);
            reviewPanel.add(submitButton);

            // Add the review panel to the dialog
            reviewDialog.add(reviewPanel);

            // Set dialog properties and make it visible
            reviewDialog.pack();
            reviewDialog.setLocationRelativeTo(null);
            reviewDialog.setVisible(true);

        }

    }

    private void displayBrandReviews(String brandName) {
        BrandDatabase brandDatabase = new BrandDatabase();
        List<Brand> brands = BrandDatabase.getBrands();

        // Find the selected brand
        Brand selectedBrand = null;
        for (Brand brand : brands) {
            if (brand.getName().equals(brandName)) {
                selectedBrand = brand;
                break;
            }
        }

        if (selectedBrand == null) {
            System.out.println("Brand not found.");
            return;
        }

        List<UserReview> userReviews = selectedBrand.getBrandReviews();

        JDialog dialog = new JDialog();
        dialog.setTitle("Brand Reviews");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true); // Set the dialog to be modal
        dialog.setLocationRelativeTo(null); // Center the dialog on the screen

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        Font garamondFont = new Font("Garamond", Font.PLAIN, 16);

        if (userReviews.isEmpty()) {
            JLabel noReviewsLabel = new JLabel("No reviews available for this brand.");
            noReviewsLabel.setFont(garamondFont);
            panel.add(noReviewsLabel);
        } else {
            for (UserReview review : userReviews) {
                JLabel usernameLabel = new JLabel("Username: " + review.getUserName());
                usernameLabel.setFont(garamondFont);
                JLabel ratingLabel = new JLabel("Rating: " + review.getRating());
                ratingLabel.setFont(garamondFont);
                JLabel reviewLabel = new JLabel("Review: " + review.getContent());
                reviewLabel.setFont(garamondFont);
                panel.add(usernameLabel);
                panel.add(ratingLabel);
                panel.add(reviewLabel);
                panel.add(Box.createVerticalStrut(10)); // Add some vertical spacing between each review
                panel.add(new JSeparator(SwingConstants.HORIZONTAL)); // Add a horizontal separator line between reviews
            }
        }

        dialog.getContentPane().add(panel);
        dialog.pack();
        dialog.setVisible(true);
    }


    private List<Product> showProducts(String brandName) {
        BrandDatabase brandDatabase = new BrandDatabase();
        List<Brand> brands = BrandDatabase.getBrands();


        Brand selectedBrand = null;

        // Find the brand with the matching name
        for (Brand brand : brands) {
            if (brand.getName().equals(brandName)) {
                selectedBrand = brand;
                break; // Stop searching once the brand is found
            }
        }

        if (selectedBrand != null) {
            // Create a modal dialog to display the products of the selected brand
            JDialog productsDialog = new JDialog((Frame) null, "Products of " + brandName, true);
            productsDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            // Create a panel to hold the list of products
            JPanel productsPanel = new JPanel();
            productsPanel.setLayout(new BorderLayout());

            // Create a label to prompt the user
            JLabel promptLabel = new JLabel("Select a product and enter the quantity to purchase");

            // Create a list to display the products of the selected brand
            JList<Product> productsList = new JList<>(selectedBrand.getProducts().toArray(new Product[0]));

            // Set a custom renderer for the list to display the product name and price
            productsList.setCellRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                              boolean isSelected, boolean cellHasFocus) {
                    Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if (value instanceof Product product) {
                        setText(product.getName() + " - Price: $" + product.getPrice());
                    }
                    return component;
                }
            });

            // Add a selection listener to the list to handle the purchase action
            productsList.addListSelectionListener(e -> {
                Product selectedProduct = productsList.getSelectedValue();
                if (selectedProduct != null) {
                    String quantityStr = JOptionPane.showInputDialog(productsDialog, "Enter the quantity to purchase:",
                            "Quantity", JOptionPane.PLAIN_MESSAGE);
                    try {
                        int quantity = Integer.parseInt(quantityStr);
                        boolean purchaseSuccessful = selectedProduct.purchase(quantity);
                        if (purchaseSuccessful) {
                            selectedProduct.setQuantity(quantity);
                            purchasedProducts.add(selectedProduct); // Add the purchased product to the list
                            JOptionPane.showMessageDialog(productsDialog, "Purchase successful!",
                                    "Success", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(productsDialog, "Purchase failed. Insufficient inventory.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(productsDialog, "Invalid quantity. Please enter a valid number.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            });

            // Set the preferred size of the list to match the size of the frame
            productsList.setPreferredSize(new Dimension(500, 250));

            productsPanel.add(promptLabel, BorderLayout.NORTH);
            productsPanel.add(new JScrollPane(productsList), BorderLayout.CENTER);

            // Add the products panel to the dialog
            productsDialog.add(productsPanel);

            // Set dialog properties and make it visible
            productsDialog.pack();
            productsDialog.setLocationRelativeTo(null);
            productsDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Brand not found: " + brandName, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return purchasedProducts;
    }


    private void viewPurchases(List<Product> purchasedProducts) {
        // Create a modal dialog to display the user's purchases
        JDialog purchasesDialog = new JDialog((Frame) null, "View Purchases", true);
        purchasesDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Create a panel to hold the list of purchased products
        JPanel purchasesPanel = new JPanel();
        purchasesPanel.setLayout(new BorderLayout());

        // Create a label to prompt the user
        JLabel promptLabel = new JLabel("Your Purchases:");

        // Create a list to display the purchased products
        JList<Product> purchasesList = new JList<>(purchasedProducts.toArray(new Product[0]));

        // Set a custom renderer for the list to display the purchased product name and quantity
        purchasesList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Product product) {
                    setText(product.getName() + " (Quantity: " + product.getQuantity() + ")");
                }
                return component;
            }
        });

        // Set the preferred size of the list to match the size of the frame
        purchasesList.setPreferredSize(new Dimension(500, 250));

        purchasesPanel.add(promptLabel, BorderLayout.NORTH);
        purchasesPanel.add(new JScrollPane(purchasesList), BorderLayout.CENTER);

        // Add the purchases panel to the dialog
        purchasesDialog.add(purchasesPanel);

        // Set dialog properties and make it visible
        purchasesDialog.pack();
        purchasesDialog.setLocationRelativeTo(null);
        purchasesDialog.setVisible(true);
    }



}











