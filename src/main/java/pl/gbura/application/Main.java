package pl.gbura.application;

import pl.gbura.gui.MainWindow;

import javax.swing.*;

/**
 * Aplikacja SMS
 * Student Manager System
 */
public class Main {

    /**
     * Domyślny konstruktor głównej klasy aplikacji
     */
    public Main(){

    }

    /**
     * Główna metoda rozpoczynająca działanie aplikacji
     *
     * @param args argumenty uruchomieniowe
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainWindow gui = new MainWindow();
            gui.setVisible(true);
        });

    }

}