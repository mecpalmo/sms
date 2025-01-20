package pl.gbura.database.domain;

/**
 * Reprezentacja rekordu tabeli student
 */
public class Student {

    /**
     * Imie i Nazwisko
     */
    private String name;

    /**
     * Wiek
     */
    private int age;

    /**
     * Ocena
     */
    private double grade;

    /**
     * Unikalny identyfikator
     */
    private String studentID;

    public Student(){

    }

    public Student(String name, int age, double grade, String studentID) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

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
