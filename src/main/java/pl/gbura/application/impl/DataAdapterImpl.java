package pl.gbura.application.impl;

import pl.gbura.application.DataAdapter;
import pl.gbura.database.StudentManager;
import pl.gbura.database.domain.Student;
import pl.gbura.database.impl.StudentManagerImpl;

import java.util.ArrayList;

public class DataAdapterImpl implements DataAdapter {

    private final StudentManager studentManager = new StudentManagerImpl();

    @Override
    public String addStudent(String name, String age, String grade, String studentID) {
        if(!isIdValid(studentID)){
            return "Niepoprawne studentID";
        }
        if(!isAgeValid(age)){
            return "Niepoprawna wartość wieku";
        }
        if(!isGradeValid(grade)){
            return "Niepoprawna wartość oceny";
        }
        Student student = new Student(
                name,
                Integer.parseInt(age),
                Double.parseDouble(grade),
                studentID
        );
        try {
            studentManager.addStudent(student);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Student added successfully!";
    }

    @Override
    public String removeStudent(String studentID) {
        try {
            studentManager.removeStudent(studentID);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Student removed successfully!";
    }

    @Override
    public String updateStudent(String name, String age, String grade, String studentID) {
        if(!isAgeValid(age)){
            return "Niepoprawna wartość wieku";
        }
        if(!isGradeValid(grade)){
            return "Niepoprawna wartość oceny";
        }
        try {
            studentManager.updateStudent(
                    studentID,
                    name,
                    Integer.parseInt(age),
                    Double.parseDouble(grade)
            );
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Student updated successfully!";
    }

    @Override
    public String displayAllStudents() {
        ArrayList<Student> students = studentManager.displayAllStudents();
        StringBuilder result = new StringBuilder("Student List:\n");
        for (Student student : students) {
            result.append(student.displayInfo()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String calculateAverageGrade() {
        double average = studentManager.calculateAverageGrade();
        return String.format("Average Grade: %.2f", average);
    }

    private boolean isIdValid(String studentID){
        return !studentID.isBlank();
    }

    private boolean isAgeValid(String age){
        int ageValue;
        try{
            ageValue = Integer.parseInt(age);
        }catch (Exception e){
            return false;
        }
        return ageValue > 0;
    }

    private boolean isGradeValid(String grade){
        double gradeValue;
        try{
            gradeValue = Double.parseDouble(grade);
        }catch (Exception e){
            return false;
        }
        return gradeValue >= 0.0 && gradeValue <= 100.0;
    }

}
