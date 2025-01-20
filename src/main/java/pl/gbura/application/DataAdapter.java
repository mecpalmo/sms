package pl.gbura.application;

/**
 * Adapter danych orach operacji pomiędzy bazą danych a interfejsem użytkownika
 */
public interface DataAdapter {

    /**
     * Metoda dodająca studenta do bazy danych
     *
     * @param name - Imię i nazwisko studenta
     * @param age - Wiek Studenta
     * @param grade - Ocena studenta
     * @param studentID - ID studenta
     * @return wiadomość opisująca rezultat operacji na bazie danych
     */
    String addStudent(String name, String age, String grade, String studentID);

    /**
     * Metoda usuwająca studenta z bazy danych
     *
     * @param studentID - ID studenta do usunięcia
     * @return wiadomość opisująca rezultat operacji na bazie danych
     */
    String removeStudent(String studentID);

    /**
     * Metoda aktualizująca dane studenta na bazie danych
     *
     * @param name - Imię i nazwisko studenta
     * @param age - Wiek studenta
     * @param grade - Ocena Studenta
     * @param studentID - ID studenta do aktualizacji
     * @return wiadomość opisująca rezultat operacji na bazie danych
     */
    String updateStudent(String name, String age, String grade, String studentID);

    /**
     * Metoda zwracająca listę wszystkich studentów z bazy danych
     *
     * @return String zawierający opis wszystkich studentów
     */
    String displayAllStudents();

    /**
     * Metoda obliczająca średnią ocenę wszystkich studentów na bazie danych
     *
     * @return String przedstawiający średnią ocenę wszystkich studentów
     */
    String calculateAverageGrade();
}
