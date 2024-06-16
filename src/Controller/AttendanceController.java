/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AttendanceSection;
import java.util.List;

/**
 *
 * @author janis
 */
public class AttendanceController {
    
    private AttendanceSection model;
    

    public AttendanceController(AttendanceSection model) {
        this.model = model;
        
    }

    public boolean addAttendance(String IndexNumber, String Session, String Status) {
        int LecturerID = model.getLecIDBySession(Session); // Get lecturer ID based on session
        System.out.println("Session: " + Session + ", LecturerID: " + LecturerID);
        if (LecturerID == -1) {
            // Handle case where no lecturer ID is found for the session
            System.out.println("No LecturerID found for session: " + Session);
            return false;
        }
        return model.addAttendance(IndexNumber, LecturerID, Session, Status);
    }

    public List<String[]> getAllAttendance() {
        return model.getAllAttendance();
    }

    public boolean checkIfIndexNumberExists(String IndexNumber) {
        return model.checkIfIndexNumberExists(IndexNumber);
    }

    public int getLecIDBySession(String Session) {
        return model.getLecIDBySession(Session);
    }
    
    public boolean updateAttendance(int attendanceID, String IndexNumber, String Session, String Status) {
        int LecturerID = model.getLecIDBySession(Session); // Get lecturer ID based on session
        
        if (LecturerID == -1) {
            // Handle case where no lecturer ID is found for the session
            System.out.println("No LecturerID found for session: " + Session);
            return false;
        }
        
        boolean success = model.updateAttendance(attendanceID, IndexNumber, Session, Status);
        
        if (success) {
            return true;
        } else {
            return false;
        }
    }
}
    