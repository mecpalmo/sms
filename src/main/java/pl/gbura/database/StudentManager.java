package pl.gbura.database;

import pl.gbura.database.model.Student;

import java.util.ArrayList;

public interface StudentManager {

    void addStudent(Student student) throws Exception;

    void removeStudent(String studentID) throws Exception;

    void updateStudent(String studentID, String name, int age, double grade) throws Exception;

    ArrayList<Student> displayAllStudents();

    double calculateAverageGrade();

}
