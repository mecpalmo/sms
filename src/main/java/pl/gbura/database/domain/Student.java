package pl.gbura.database.domain;

/**
 * Reprezentacja rekordu tabeli student
 */
public class Student {

    private String name;
    private int age;
    private double grade;
    private String studentID;

    /**
     * Domyślny konstruktor klasy Student
     */
    public Student(){

    }

    /**
     * Konstruktor klasy student
     *
     * @param name Imie i nazwisko student
     * @param age Wiek studenta
     * @param grade Ocena studenta
     * @param studentID ID studenta
     */
    public Student(String name, int age, double grade, String studentID) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.studentID = studentID;
    }

    /**
     * Metoda zwracająca imię i nazwisko studenta
     *
     * @return imie i nazwisko studenta
     */
    public String getName() {
        return name;
    }

    /**
     * Metoda ustawiająca imię i nazwisko studenta z parametru
     *
     * @param name imię i nazwisko studenta
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metoda zwracająca wiek studenta
     *
     * @return wiek studenta
     */
    public int getAge() {
        return age;
    }

    /**
     * Metoda ustawiająca wiek studenta z parametru
     *
     * @param age wiek studenta
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Metoda zwracająca ocenę studenta
     *
     * @return ocena studenta
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Metoda ustawiająca ocenę studenta z parametru
     *
     * @param grade ocena studenta
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    /**
     * Metoda zwracająca id studenta
     *
     * @return unikalny indentyfikator studenta
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Metoda ustawiająca id studenta z parametru
     *
     * @param studentID id studenta
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Metoda zwracająca tekstowy opis obiektu Student
     *
     * @return opis obiektu student
     */
    public String displayInfo() {
        return "StudentID: " + studentID +
                ", name: " + name +
                ", age: " + age +
                ", grade: " + grade;
    }
}
