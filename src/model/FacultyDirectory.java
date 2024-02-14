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
public class FacultyDirectory {
    private ArrayList<Faculty> faculties;

    public FacultyDirectory() {
        this.faculties = new ArrayList<>();

        // Create 10 Faculty Members
        Faculty faculty1 = new Faculty(1, "John Doe", "john@example.com", "Computer Science", 10, 4.5,"password1");
        Faculty faculty2 = new Faculty(2, "Jane Smith", "jane@example.com", "Physics", 8, 4.2,"password1");
        Faculty faculty3 = new Faculty(3, "Alice Johnson", "alice@example.com", "Mathematics", 12, 4.8,"password1");
        Faculty faculty4 = new Faculty(4, "Bob Brown", "bob@example.com", "Chemistry", 6, 4.0,"password1");

        // Add Faculty Members to the ArrayList
        faculties.add(faculty1);
        faculties.add(faculty2);
        faculties.add(faculty3);
        faculties.add(faculty4);
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    
}
