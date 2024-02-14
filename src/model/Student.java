/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author nitishahuja
 */
public class Student {
    private int studentId;
    private String name;
    private String email;
    private String major;
    private String enrollmentYear;
    private ArrayList<String> enrolledCourses;
    private String password;

    public Student(int studentId, String name, String email, String major, String enrollmentYear,String password) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.major = major;
        this.enrollmentYear = "Fall - 2023"; //TODO: Update => enrollmentYear;
        this.enrolledCourses = new ArrayList<>();
        this.password = password;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMajor() {
        return major;
    }

    public String getEnrollmentYear() {
        return enrollmentYear;
    }

    public ArrayList<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollInCourse(String courseName) {
        enrolledCourses.add(courseName);
    }

    public void dropCourse(String courseName) {
        enrolledCourses.remove(courseName);
    }
}
