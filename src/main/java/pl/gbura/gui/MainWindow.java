package pl.gbura.gui;

import pl.gbura.application.DataAdapter;
import pl.gbura.application.impl.DataAdapterImpl;
import pl.gbura.gui.layout.WrapLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Główne okno aplikacji
 */
public class MainWindow extends JFrame {

    /**
     * Pole tekstowe przedstawiające Imię i Nazwisko Studenta
     */
    private final JTextField nameField = new JTextField();

    /**
     * Pole tekstowe przedstawiające Wiek Studenta
     */
    private final JTextField ageField = new JTextField();

    /**
     * Pole tekstowe przedstawiające ocenę studenta
     */
    private final JTextField gradeField = new JTextField();

    /**
     * Pole tekstowe przedstawiające ID studenta
     */
    private final JTextField studentIDField = new JTextField();

    /**
     * Przycisk wywołujący próbę dodania studenta
     */
    private final JButton addButton = new JButton("Add Student");

    /**
     * Przycisk wywołujący próbę usunięcia studenta
     */
    private final JButton removeButton = new JButton("Remove Student");

    /**
     * Przycisk wywołujący próbę aktualizacji studenta
     */
    private final JButton updateButton = new JButton("Update Student");

    /**
     * Przycisk wywołujący wyświetlenie listy wszystkich studentów
     */
    private final JButton displayButton = new JButton("Display All Students");

    /**
     * Przycisk wywołujący wyświetlenie średniej oceny wszystkich studentów
     */
    private final JButton averageButton = new JButton("Calculate Average");

    /**
     * Obszar przedstawiający tekstowy wynik operacji
     */
    private final JTextArea resultArea  = new JTextArea();

    private final DataAdapter dataAdapter = new DataAdapterImpl();

    /**
     * Domyślny konstruktor okna głównego
     */
    public MainWindow() {
        // Set up the frame
        setTitle("Student Management System");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel with vertical BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15)); // Add padding around the entire frame
        setContentPane(mainPanel);

        mainPanel.add(createInputSection());
        mainPanel.add(createActionSection());
        mainPanel.add(createResultSection());

        setLocationRelativeTo(null);
    }

    private JPanel createInputSection() {
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Grade:"));
        inputPanel.add(gradeField);
        inputPanel.add(new JLabel("Student ID:"));
        inputPanel.add(studentIDField);
        return inputPanel;
    }

    private JPanel createActionSection() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new WrapLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(averageButton);
        addActionEventHandlers();
        return buttonPanel;
    }

    private JPanel createResultSection() {
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("Results"));
        //resultArea.setEditable(false);
        resultArea.setWrapStyleWord(true);
        resultArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        resultPanel.add(scrollPane, BorderLayout.CENTER);
        return resultPanel;
    }

    public void addActionEventHandlers(){
        addButton.addActionListener(_ -> addStudent());
        removeButton.addActionListener(_ -> removeStudent());
        updateButton.addActionListener(_ -> updateStudent());
        displayButton.addActionListener(_ -> displayAllStudents());
        averageButton.addActionListener(_ -> calculateAverage());
    }

    /**
     * Metoda używająca danych z pól tekstowych do utworzenia studenta
     */
    private void addStudent() {
        String name = nameField.getText();
        String age = ageField.getText();
        String grade = gradeField.getText();
        String studentID = studentIDField.getText();
        resultArea.setText(dataAdapter.addStudent(name, age, grade, studentID));
    }

    /**
     * Metoda wykonująca próbę usunięcia studenta o ID podanym w polu tekstowym
     */
    private void removeStudent() {
        resultArea.setText(dataAdapter.removeStudent(studentIDField.getText()));
    }

    /**
     * Metoda wykonująca próbę aktualizacji danych studenta
     * za pomocą danych z pól tekstowych
     */
    private void updateStudent() {
        String name = nameField.getText();
        String age = ageField.getText();
        String grade = gradeField.getText();
        String studentID = studentIDField.getText();
        resultArea.setText(dataAdapter.updateStudent(name, age, grade, studentID));
    }

    /**
     * Metoda wywołująca prezentację listy wszystkich studentów
     */
    private void displayAllStudents() {
        resultArea.setText(dataAdapter.displayAllStudents());
    }

    /**
     * Metoda wywyołująca prezentację średniej oceny wszystkich studentów
     */
    private void calculateAverage() {
        resultArea.setText(dataAdapter.calculateAverageGrade());
    }

}
