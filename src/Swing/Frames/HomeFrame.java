package Swing.Frames;
import Src.Brand;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;




public class HomeFrame extends JFrame {
    private static String username;
    private String password;
    private List<Brand> brands;



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
                System.out.println("Brands button clicked");
            }
        });

        favoritesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the Favorites button click
                System.out.println("Favorites button clicked");
            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the Profile button click
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
    public static JPanel createSearchBar(JFrame frame) {
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
                String searchText = searchField.getText();
                String results = performBrandSearch(searchText);
                JTextArea resultsArea = new JTextArea(results, 10, 30);
                resultsArea.setWrapStyleWord(true);
                resultsArea.setLineWrap(true);
                resultsArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(resultsArea);
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.revalidate();
            }
        });

        return searchBar;
    }

    public static String performBrandSearch(String searchText) {

        return "";
    }

}






