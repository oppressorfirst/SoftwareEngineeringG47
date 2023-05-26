package com.study.journey.entity;
/**
 * The Grade class represents a grade entry in the system.
 * It contains information about the course name, status, credit and the grade received by the student.
 * There are multiple constructors that can be used to create a Grade object depending on the available information.
 * copyright  : Copyright (c) 2023/5/26
 * @author Zhongxu Si, Jialun Zhang
 * @version 5.0
 */
public class Grade {
    private final String name;
    private String status;
    private int credit;
    private String grade;

    protected  String adc;



    public Grade(String name, String status, int credit, String grade) {
        this.name = name;
        this.status = status;
        this.credit = credit;
        this.grade = grade;
    }

    public Grade(String name, String status, int credit) {
        this.name = name;
        this.status = status;
        this.credit = credit;
    }

    public Grade(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }



    public String getName() {

        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getCredit() {
        return credit;
    }

    public String getGrade() {
        return grade;
    }



}
