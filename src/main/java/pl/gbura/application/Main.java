package pl.gbura.application;

import pl.gbura.gui.MainWindow;

import javax.swing.*;

/**
 * Główna Klasa aplikacji
 */
public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainWindow gui = new MainWindow();
            gui.setVisible(true);
        });

    }

}