/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
public class Transcript {
    private int ID;
    private int StudentId;
    private String StudentName;
    private String Status;
    private int CourseToUserId;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getCourseToUserId() {
        return CourseToUserId;
    }

    public void setCourseToUserId(int CourseToUserId) {
        this.CourseToUserId = CourseToUserId;
    }
    
    @Override
    public String toString(){
        return Integer.toString(ID);
    }
}
