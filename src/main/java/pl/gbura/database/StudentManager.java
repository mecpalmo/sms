package pl.gbura.database;

import pl.gbura.database.domain.Student;

import java.util.ArrayList;

/**
 * Menedżer operacji bazodanowych na tabeli Student
 */
public interface StudentManager {

    /**
     * Metoda dodająca obiekt Klasy Student do tabeli Student na bazie danych
     * @param student obiekt opisujący dane studenta
     * @throws Exception w sytuacji błędnej operacji na bazie danych
     */
    void addStudent(Student student) throws Exception;

    /**
     * Metoda usuwająca studenta z tabeli Student
     * @param studentID ID studenta do usunięcia
     * @throws Exception w sytuacji błędnej operacji na bazie danych
     */
    void removeStudent(String studentID) throws Exception;

    /**
     * Metoda aktualizująca dane studenta na tabeli student
     * @param studentID ID studenta do zaktualizowania
     * @param name Imię i nazwisko studenta
     * @param age Wiek studenta
     * @param grade Ocena studenta
     * @throws Exception w sytuacji błędnej operacji na bazie danych
     */
    void updateStudent(String studentID, String name, int age, double grade) throws Exception;

    /**
     * Metoda pobierająca wszystkie rekordy tabeli Student
     * @return Lista obiektów klasy Student
     */
    ArrayList<Student> displayAllStudents();

    /**
     * Metoda obliczająca średnią ocenę wszystkich studentów na tabeli Student
     * @return liczba zmiennoprzecinkowa o wartości średniej oceny studentów
     */
    double calculateAverageGrade();

}
