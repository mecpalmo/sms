package pl.gbura.application;

public interface DataAdapter {

    String addStudent(String name, String age, String grade, String studentID);

    String removeStudent(String studentID);

    String updateStudent(String name, String age, String grade, String studentID);

    String displayAllStudents();

    String calculateAverageGrade();
}
