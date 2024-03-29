/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package student;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Course;
import model.Transcript;
import model.User;
import model.UserToCourse;
import model.Utils;

/**
 *
 * @author Dell
 */
public class ApplyForTranscript extends javax.swing.JPanel {

    /**
     * Creates new form ApplyForTranscript
     */
    Utils utils;
    JPanel mainPanel;
    User user;
    ArrayList<UserToCourse> courses;
    
    public ApplyForTranscript(JPanel mainPanel, Utils utils, User user) {
        initComponents();
        this.mainPanel = mainPanel;
        this.utils = utils;
        this.user = user;
        
        PopulateTable();
        
        if(checkEligibility()){
           btnViewTranscript.setEnabled(true);
           lblMessage.setVisible(false);
           btnApply.setEnabled(true);
        }else{
            btnViewTranscript.setEnabled(false);
            lblMessage.setVisible(true);
            btnApply.setEnabled(false);
        }
    }
    
    public void PopulateTable(){
        DefaultTableModel tbl = (DefaultTableModel) tblCourses.getModel();
        tbl.setRowCount(0);
        courses = utils.getCoursesByStudentId(user.getId());

        for(Course c : utils.getCoursesByCourseId(courses)){
            Object[] row = new Object[5];
            row[0] = c;
            row[1] = c.getName();
            row[2] = c.getProfName();
            row[3] = c.getTerm();
            row[4] = c.getCredits();
            tbl.addRow(row);
        }
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
        courseInfoPanel = new javax.swing.JPanel();
        lblCourseInfo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCourses = new javax.swing.JTable();
        btnViewTranscript = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        btnApply = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(73, 77, 94));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 234, 234));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Apply For Transcript");

        courseInfoPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));

        lblCourseInfo.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        lblCourseInfo.setText("Course Taken:");

        tblCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Course Name", "Professor Name", "Term", "Credits"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCourses);

        javax.swing.GroupLayout courseInfoPanelLayout = new javax.swing.GroupLayout(courseInfoPanel);
        courseInfoPanel.setLayout(courseInfoPanelLayout);
        courseInfoPanelLayout.setHorizontalGroup(
            courseInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courseInfoPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(courseInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCourseInfo)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        courseInfoPanelLayout.setVerticalGroup(
            courseInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courseInfoPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblCourseInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnViewTranscript.setBackground(new java.awt.Color(73, 77, 94));
        btnViewTranscript.setText("View Transcript");
        btnViewTranscript.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewTranscript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTranscriptActionPerformed(evt);
            }
        });

        lblMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(239, 234, 234));
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessage.setText("<html> You are not eligible to apply for a transcript<br> Requirements - <strong>You need to complete atleast 8 courses</strong>  <i>(Contact Professor to mark course as completed)</i> </html> ");
        lblMessage.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnApply.setBackground(new java.awt.Color(73, 77, 94));
        btnApply.setText("Apply For Transcript");
        btnApply.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(73, 77, 94));
        jButton1.setForeground(new java.awt.Color(239, 234, 234));
        jButton1.setText("< Back");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 67, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(courseInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnViewTranscript, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(276, 276, 276))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(courseInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewTranscript, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewTranscriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTranscriptActionPerformed

        if(isTranscriptApproved() == null){
            JOptionPane.showMessageDialog(this, "Please Apply for Transcript");
        }
        else if(isTranscriptApproved().equals("UnderReview")){
            JOptionPane.showMessageDialog(this, "Your Transcript is Under Review");
        }
        else if(isTranscriptApproved().equals("Rejected")){
            JOptionPane.showMessageDialog(this, "Your Transcript is Rejected");
        }
        else{
            TranscriptPanel panel = new TranscriptPanel(mainPanel, user, utils);
            mainPanel.add("TranscriptPanel",panel);
            CardLayout layout = (CardLayout) mainPanel.getLayout();
            layout.next(mainPanel); 
        }
                
        
    }//GEN-LAST:event_btnViewTranscriptActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        
        //Check if applied for transcript
        if(isAppliedForTranscript()){
            JOptionPane.showMessageDialog(this, "You have already applied for a Transcript");
            return;
        }
        
        Transcript t = new Transcript();
        t.setStudentId(user.getId());
        t.setStudentName(user.getName());
        t.setStatus("UnderReview");
        if(utils.createTranscriptApplication(t)){
            JOptionPane.showMessageDialog(this, "Applied for transcript successfully");
        }else{
            JOptionPane.showMessageDialog(this, "Error while applying for transncript");
        }
    }//GEN-LAST:event_btnApplyActionPerformed

    private boolean isAppliedForTranscript(){
        for(Transcript t: utils.getTranscripts()){
            if(t.getStudentId() == user.getId()){
                return true;
            }
        }
        return false;
    }
    
    private String isTranscriptApproved(){
        for(Transcript t: utils.getTranscripts()){
            if(t.getStudentId() == user.getId()){
                return t.getStatus();
            }
        }
        return null;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mainPanel.remove(this);
        CardLayout layout = (CardLayout) mainPanel.getLayout();
        layout.previous(mainPanel);
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean checkEligibility(){
        if(courses.size() < 8){
            return false;
        }
        
        for(UserToCourse uc: courses){
            if(!uc.isCompleted()){
                return false;
            }
        }
        
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnViewTranscript;
    private javax.swing.JPanel courseInfoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCourseInfo;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTable tblCourses;
    // End of variables declaration//GEN-END:variables
}
