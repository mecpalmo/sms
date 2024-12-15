package pl.gbura.database.impl;

import pl.gbura.database.model.Student;
import pl.gbura.database.StudentManager;

import java.sql.*;
import java.util.ArrayList;

public class StudentManagerImpl implements StudentManager {

    private final String URL = "jdbc:sqlite:database.db";

    public StudentManagerImpl() {
        initialize();
    }

    @Override
    public void addStudent(Student student) throws Exception {
        String insertSQL = "INSERT INTO STUDENTS (name, age, grade, studentID) VALUES (?, ?, ?, ?);";
        try {
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setDouble(3, student.getGrade());
            pstmt.setString(4, student.getStudentID());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void removeStudent(String studentID) throws Exception {
        String deleteSQL = "DELETE FROM STUDENTS WHERE studentID = ?;";
        try {
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setString(1, studentID);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void updateStudent(String studentID, String newName, int newAge, double newGrade) throws Exception {
        String updateSQL = "UPDATE STUDENTS SET name = ?, age = ?, grade = ? WHERE studentID = ?;";
        try {
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(updateSQL);
            pstmt.setString(1, newName);
            pstmt.setInt(2, newAge);
            pstmt.setDouble(3, newGrade);
            pstmt.setString(4, studentID);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArrayList<Student> displayAllStudents() {
        String selectSQL = "SELECT * FROM STUDENTS;";
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                // Create a Student object for each row
                Student student = new Student(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getDouble("grade"),
                        rs.getString("studentID")
                );
                students.add(student);
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error listing students: " + e.getMessage());
        }
        return students;
    }

    @Override
    public double calculateAverageGrade() {
        String averageGradeSQL = "SELECT AVG(grade) AS averageGrade FROM STUDENTS;";
        try {
            Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(averageGradeSQL);
            if (rs.next()) {
                return rs.getDouble("averageGrade");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0.0; // Return 0.0 if there are no students or an error occurs
    }

    private void initialize(){
        // SQL to create the STUDENTS table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS STUDENTS (" +
                "name TEXT, " +
                "age INTEGER, " +
                "grade REAL, " +
                "studentID TEXT PRIMARY KEY" +
                ");";

        try {
            Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            stmt.execute(createTableSQL);
            System.out.println("Successfully initialized the DB with the 'Students' table");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
