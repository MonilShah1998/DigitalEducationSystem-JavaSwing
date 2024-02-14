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
public class StudentDirectory {
    private ArrayList<Student> studentDirectory;

    public StudentDirectory() {
        this.studentDirectory = new ArrayList<>();

        // Create and add some initial students
        Student student1 = new Student(1, "John Doe", "john@example.com", "Computer Science", "Fall - 2023","1234");
        Student student2 = new Student(2, "Jane Smith", "jane@example.com", "Mathematics", "Fall - 2022","1234");
        Student student3 = new Student(3, "Alice Johnson", "alice@example.com", "Physics", "Spring - 2023","1234");

        // Add them to the list
        studentDirectory.add(student1);
        studentDirectory.add(student2);
        studentDirectory.add(student3);
    }

    public ArrayList<Student> getStudents() {
        return studentDirectory;
    }

    public void addStudent(Student student) {
        studentDirectory.add(student);
    }

    public void removeStudent(Student student) {
        studentDirectory.remove(student);
    }


}
