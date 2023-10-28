package Swing;

import Swing.Frames.LoginFrame;

import javax.swing.*;

public class SwingMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
        });
    }
}
