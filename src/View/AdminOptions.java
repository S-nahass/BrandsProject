package View;

import Controller.AdminController;
import Model.Brand;

import javax.swing.*;
import java.awt.*;


import static java.awt.BorderLayout.*;

public class AdminOptions extends JFrame {
    public JPanel rightPanel = new JPanel();
    private Brand brandModel;
    AdminController adminController = new AdminController( brandModel,this);



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
                "Exit"
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
        // instantiates the AdminController

        switch (index) {
            case 0:
                // Add Brand - Implement code for adding a brand
                adminController.handleAddBrand();
                break;
            case 1:
                // Edit/Update Brand - Implement code for editing/updating a brand
                adminController.handleEditBrand();
                break;
            case 2:
                // Remove Brand - Implement code for removing a brand
                adminController.handleRemoveBrand();
                break;
            case 3:
                // Add Product to Brand - Implement code for adding a product to a brand
                adminController.handleAddProduct();
                break;
            case 4:
                // Remove Product from Brand - Implement code for removing a product from a brand
                adminController.handleRemoveProduct();
                break;
            case 5:
                // Categorize Brands - Implement code for categorizing brands
                adminController.handleCategorizeBrands();
                break;
            case 6:
                // Manage Inventory - Implement code for managing product inventory
                adminController.handleManageInventory();
                break;
            case 7:
                // Generate Reports - Implement code for generating reports
                adminController.handleGenerateReports();
                break;
            case 8:
                // Monitor User Feedback - Implement code for monitoring user feedback
                adminController.handleMonitorUserFeedback();
                break;
            case 9:
                // Exit to Main Menu - Implement code to return to the main menu
                adminController.handleExitPage();
                break;
            default:
                break;
        }
    }


    // run interface
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminOptions::new);
    }
}


