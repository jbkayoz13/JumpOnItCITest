package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;



public class ClassManagement {
 
    private Long classID;
    private String className;
    private String classLocation;
    private String classTrainer;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date classDate;
    String classTime;

    public ClassManagement() {

    }

    public ClassManagement(String className, String classLocation, String classTrainer, Date classDate, String classTime){
        this.className=className;
        this.classLocation=classLocation;
        this.classTrainer=classTrainer;
        this.classDate=classDate;
        this.classTime=classTime;

    }

    public Long getClassID() {
        return classID;
    }

    public void setClassID(Long classID) {
        this.classID = classID;
    }


    public String getClassTrainer() {
        return classTrainer;
    }

    public void setClassTrainer(String classTrainer) {
        this.classTrainer = classTrainer;
    }

    public String getClassLocation() {
        return classLocation;
    }

    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getClassDate() {
        return classDate;
    }

    public void setClassDate(Date classDateTime) {
        this.classDate = classDateTime;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }
}
