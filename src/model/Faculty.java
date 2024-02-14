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
public class Faculty {

    private int facultyId;
    private String name;
    private String email;
    private String department;
    private int yearsOfExperience;
    private double averageRating;
    private String password;


    public Faculty(int facultyId, String name, String email, String department, int yearsOfExperience, double averageRating, String password ) {
        this.facultyId = facultyId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
        this.averageRating = averageRating;
        this.password = password;

    }

    public int getFacultyId() {
        return facultyId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public double getAverageRating() {
        return averageRating;
    }

}
