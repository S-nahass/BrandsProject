package Swing.Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private String username; // Store the username
    private String password; // Store the password

    public LoginFrame() {
        // Set up the frame
        setTitle("Clothing Retail App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Set the background color
        getContentPane().setBackground(Color.gray);

        // Create a large title label
        JLabel titleLabel = new JLabel("Welcome to Our Clothing Retail App!");
        titleLabel.setFont(new Font("Forte", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        // Create label for username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Forte", Font.BOLD, 16));
        usernameLabel.setForeground(Color.WHITE);
        // Create a text field for the username
        JTextField usernameField = new JTextField(20);
        usernameField.setFont(new Font("garamond", Font.BOLD, 15));

        // Create labels password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Forte", Font.BOLD, 16));
        passwordLabel.setForeground(Color.WHITE);
        // Create a text field for the password
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("garamond", Font.BOLD, 15));

        // Create a "Login" button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Forte", Font.BOLD, 16));
        loginButton.setForeground(Color.white);
        loginButton.setBackground(Color.darkGray);

        // Add an action listener to the button
        loginButton.addActionListener(e -> {
            // Retrieve the username and password
            // Open the home page
            username = usernameField.getText();
            password = new String(passwordField.getPassword()); // Retrieve the password securely
            openHomePage();
        });

        // Create a panel to organize the components
        JPanel panel = new JPanel();
        panel.setBackground(Color.gray);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        // Add the panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);
    }


    private void openHomePage() {
        SwingUtilities.invokeLater(() -> {
            new HomeFrame(username); // Pass the username to the HomePage constructor
            dispose(); // Close the WelcomePage
        });

    }

}

