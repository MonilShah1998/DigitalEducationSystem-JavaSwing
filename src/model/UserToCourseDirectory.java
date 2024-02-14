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
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class UserToCourseDirectory {
    ArrayList<UserToCourse> userToCourseDirectory;
    
    public UserToCourseDirectory(){
        this.userToCourseDirectory = new ArrayList<>();
    }
    
    public ArrayList<UserToCourse> getAllStudents(){
        userToCourseDirectory = new ArrayList<>();
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");
            //Query SQL
            String sql = "SELECT * FROM usertocourse";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                UserToCourse userToCourse = new UserToCourse();
                userToCourse.setUserID(rs.getInt("UserID"));
                userToCourse.setCourseName(rs.getString("CourseName"));
                userToCourse.setAttendance(rs.getInt("Attendance"));
                userToCourse.setScore(rs.getInt("Score"));
                userToCourse.setCourseID(rs.getInt("CourseID"));
                userToCourse.setStudentName(rs.getString("StudentName"));
                userToCourse.setCompleted(rs.getBoolean("Completed"));
                userToCourse.setRemarks(rs.getString("Remarks"));
                
                //Adding list of assignments for each course
                userToCourseDirectory.add(userToCourse);
            }
            
            preparedStatement.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
        }
        
        return userToCourseDirectory;
    }
    
    public ArrayList<UserToCourse> getStudentsByCourseId(int courseId){
        userToCourseDirectory = new ArrayList<>();
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");
            //Query SQL
            String sql = "SELECT * FROM usertocourse WHERE CourseID = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, courseId); // Set the courseId parameter

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                UserToCourse userToCourse = new UserToCourse();
                userToCourse.setID(rs.getInt("ID"));
                userToCourse.setUserID(rs.getInt("UserID"));
                userToCourse.setCourseName(rs.getString("CourseName"));
                userToCourse.setAttendance(rs.getInt("Attendance"));
                userToCourse.setScore(rs.getInt("Score"));
                userToCourse.setCourseID(rs.getInt("CourseID"));
                userToCourse.setStudentName(rs.getString("StudentName"));
                userToCourse.setCompleted(rs.getBoolean("Completed"));
                userToCourse.setRemarks(rs.getString("Remarks"));
                
                //Adding list of assignments for each course
                userToCourseDirectory.add(userToCourse);
            }
            
            preparedStatement.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
        }
        
        return userToCourseDirectory;
    }
    
    public ArrayList<UserToCourse> getStudentsByUserId(int courseId){
        userToCourseDirectory = new ArrayList<>();
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");
            //Query SQL
            String sql = "SELECT * FROM usertocourse WHERE UserID = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, courseId); // Set the courseId parameter

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                UserToCourse userToCourse = new UserToCourse();
                userToCourse.setID(rs.getInt("ID"));
                userToCourse.setUserID(rs.getInt("UserID"));
                userToCourse.setCourseName(rs.getString("CourseName"));
                userToCourse.setAttendance(rs.getInt("Attendance"));
                userToCourse.setScore(rs.getInt("Score"));
                userToCourse.setCourseID(rs.getInt("CourseID"));
                userToCourse.setStudentName(rs.getString("StudentName"));
                userToCourse.setCompleted(rs.getBoolean("Completed"));
                userToCourse.setRemarks(rs.getString("Remarks"));
                //Adding list of assignments for each course
                userToCourseDirectory.add(userToCourse);
            }
            
            preparedStatement.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
        }
        
        return userToCourseDirectory;
    }
    
    public boolean updateStudentScore(int score, String remark, int studentId){
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");

            //Query SQL -> CREATE NEW
            String sql = "UPDATE UserToCourse SET Score = ?, Completed = ?, Remarks = ? WHERE ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, score);
            pstmt.setBoolean(2, true);
            pstmt.setString(3, remark);
            pstmt.setInt(4, studentId);
            
            int affectedRows = pstmt.executeUpdate();
            
            pstmt.close();
            con.close();
            
            return affectedRows > 0;
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public boolean updateAttendance(int courseId, int userId, int attendance){
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");

            //Query SQL -> CREATE NEW
            String sql = "UPDATE UserToCourse SET Attendance = ? WHERE UserID = ? and CourseID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, attendance);
            pstmt.setInt(2, userId);
            pstmt.setInt(3, courseId);
            int affectedRows = pstmt.executeUpdate();
            
            pstmt.close();
            con.close();
            
            return affectedRows > 0;
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
        }
        return false;
    }
}
