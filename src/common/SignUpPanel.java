/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package common;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.UserDirectory;
import model.Utils;

public class SignUpPanel extends javax.swing.JPanel {

    /**
     * Creates new form SignUpPanel
     */
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private Pattern pattern;
    
    JPanel mainPanel;
    UserDirectory users;
    Utils utils;
    public SignUpPanel(JPanel mainPanel,UserDirectory users, Utils utils) {
        initComponents();
        this.mainPanel = mainPanel;
        this.users = users;
        this.utils = utils;
        this.pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusername = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        btnSignup = new javax.swing.JButton();
        lblusername = new javax.swing.JLabel();
        txtEmailId = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        lblEmailId = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        lblname = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        lblpassword = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        lblUserType = new javax.swing.JLabel();
        txtMajor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblMajor1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txttype = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(73, 77, 94));

        txtusername.setBackground(new java.awt.Color(73, 77, 94));
        txtusername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtusername.setForeground(new java.awt.Color(239, 234, 234));
        txtusername.setToolTipText("Username");
        txtusername.setBorder(null);

        jSeparator4.setBackground(new java.awt.Color(239, 234, 234));
        jSeparator4.setForeground(new java.awt.Color(239, 234, 234));

        btnSignup.setBackground(new java.awt.Color(73, 77, 94));
        btnSignup.setForeground(new java.awt.Color(239, 234, 234));
        btnSignup.setText("SIGN UP");
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });

        lblusername.setBackground(new java.awt.Color(255, 255, 255));
        lblusername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblusername.setForeground(new java.awt.Color(239, 234, 234));
        lblusername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblusername.setText("Username:");

        txtEmailId.setBackground(new java.awt.Color(73, 77, 94));
        txtEmailId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEmailId.setForeground(new java.awt.Color(239, 234, 234));
        txtEmailId.setToolTipText("Username");
        txtEmailId.setBorder(null);

        jSeparator5.setBackground(new java.awt.Color(239, 234, 234));
        jSeparator5.setForeground(new java.awt.Color(239, 234, 234));

        lblEmailId.setBackground(new java.awt.Color(255, 255, 255));
        lblEmailId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmailId.setForeground(new java.awt.Color(239, 234, 234));
        lblEmailId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmailId.setText("Email ID:");

        jSeparator6.setBackground(new java.awt.Color(239, 234, 234));
        jSeparator6.setForeground(new java.awt.Color(239, 234, 234));

        lblname.setBackground(new java.awt.Color(255, 255, 255));
        lblname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblname.setForeground(new java.awt.Color(239, 234, 234));
        lblname.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblname.setText("Name:");

        txtname.setBackground(new java.awt.Color(73, 77, 94));
        txtname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtname.setForeground(new java.awt.Color(239, 234, 234));
        txtname.setToolTipText("Username");
        txtname.setBorder(null);

        jSeparator7.setBackground(new java.awt.Color(239, 234, 234));
        jSeparator7.setForeground(new java.awt.Color(239, 234, 234));

        lblpassword.setBackground(new java.awt.Color(255, 255, 255));
        lblpassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblpassword.setForeground(new java.awt.Color(239, 234, 234));
        lblpassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblpassword.setText("Password:");

        txtpassword.setBackground(new java.awt.Color(73, 77, 94));
        txtpassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(239, 234, 234));
        txtpassword.setToolTipText("Username");
        txtpassword.setBorder(null);

        jSeparator8.setBackground(new java.awt.Color(239, 234, 234));
        jSeparator8.setForeground(new java.awt.Color(239, 234, 234));

        lblUserType.setBackground(new java.awt.Color(255, 255, 255));
        lblUserType.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUserType.setForeground(new java.awt.Color(239, 234, 234));
        lblUserType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserType.setText("Sign Up As:");

        txtMajor.setBackground(new java.awt.Color(73, 77, 94));
        txtMajor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMajor.setForeground(new java.awt.Color(239, 234, 234));
        txtMajor.setToolTipText("Username");
        txtMajor.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 234, 234));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign Up");

        lblMajor1.setBackground(new java.awt.Color(255, 255, 255));
        lblMajor1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMajor1.setForeground(new java.awt.Color(239, 234, 234));
        lblMajor1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMajor1.setText("Major:");

        btnBack.setBackground(new java.awt.Color(73, 77, 94));
        btnBack.setForeground(new java.awt.Color(239, 234, 234));
        btnBack.setText("< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txttype.setBackground(new java.awt.Color(73, 77, 94));
        txttype.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txttype.setForeground(new java.awt.Color(239, 234, 234));
        txttype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Teacher", "Admin", "transcriptadmin" }));

        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("<html>\n1. At least one digit. <br/>\n2. At least one lowercase letter.<br/>\n3.  At least one uppercase letter.<br/>\n4.  At least one special character from the given set.<br/>\n5. Minimum of 8 characters.\n</html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblMajor1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(424, 424, 424)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMajor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean nullCheck(){
        var name = txtname.getText();
        // txtlastname.getText();
        var username = txtusername.getText();
        var password = txtpassword.getText();
        // var phoneNumber = txtphonenumber.getText();
        if(name.isEmpty() && username.isEmpty() && password.isEmpty()){
            return false;
        }
        return true;
    }
    
    public boolean validatePassword(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        if(!nullCheck()){
            JOptionPane.showMessageDialog(this, "All fields are mandatory");
            return;
        }
        String password = txtpassword.getText();
        //Check password
        if(!validatePassword(password)){
            JOptionPane.showMessageDialog(this, "Password is too weak. Cover all the points");
            return;
        }
        
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");
            //Get input data.
            String name = txtname.getText();
            String emailid = txtEmailId.getText();
            String major = txtMajor.getText();
            String username = txtusername.getText();
            String hashedPassword = utils.hashPassword(password);
            //TODO: Change Type
            String type = txttype.getSelectedItem().toString();


            //Query SQL -> CREATE NEW
            String sql = "INSERT INTO USERS (Name, Emailid, Major, username, password, TYPE) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, emailid);
            pstmt.setString(3, major);
            pstmt.setString(4, username);
            pstmt.setString(5, hashedPassword);
            pstmt.setString(6, type);
            int affectedRows = pstmt.executeUpdate();
            
            if(affectedRows > 0){
                JOptionPane.showMessageDialog(this,"SignUp Successful");
                //Refresh the local users list to sync with DB.
                users.refreshUserList();
                
                  //Navigating user to Dashboard
//                StudentDashboardPanel panel = new StudentDashboardPanel(mainPanel);
//                mainPanel.add("StudentDashboardPanel",panel);
//                CardLayout layout = (CardLayout) mainPanel.getLayout();
//                layout.next(mainPanel);
                
                //Navigating user to Login.
                mainPanel.remove(this);
                CardLayout layout = (CardLayout) mainPanel.getLayout();
                layout.previous(mainPanel);
                
                
            }else{
                JOptionPane.showMessageDialog(this,"SignUp Failed");
            }
            
            pstmt.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Unable to Sign In", "Error", JOptionPane.ERROR_MESSAGE);
        }
//                StudentDashboardPanel panel = new StudentDashboardPanel(mainPanel);
//                mainPanel.add("StudentDashboardPanel",panel);
//                CardLayout layout = (CardLayout) mainPanel.getLayout();
//                layout.next(mainPanel);
    }//GEN-LAST:event_btnSignupActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        mainPanel.remove(this);
                CardLayout layout = (CardLayout) mainPanel.getLayout();
                layout.previous(mainPanel);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblEmailId;
    private javax.swing.JLabel lblMajor1;
    private javax.swing.JLabel lblUserType;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblpassword;
    private javax.swing.JLabel lblusername;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtMajor;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JComboBox<String> txttype;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
