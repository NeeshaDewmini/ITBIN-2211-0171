/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBconnection;
import Model.DBsearch;
import Model.StudentTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author janis
 */
public class StudentController {
   
    public boolean addStudent(String indexNumber, String firstName, String lastName, String degree, String email, String phone) {
        Connection conn = DBconnection.getConnection();
        String sql = "INSERT INTO studentdetails (indexNumber, firstName, lastName, degree, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, indexNumber);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, degree);
            pstmt.setString(5, email);
            pstmt.setString(6, phone);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean checkIfIndexNumberExists(String indexNumber) {
        Connection conn = DBconnection.getConnection();
        String sql = "SELECT COUNT(*) FROM studentdetails WHERE indexNumber = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, indexNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStudent(int indexNumber, String firstName, String lastName, String degree, String email, String phone) {
    Connection conn = DBconnection.getConnection();
    String sql = "UPDATE studentdetails SET firstName = ?, lastName = ?, degree = ?, email = ?, phone = ? WHERE indexNumber = ?";

    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.setString(3, degree);
        pstmt.setString(4, email);
        pstmt.setString(5, phone);
        pstmt.setInt(6, indexNumber);
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0; // Return true if update was successful
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Return false if update failed
    }
}
    
    public boolean deleteStudent(int indexNumber) {
        Connection conn = DBconnection.getConnection();
        String sql = "DELETE FROM studentdetails WHERE indexNumber = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, indexNumber);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<StudentTable> getAllStudents() {
        List<StudentTable> students = new ArrayList<>();
        Connection conn = DBconnection.getConnection();
        String sql = "SELECT * FROM studentdetails";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                StudentTable student = new StudentTable();
                student.setIndexNumber(rs.getString("indexNumber"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setDegree(rs.getString("degree"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    public StudentTable searchStudentByIndex(String indexNumber) {
    Connection conn = DBconnection.getConnection();
    String sql = "SELECT * FROM studentdetails WHERE indexNumber = ?";
    
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, indexNumber);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            StudentTable student = new StudentTable();
            student.setIndexNumber(rs.getString("indexNumber"));
            student.setFirstName(rs.getString("firstName"));
            student.setLastName(rs.getString("lastName"));
            student.setDegree(rs.getString("degree"));
            student.setEmail(rs.getString("email"));
            student.setPhone(rs.getString("phone"));
            return student; // Return the found student
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null; // Return null if no student is found
}
  
}
