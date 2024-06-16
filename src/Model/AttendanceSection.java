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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janis
 */
public class AttendanceSection {
    
    public boolean addAttendance(String IndexNumber, int LecturerID, String Session, String Status) {
        Connection conn = DBconnection.getConnection();
        String sql = "INSERT INTO attendance (IndexNumber, LecturerID, session, Status) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, IndexNumber);
            pstmt.setInt(2, LecturerID);
            pstmt.setString(3, Session);
            pstmt.setString(4, Status);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String[]> getAllAttendance() {
        List<String[]> attendanceList = new ArrayList<>();
        Connection conn = DBconnection.getConnection();
        String sql = "SELECT * FROM attendance";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] attendance = new String[5];
                attendance[0] = String.valueOf(rs.getInt("AttendanceID"));
                attendance[1] = rs.getString("IndexNumber");
                attendance[2] = rs.getString("Session");
                attendance[3] = rs.getString("Status");
                attendance[4] = String.valueOf(rs.getInt("LecturerID"));
                attendanceList.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }

    public boolean checkIfIndexNumberExists(String IndexNumber) {
        Connection conn = DBconnection.getConnection();
        String sql = "SELECT * FROM attendance WHERE IndexNumber = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, IndexNumber);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // If any row is returned, indexNumber exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getLecIDBySession(String Session) {
        Connection conn = DBconnection.getConnection();
        String sql = "SELECT LecturerID FROM lecturers WHERE Session = ?";
        int LecturerID = -1;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Session);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                LecturerID = rs.getInt("LecturerID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return LecturerID;
    }
    
    public boolean updateAttendance(int attendanceID, String IndexNumber, String Session, String Status) {
        Connection conn = DBconnection.getConnection();
        String sql = "UPDATE attendance SET IndexNumber = ?, Session = ?, Status = ? WHERE AttendanceID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, IndexNumber);
            pstmt.setString(2, Session);
            pstmt.setString(3, Status);
            pstmt.setInt(4, attendanceID);

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0; // Return true if at least one row was updated
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

}
