/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class User {
    private int Id;
    private String name;
    private String email;
    private String major;
    private String username;
    private String password;
    private String enrollmentYear;
    private String type;
    private ArrayList<Course> courses;
    private String Feedback;
    private String Ranking;

    public String getRanking() {
        return Ranking;
    }

    public void setRanking(String Ranking) {
        this.Ranking = Ranking;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String Feedback) {
        this.Feedback = Feedback;
    }
    
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(String enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }
}
