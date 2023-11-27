package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame {
    private String adminUsername; // Store the admin username
    private String adminPassword; // Store the admin password

    public AdminLogin() {
        // Set up the frame
        setTitle("Admin Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Set the background color
        getContentPane().setBackground(Color.gray);

        // Create a large title label
        JLabel titleLabel = new JLabel("Admin Login");
        titleLabel.setFont(new Font("Forte", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        // Create label for admin username
        JLabel adminUsernameLabel = new JLabel("Admin Username:");
        adminUsernameLabel.setFont(new Font("Forte", Font.BOLD, 16));
        adminUsernameLabel.setForeground(Color.WHITE);
        // Create a text field for the admin username
        JTextField adminUsernameField = new JTextField(20);
        adminUsernameField.setFont(new Font("garamond", Font.BOLD, 15));

        // Create labels for admin password
        JLabel adminPasswordLabel = new JLabel("Admin Password:");
        adminPasswordLabel.setFont(new Font("Forte", Font.BOLD, 16));
        adminPasswordLabel.setForeground(Color.WHITE);
        // Create a password field for the admin password
        JPasswordField adminPasswordField = new JPasswordField(20);
        adminPasswordField.setFont(new Font("garamond", Font.BOLD, 15));

        // Create a "Login" button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Forte", Font.BOLD, 16));
        loginButton.setForeground(Color.white);
        loginButton.setBackground(Color.darkGray);

        // Add an action listener to the button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the admin username and password
                adminUsername = adminUsernameField.getText();
                adminPassword = new String(adminPasswordField.getPassword()); // Retrieve the password securely

                // check if fields are empty
                if (adminUsername.isEmpty() || adminPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter admin username and password", "Login Failed", JOptionPane.ERROR_MESSAGE);

                } else {openAdminOptionsFrame();}
            }
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
        panel.add(adminUsernameLabel, gbc);

        gbc.gridx = 1;
        panel.add(adminUsernameField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(adminPasswordLabel, gbc);

        gbc.gridx = 1;
        panel.add(adminPasswordField, gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        // Add the panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);
    }




    private void openAdminOptionsFrame() {
        // Open the AdminOptions frame
        dispose(); // Close the current frame
        new AdminOptions();
    }
}
