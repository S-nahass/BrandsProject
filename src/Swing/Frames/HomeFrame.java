package Swing.Frames;
import Src.Brand;
import Src.BrandDatabase;
import Src.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;


public class HomeFrame extends JFrame {
    private static String username;
    private String password;
    private List<String> favorites = new ArrayList<>();


    public HomeFrame(String username) {
        this.username = username;
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
        // Create a custom table model to hold the search results
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells uneditable
            }
        };
        tableModel.addColumn("Brand Name");

        // Add the search results to the table model
        for (Brand brand : searchResults) {
            tableModel.addRow(new Object[] { brand.getName() });
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
        revalidate(); // Refresh the UI to show the added results panel
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
            // Add code to handle "View Purchases" action
            System.out.println("View Purchases selected");
        } else if (choice == 1) {
            // Logout option user and send him back to previous frame
            this.dispose();
            new LoginFrame();
            System.out.println("Logout selected");
        }
    }

    private void viewAvailableBrands() {
        BrandDatabase brandDatabase = new BrandDatabase();
        List<Brand> availableBrands = brandDatabase.getBrands(); // Use the instance method

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
        tableModel.addColumn("Brand Name");
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
        getContentPane().remove(0);

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
        JButton seeBrandDetailsButton = new JButton("See Brand Details");
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
            System.out.println("See Brand Details clicked");
        });

        seeProductsButton.addActionListener(e -> {
            // Handle "See Products" button click
            System.out.println("See Products clicked");
        });

        markAsFavoriteButton.addActionListener(e -> {
            // Handle "Mark as Favorite" button click
            System.out.println("Mark as Favorite clicked");
        });

        leaveBrandReviewButton.addActionListener(e -> {
            // Handle "Leave Brand Review" button click
            System.out.println("Leave Brand Review clicked");
        });

        seeBrandReviewsButton.addActionListener(e -> {
            // Handle "See Brand Reviews" button click
            System.out.println("See Brand Reviews clicked");
        });

        // Add the buttons to the brand options panel
        brandOptionsPanel.add(seeBrandDetailsButton);
        brandOptionsPanel.add(seeProductsButton);
        brandOptionsPanel.add(markAsFavoriteButton);
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


}






