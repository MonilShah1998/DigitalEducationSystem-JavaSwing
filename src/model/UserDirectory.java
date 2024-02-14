/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Dell
 */
public class UserDirectory {
    ArrayList<User> userDirectory;
    Connection con;
    CourseDirectory courseDirectory;
    
    public UserDirectory() {
        this.userDirectory = new ArrayList<>();
        this.courseDirectory = new CourseDirectory();
        
        refreshUserList();
        // Create and add some initial students
//        Student student1 = new Student(1, "John Doe", "john@example.com", "Computer Science", "Fall - 2023","1234");
//        Student student2 = new Student(2, "Jane Smith", "jane@example.com", "Mathematics", "Fall - 2022","1234");
//        Student student3 = new Student(3, "Alice Johnson", "alice@example.com", "Physics", "Spring - 2023","1234");
//
//        // Add them to the list
//        studentDirectory.add(student1);
//        studentDirectory.add(student2);
//        studentDirectory.add(student3);
        
    }

    public final void refreshUserList(){
        try{
            userDirectory = new ArrayList<>();
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");

            //Query SQL
            Statement stm = con.createStatement();
            String sql = "SELECT * FROM USERS";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Emailid"));
                user.setMajor(rs.getString("Major"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setType(rs.getString("type"));
                user.setFeedback(rs.getString("Feedback"));
                user.setRanking(rs.getString("Ranking"));
                //Get Courses
                //TODO: Important Change this
                user.setCourses(courseDirectory.getCoursesWithStudentID(user.getId()));
                
                userDirectory.add(user);  
            }
            
            stm.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<User> getUser() {
        refreshUserList();
        return userDirectory;
    }

    public void addUser(User user) {
        userDirectory.add(user);
    }

    public void removeUser(User user) {
        userDirectory.remove(user);
    }
    
    public User containsUser(String username, String password, String type) {
        refreshUserList();
        for (User user : userDirectory) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.getType().equalsIgnoreCase(type)) {
                return user; // User with the specified username and password found
            }
        }
        return null; // User not found
    }
    
    public User getUserById(int id){
        refreshUserList();
        for (User user : userDirectory) {
            if (user.getId() == id) {
                return user; // User with the specified username and password found
            }
        }
        return null; // User not found
    }
    
    public User getUserByUsername(String profId){
        refreshUserList();
        for (User user : userDirectory) {
            if (Integer.toString(user.getId()).equals(profId)) {
                return user; // User with the specified username and password found
            }
        }
        return null; // User not found
    }
    
    public boolean giveUserFeedback(String ranking, String feedback, int userId){
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");

            //Query SQL -> CREATE NEW
            String sql = "UPDATE Users SET Feedback = ?, Ranking = ? WHERE ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, feedback);
            pstmt.setString(2, ranking);
            pstmt.setInt(3, userId);
            
            int affectedRows = pstmt.executeUpdate();
            
            pstmt.close();
            con.close();
            
            return affectedRows > 0;
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while updating feedback");
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public boolean updatePassword(String hashedPassword, int userID){
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");

            //Query SQL -> CREATE NEW
            String sql = "UPDATE Users SET Password = ? WHERE ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, hashedPassword);
            pstmt.setInt(2, userID);
            
            int affectedRows = pstmt.executeUpdate();
            
            pstmt.close();
            con.close();
            
            return affectedRows > 0;
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while updating feedback");
            System.out.println(e.getMessage());
        }
        return false;
    }
}
