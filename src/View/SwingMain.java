package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingMain {
    UserOptions userOptions;

    public static void main(String[] args) {
        // Create the main window
        JFrame mainFrame = new JFrame("Role Selection");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 200);
        mainFrame.setLayout(new FlowLayout());

        // Set the font to Forte and alignment
        Font font = new Font("Forte", Font.BOLD, 15); // Use "Forte" for the font family
        UIManager.put("OptionPane.messageFont", font);
        UIManager.put("OptionPane.buttonFont", font);

        // Create the buttons
        JButton adminButton = new JButton("Admin");
        JButton userButton = new JButton("User");

        // Add action listeners to the buttons
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the AdminLogin frame
                mainFrame.dispose();
                new AdminLogin();
            }
        });

        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the LoginFrame
                mainFrame.dispose();
                new UserLogin();

            }
        });

        // Set the font for the buttons
        adminButton.setFont(font);
        userButton.setFont(font);

        // Add the buttons to the main window
        mainFrame.add(adminButton);
        mainFrame.add(userButton);

        // Center the main window on the screen
        mainFrame.setLocationRelativeTo(null);

        // Display the main window
        mainFrame.setVisible(true);
    }
}

