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

/**
 *
 * @author Dell
 */
public class TranscriptDirectory {
     private ArrayList<Transcript> transcriptDirectory;
     
     public TranscriptDirectory(){
         transcriptDirectory = new ArrayList<>();
     }
     
     public ArrayList<Transcript> getTranscripts(){
        try{
            transcriptDirectory = new ArrayList<>();
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");

            //Query SQL
            Statement stm = con.createStatement();
            String sql = "SELECT * FROM Transcript";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Transcript transcript = new Transcript();
                transcript.setID(rs.getInt("ID"));
                transcript.setStudentId(rs.getInt("StudentID"));
                transcript.setStudentName(rs.getString("StudentName"));
                transcript.setStatus(rs.getString("Status"));
                transcript.setCourseToUserId(rs.getInt("CoursetouserID"));
                transcriptDirectory.add(transcript);
            }
            
            stm.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
        }
        return transcriptDirectory;
     }
     
     public boolean isStudentEligibleForTranscript(int StudentId){
        try{
            transcriptDirectory = new ArrayList<>();
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");

            //Query SQL
            String sql = "SELECT * FROM Assignment WHERE StudentId = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, StudentId); // Set the courseId parameter
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Transcript transcript = new Transcript();
                transcript.setID(rs.getInt("ID"));
                transcript.setStudentId(rs.getInt("StudentID"));
                transcript.setStudentName(rs.getString("StudentName"));
                transcript.setStatus(rs.getString("Status"));
                transcript.setCourseToUserId(rs.getInt("CoursetouserID"));
                transcriptDirectory.add(transcript);
            }
            
            preparedStatement.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
        }
        
        return !transcriptDirectory.isEmpty();
     }
     
     public boolean updateTranscriptStatus(int studentId, String action){
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");

            //Query SQL -> CREATE NEW
            String sql = "UPDATE Transcript SET Status = ? WHERE StudentID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, action);
            pstmt.setInt(2, studentId);
            
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
     
     public boolean createTranscriptApplication(Transcript transcript){
                 try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");

            //Query SQL -> CREATE NEW
            String sql = "INSERT INTO transcript (StudentID, StudentName, Status, CoursetouserID) VALUES (?, ?, ?, ?);";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, transcript.getStudentId());
            pstmt.setString(2, transcript.getStudentName());
            pstmt.setString(3, "UnderReview");
            pstmt.setInt(4, 0);
            
            int affectedRows = pstmt.executeUpdate();
            pstmt.close();
            con.close();
            
            if(affectedRows > 0){
                return true;
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
        }
                 
        return false;
     }
}
