/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author janis
 */
public class DBsearch {
    
    public static StudentTable searchStudentByIndex(String indexNumber) {
        StudentTable student = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = DBconnection.getConnection();
            String sql = "SELECT * FROM studentdetails WHERE indexNumber = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, indexNumber);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                student = new StudentTable();
                student.setIndexNumber(rs.getString("indexNumber"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setDegree(rs.getString("degree"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return student;
    }
}
