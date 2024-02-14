/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nitishahuja
 */
public class Utils {
    CourseDirectory courseDirectory;
    AssignmentDirectory assignmentDirectory;
    UserDirectory userDirectory;
    UserToCourseDirectory userToCourseDirectory;
    TranscriptDirectory transcriptDirectory;
    
    public Utils(){
        this.courseDirectory = new CourseDirectory();
        this.assignmentDirectory = new AssignmentDirectory();
        this.userDirectory = new UserDirectory();
        this.userToCourseDirectory = new UserToCourseDirectory();
        this.transcriptDirectory = new TranscriptDirectory();
    }

    public String hashPassword(String password){
        try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(password.getBytes());
                byte[] rbt = md.digest();
                StringBuilder sb = new StringBuilder();
                for(byte b: rbt){
                    sb.append(String.format("%02x", b));
                }
                return sb.toString();
            } catch (Exception ex) {}
        return null;
    }

    public static int generateRandomId() {
        Random random = new Random();
        int randomId = random.nextInt(10000); // You can adjust the range as needed
        return randomId;
    }
    
    public ArrayList<Course> getCourse(){
        return courseDirectory.getCourses();
    }

    public ArrayList<Assignment> getAssignment(){
        return assignmentDirectory.getAssignments();
    }
    
    public User getUserDetails(String profId){
        return userDirectory.getUserByUsername(profId);
    }
    
    public boolean enrollStudentToCourse(Course course, User user){
        return courseDirectory.enrollStudent(course, user);
    }
    
    public boolean createCourse(Course course, String profName, int profId){
        return courseDirectory.createCourse(course, profName, profId);
    }
    
//    public ArrayList<User> getCourseByUserId(int userId){
//        return userDirectory.getUserById(userId);
//    }
    
    public ArrayList<UserToCourse> getCoursesByStudentId(int studentId){
        return userToCourseDirectory.getStudentsByUserId(studentId);
    }
    
    public ArrayList<UserToCourse> getAllStudents(){
        return userToCourseDirectory.getAllStudents();
    }
    
    public boolean createAssignment(ArrayList<UserToCourse> students, Assignment newAssignment){
        return assignmentDirectory.createAssignment(students, newAssignment);
    }
    
    public ArrayList<UserToCourse> getStudentsByCourseId(int courseId){
        return userToCourseDirectory.getStudentsByCourseId(courseId);
    }
    
    public ArrayList<Course> getCoursesWithProfID(int profID){
        return courseDirectory.getCoursesWithProfID(profID);
    }
    
    public boolean UpdateStudentScore(int score, String remark, int studentId){
        return userToCourseDirectory.updateStudentScore(score, remark, studentId);
    }
    
    public boolean UpdateAttendance(int courseId, int userId, int attendance){
        return userToCourseDirectory.updateAttendance(courseId, userId, attendance);
    }
    
    public ArrayList<Course> getCoursesByCourseId(ArrayList<UserToCourse> userToCourse){
        return courseDirectory.getCoursesByCourseId(userToCourse);
    }
    
    public ArrayList<Course> getCoursesByCourseName(String courseName){
        return courseDirectory.getCoursesByCourseName(courseName);
    }
    
    public ArrayList<Assignment> getAssignmentsWithStudentID(int studentId){
        return assignmentDirectory.getAssignmentsWithStudentID(studentId);
    }
    
    public ArrayList<User> getAllUser(){
        return userDirectory.getUser();
    }
    
    public ArrayList<Transcript> getTranscripts(){
        return transcriptDirectory.getTranscripts();
    }
    
    public boolean createTranscriptApplication(Transcript transcript){
        return transcriptDirectory.createTranscriptApplication(transcript);
    }
    
    public boolean updateTranscriptStatus(int studentId, String action){
        return transcriptDirectory.updateTranscriptStatus(studentId, action);
    }
    
    public boolean giveUserFeedback(String ranking, String feedback, int userId){
        return userDirectory.giveUserFeedback(ranking, feedback, userId);
    }
    
    public boolean updatePassword(String hashedPassword, int userId){
        return userDirectory.updatePassword(hashedPassword, userId);
    }
}
