/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author janis
 */
public class StudentSection {
    
    public void addStudent(int indexNumber, String firstName, String lastName, String degree, String email, String phone) {
        String sql = "INSERT INTO studentdetails (indexNumber, firstName, lastName, degree, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, indexNumber);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, degree);
            pstmt.setString(5, email);
            pstmt.setString(6, phone);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateStudent(int indexNumber, String firstName, String lastName, String degree, String email, String phone) {
        Connection conn = DBconnection.getConnection();
        String sql = "UPDATE students SET first_name = ?, last_name = ?, degree = ?, email = ?, phone = ? WHERE index_number = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, degree);
            pstmt.setString(4, email);
            pstmt.setString(5, phone);
            pstmt.setInt(6, indexNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean deleteStudent(int indexNumber) {
        Connection conn = DBconnection.getConnection();
        String sql = "DELETE FROM studentdetails WHERE indexNumber = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, indexNumber);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // If rowsAffected is more than 0, deletion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
