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
public class AssignmentDirectory {
    ArrayList<Assignment> assignmentDirectory;
    
    public AssignmentDirectory() {
        this.assignmentDirectory = new ArrayList<>();
        refreshAssignmentList();
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

    public final void refreshAssignmentList(){
        try{
            assignmentDirectory = new ArrayList<>();
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");

            //Query SQL
            Statement stm = con.createStatement();
            String sql = "SELECT * FROM ASSIGNMENT";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Assignment assignment = new Assignment();
                assignment.setID(rs.getInt("ID"));
                assignment.setCourseId(rs.getInt("CourseID"));
                assignment.setName(rs.getString("Name"));
                assignment.setDescription(rs.getString("Description"));
                assignment.setDueDate(rs.getString("DueDate"));
                assignment.setPoints(rs.getInt("Points"));
                assignment.setUploaded(rs.getBoolean("Uploaded"));
                assignment.setProfId(rs.getInt("ProfId"));
                assignment.setProfName(rs.getString("ProfName"));
                assignment.setLink(rs.getString("Link"));
                assignmentDirectory.add(assignment);
            }
            
            stm.close();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Assignment> getAssignments() {
        refreshAssignmentList();
        return assignmentDirectory;
    }

    public void addAssignment(Assignment assignment) {
        assignmentDirectory.add(assignment);
        refreshAssignmentList();
    }

    public void removeAssignment(Assignment assignment) {
        assignmentDirectory.remove(assignment);
        refreshAssignmentList();
    }
    
    public ArrayList<Assignment> getAssignmentsWithStudentIDAndCourseId(int studentID, int courseId) {
        refreshAssignmentList();
        ArrayList<Assignment> result = new ArrayList<>();

        for (Assignment assignment : assignmentDirectory) {
            if (assignment.getCourseId() == courseId) {
                result.add(assignment);
            }
        }

        return result;
    }
    
    public ArrayList<Assignment> getAssignmentsWithStudentID(int studentID) {
        ArrayList<Assignment> assignments = new ArrayList<>();
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Query SQL -> CREATE NEW
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah")) {
                //Query SQL -> CREATE NEW
                 String sql = "SELECT * FROM Assignment WHERE StudentId = ?";
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setInt(1, studentID); // Set the courseId parameter
                    
                    ResultSet rs = preparedStatement.executeQuery();

                    while(rs.next()){
                        Assignment assignment = new Assignment();
                        
                        assignment.setID(rs.getInt("ID"));
                        assignment.setName(rs.getString("Name"));
                        assignment.setDescription(rs.getString("Description"));
                        assignment.setCourseId(rs.getInt("CourseID"));
                        assignment.setCourseName(rs.getString("CourseName"));
                        assignment.setDueDate(rs.getString("DueDate"));
                        assignment.setPoints(rs.getInt("Points"));
                        assignment.setUploaded(rs.getBoolean("Uploaded"));
                        assignment.setProfId(rs.getInt("ProfId"));
                        assignment.setProfName(rs.getString("ProfName"));
                        assignment.setLink(rs.getString("Link"));
                        assignment.setStudentId(rs.getInt("StudentId"));
                        assignment.setStudentName(rs.getString("StudentName"));
                        

                        //Adding list of assignments for each course
                        assignments.add(assignment);
                    }
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while uploading assignment");
            System.out.println(e.getMessage());
        }
        return assignments;
    }
    
    public boolean createAssignment(ArrayList<UserToCourse> students, Assignment newAssignment){
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            int affectedRows = 0;
            //Query SQL -> CREATE NEW
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah")) {
                //Query SQL -> CREATE NEW
                for(UserToCourse u : students){
                  String sql = "INSERT INTO assignment (Name, Description, CourseID, CourseName, DueDate, Points, Uploaded, ProfId, ProfName, Link, StudentId, StudentName) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                        pstmt.setString(1, newAssignment.getName());
                        pstmt.setString(2, newAssignment.getDescription());
                        pstmt.setInt(3, newAssignment.getID());
                        pstmt.setString(4, newAssignment.getCourseName());
                        pstmt.setString(5, newAssignment.getDueDate());
                        pstmt.setInt(6, newAssignment.getPoints());
                        pstmt.setBoolean(7, newAssignment.isUploaded());
                        pstmt.setInt(8, newAssignment.getProfId());
                        pstmt.setString(9, newAssignment.getProfName());
                        pstmt.setString(10, newAssignment.getLink());
                        pstmt.setInt(11, u.getUserID());
                        pstmt.setString(12, u.getStudentName());
                        affectedRows = pstmt.executeUpdate();
                    }
                }
                
            }
            
            return affectedRows > 0;
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while uploading assignment");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean uploadAssignment(int assignmentId){
        // TODO: Upload it in DB
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah");

            //Query SQL -> Update NEW flag
            String sql = "UPDATE assignment SET Uploaded = ? WHERE ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setBoolean(1, true);
            pstmt.setInt(2, assignmentId);
            int affectedRows = pstmt.executeUpdate();
            pstmt.close();
            con.close();
            
            return affectedRows > 0;
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while uploading assignment");
            System.out.println(e.getMessage());
            return false;
        }
        //Update Locally
//        for (int i = 0; i < assignmentDirectory.size(); i++) {
//            Assignment assignment = assignmentDirectory.get(i);
//            if (assignment.getID() == assignmentId) {
//                assignment.setUploaded(true);
//                return;
//            }
//        }
    }
}
