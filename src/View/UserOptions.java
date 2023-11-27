package View;

import Controller.AdminController;
import Controller.UserController;
import Model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;


public class UserOptions extends JFrame {

    UserController userController;
    String username;

    public UserOptions(String username) {

        this.username = username;
        userController = new UserController(this);

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
                UserController userController = new UserController(UserOptions.this);
                userController.handleHomeButtonClick();


            }
        });

        brandsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the Brands button click
                // Show List of Brands
                userController.handleViewAvailableBrands();

            }
        });

        favoritesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the Favorites button click
                // show favorited brands
                userController.handleViewFavorites();
                System.out.println("Favorites button clicked");
            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the Profile button click
                userController.handleViewProfile();
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
                    List<Brand> searchResults = userController.handleSearch(searchTerm);
                    userController.handleShowBrandSearchResults(searchResults);
                }
            }
        });

        return searchBar;
    }


    public JDialog createBrandOptionsDialog(String brandName) {
        JDialog brandOptionsDialog = new JDialog();
        brandOptionsDialog.setTitle("Brand Options: " + brandName);
        return brandOptionsDialog;
    }

    public JPanel createBrandOptionsPanel() {
        JPanel brandOptionsPanel = new JPanel();
        brandOptionsPanel.setLayout(new GridLayout(0, 1));
        return brandOptionsPanel;
    }


}












