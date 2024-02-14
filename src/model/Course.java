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
public class Course {
    private int ID;
    private int ProfID;
    private String Name;
    private String ProfName;
    private String Description;
    private int Credits;
    private String Material;
    private String Term;
    private ArrayList<Assignment> assignments;
    private String Time;
    private String Ranking; 
    private String PreReq;

    public String getPreReq() {
        return PreReq;
    }

    public void setPreReq(String PreReq) {
        this.PreReq = PreReq;
    }

    public String getRanking() {
        return Ranking;
    }

    public void setRanking(String Ranking) {
        this.Ranking = Ranking;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProfId() {
        return ProfID;
    }

    public void setProfId(int ProfID) {
        this.ProfID = ProfID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getProfName() {
        return ProfName;
    }

    public void setProfName(String ProfName) {
        this.ProfName = ProfName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int Credits) {
        this.Credits = Credits;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String Term) {
        this.Term = Term;
    }
    
    @Override
    public String toString(){
        return Integer.toString(ID);
    }
}
