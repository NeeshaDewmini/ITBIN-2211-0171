/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AttendanceController;
import Model.AttendanceSection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author janis
 */
public class Attendance extends javax.swing.JFrame {

    /**
     * Creates new form Attendance
     */
    private AttendanceController controller;
    
    public Attendance() {
        
        controller = new AttendanceController(new AttendanceSection());
        initComponents();
        
        populateAttendanceTable();
        
    }
    public void populateAttendanceTable() {
    // Assuming you have a JTable named attendanceTable
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Clear the table first

    // Fetch attendance data
    List<String[]> attendanceList = controller.getAllAttendance();
    
    if (attendanceList != null) {
        for (String[] attendance : attendanceList) {
            model.addRow(attendance);
        }
    } else {
        System.out.println("Attendance list is null");
    }
}
    
    private void clearFields() {
    jTextField1.setText(""); // Clear the text field
    jCheckBox1.setSelected(false); // Uncheck the first checkbox
    jCheckBox2.setSelected(false); // Uncheck the second checkbox
    jRadioButton1.setSelected(false); // Uncheck the first radio button
    jRadioButton2.setSelected(false); // Uncheck the second radio button
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonRemove1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Session");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 100, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Index Number");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 110, 30));

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(102, 102, 102));
        jRadioButton1.setText("Present");
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(102, 102, 102));
        jRadioButton2.setText("Absent");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Attendance Status");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 170, 30));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBox1.setText("Evening Session");
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBox2.setText("Morning Session");
        getContentPane().add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(255, 153, 153)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 263, 310, 40));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Attendance ID", "Index Number", "Session", "Attendance Satus", "Lecturer ID"
            }
        ));
        jTable1.setPreferredSize(new java.awt.Dimension(400, 200));
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 670, 340));

        jButtonAdd.setBackground(new java.awt.Color(255, 153, 153));
        jButtonAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAdd.setText("ADD New");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 120, 40));

        jButtonRemove1.setBackground(new java.awt.Color(255, 153, 153));
        jButtonRemove1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonRemove1.setText("UPDATE");
        jButtonRemove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemove1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRemove1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 110, 40));

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("LOG OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 560, 110, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/attendance management syatem (3).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 724));

        setSize(new java.awt.Dimension(1305, 771));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        String IndexNumber = jTextField1.getText().trim();
    String Session = "";
    
    if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
    Session = "Morning / Evening";
} else if (jCheckBox1.isSelected()) {
    Session = "Evening";
} else if (jCheckBox2.isSelected()) {
    Session = "Morning";
} else {
    JOptionPane.showMessageDialog(this, "Please select a session!", "Error", JOptionPane.ERROR_MESSAGE);
    return; // Exit the method if no session is selected
}

    String Status = "";
    if (jRadioButton1.isSelected()) {
        Status = "Present";
    }else if (jRadioButton2.isSelected()) {
        Status = "Absent";
    } else {
        JOptionPane.showMessageDialog(this, "Please select attendance status!", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method if no status is selected
    }

    boolean success = controller.addAttendance(IndexNumber, Session, Status);
    if (success) {
        JOptionPane.showMessageDialog(this, "Attendance added successfully!");
        // Refresh the table after adding new attendance
        populateAttendanceTable(); 
        clearFields();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to add attendance!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
        
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int rowIndex = jTable1.getSelectedRow(); // Get the selected row index
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    // Check if a row is selected
    if (rowIndex != -1) {
        String IndexNumber = (String) model.getValueAt(rowIndex, 1);
        String Session = (String) model.getValueAt(rowIndex, 2);
        String Status = (String) model.getValueAt(rowIndex, 3);

        jTextField1.setText(IndexNumber);

        if (Session.contains("Morning")) {
            jCheckBox2.setSelected(true);
        } else {
            jCheckBox2.setSelected(false);
        }

        if (Session.contains("Evening")) {
            jCheckBox1.setSelected(true);
        } else {
            jCheckBox1.setSelected(false);
        }

        if ("Present".equals(Status)) {
            jRadioButton1.setSelected(true);
        } else if ("Absent".equals(Status)) {
            jRadioButton2.setSelected(true);
        }
    }
    

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonRemove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemove1ActionPerformed
        // TODO add your handling code here:
        String IndexNumber = jTextField1.getText().trim();
        String Session = "";
        
        if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
            Session = "Morning / Evening";
        } else if (jCheckBox1.isSelected()) {
            Session = "Evening";
        } else if (jCheckBox2.isSelected()) {
            Session = "Morning";
        } else {
            JOptionPane.showMessageDialog(this, "Please select a session!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if no session is selected
        }
        
        String Status = "";
        if (jRadioButton1.isSelected()) {
            Status = "Present";
        } else if (jRadioButton2.isSelected()) {
            Status = "Absent";
        } else {
            JOptionPane.showMessageDialog(this, "Please select attendance status!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if no status is selected
        }
        
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if no row is selected
        }
        
        int attendanceID = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
        
        boolean success = controller.updateAttendance(attendanceID, IndexNumber, Session, Status);
        if (success) {
            JOptionPane.showMessageDialog(this, "Attendance updated successfully!");
            populateAttendanceTable();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update attendance!", "Error", JOptionPane.ERROR_MESSAGE);
        }
                                                

    }//GEN-LAST:event_jButtonRemove1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonRemove1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
