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
public class CourseDirectory {

    ArrayList<Course> courseDirectory;
    AssignmentDirectory assignmentDirectory;

    public CourseDirectory() {
        this.courseDirectory = new ArrayList<>();
        this.assignmentDirectory = new AssignmentDirectory();
        refreshCourseList();
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

    public final void refreshCourseList() {
        try {
            courseDirectory = new ArrayList<>();
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem", "root", "monilshah");

            //Query SQL
            Statement stm = con.createStatement();

            String sql = "SELECT * FROM COURSES";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Course course = new Course();
                course.setID(rs.getInt("ID"));
                course.setProfId(rs.getInt("ProfId"));
                course.setName(rs.getString("Name"));
                course.setProfName(rs.getString("ProfName"));
                course.setDescription(rs.getString("Description"));
                course.setMaterial(rs.getString("Material"));
                course.setCredits(rs.getInt("Credits"));
                course.setTerm(rs.getString("Term"));
                course.setTime(rs.getString("Time"));
                course.setRanking(rs.getString("Ranking"));
                course.setPreReq(rs.getString("PreReq"));

                //Adding list of assignments for each course
                course.setAssignments(assignmentDirectory.getAssignmentsWithStudentIDAndCourseId(course.getProfId(), course.getID()));
                courseDirectory.add(course);
            }

            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Course> getCourses() {
        refreshCourseList();
        return courseDirectory;
    }

    public void addCourse(Course course) {
        courseDirectory.add(course);
        refreshCourseList();
    }

    public void removeCourse(Course course) {
        courseDirectory.remove(course);
        refreshCourseList();
    }

    public ArrayList<Course> getCoursesWithStudentID(int ProfID) {
        refreshCourseList();
        ArrayList<Course> result = new ArrayList<>();

        for (Course course : courseDirectory) {
            if (course.getProfId() == ProfID) {
                result.add(course);
            }
        }

        return result;
    }

    public ArrayList<Course> getCoursesWithProfID(int ProfID) {
        refreshCourseList();
        ArrayList<Course> result = new ArrayList<>();

        for (Course course : courseDirectory) {
            if (course.getProfId() == ProfID) {
                result.add(course);
            }
        }

        return result;
    }

    public boolean enrollStudent(Course course, User user) {
        //TODO: Enroll to course.
        try {
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem", "root", "monilshah");

            //Query SQL
            Statement stm = con.createStatement();
            String sql = "INSERT INTO UserToCourse (UserID, CourseName, Attendance, Score, CourseID, StudentName, Completed, Remarks) VALUES  (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, course.getName());
            pstmt.setInt(3, 0);
            pstmt.setInt(4, 0);
            pstmt.setInt(5, course.getID());
            pstmt.setString(6, user.getName());
            pstmt.setBoolean(7, false);
            pstmt.setString(8, "");
            
            int affectedRows = pstmt.executeUpdate();

            stm.close();
            con.close();

            return affectedRows > 0;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean createCourse(Course course, String profName, int ProfId) {
        try {
            courseDirectory = new ArrayList<>();
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem", "root", "monilshah");

            //Query SQL
            Statement stm = con.createStatement();
            String sql = "INSERT INTO Courses (ProfID, Name, ProfName, Description, Credits, Material, Term, Time, Ranking, PreReq) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, ProfId);
            pstmt.setString(2, course.getName());
            pstmt.setString(3, profName);
            pstmt.setString(4, course.getDescription());
            pstmt.setInt(5, course.getCredits());
            pstmt.setString(6, course.getMaterial());
            pstmt.setString(7, course.getTerm());
            pstmt.setString(8, course.getTime());
            pstmt.setString(9, course.getRanking() != null ? course.getRanking() : "");
            pstmt.setString(10, course.getPreReq() != null ? course.getPreReq() : "");

            int affectedRows = pstmt.executeUpdate();

            stm.close();
            con.close();

            return affectedRows > 0;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("There has been an issue while logging in");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Course> getCoursesByCourseId(ArrayList<UserToCourse> userToCourse){
        ArrayList<Course> courseList = new ArrayList<>();
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Query SQL -> CREATE NEW
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah")) {
                //Query SQL -> CREATE NEW
                for(UserToCourse u : userToCourse){
                    //Query SQL
                    String sql = "SELECT * FROM COURSES WHERE ID = ?";
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setInt(1, u.getCourseID()); // Set the courseId parameter
                    
                    ResultSet rs = preparedStatement.executeQuery();

                    while(rs.next()){
                        Course course = new Course();
                        
                        course.setID(rs.getInt("ID"));
                        course.setProfId(rs.getInt("ProfId"));
                        course.setName(rs.getString("Name"));
                        course.setProfName(rs.getString("ProfName"));
                        course.setDescription(rs.getString("Description"));
                        course.setMaterial(rs.getString("Material"));
                        course.setCredits(rs.getInt("Credits"));
                        course.setTerm(rs.getString("Term"));
                        course.setTime(rs.getString("Time"));
                        course.setRanking(rs.getString("Ranking"));
                        course.setPreReq(rs.getString("PreReq"));

                        //Adding list of assignments for each course
                        courseList.add(course);
                    }
                }
                
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while uploading assignment");
            System.out.println(e.getMessage());
        }
        return courseList;
    }
    
    public ArrayList<Course> getCoursesByCourseName(String courseName){
        ArrayList<Course> courseList = new ArrayList<>();
        try{
            //SQL Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Query SQL -> CREATE NEW
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaleducationsystem","root","monilshah")) {
                //Query SQL -> CREATE NEW
                    //Query SQL
                    String sql = "SELECT * FROM COURSES WHERE Name = ?";
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setString(1, courseName); // Set the courseId parameter
                    
                    ResultSet rs = preparedStatement.executeQuery();

                    while(rs.next()){
                        Course course = new Course();
                        
                        course.setID(rs.getInt("ID"));
                        course.setProfId(rs.getInt("ProfId"));
                        course.setName(rs.getString("Name"));
                        course.setProfName(rs.getString("ProfName"));
                        course.setDescription(rs.getString("Description"));
                        course.setMaterial(rs.getString("Material"));
                        course.setCredits(rs.getInt("Credits"));
                        course.setTerm(rs.getString("Term"));
                        course.setTime(rs.getString("Time"));
                        course.setRanking(rs.getString("Ranking"));
                        course.setPreReq(rs.getString("PreReq"));

                        //Adding list of assignments for each course
                        courseList.add(course);
                    }
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("There has been an issue while uploading assignment");
            System.out.println(e.getMessage());
        }
        return courseList;
    }
}
