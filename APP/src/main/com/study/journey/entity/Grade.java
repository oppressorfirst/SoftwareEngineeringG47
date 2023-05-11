package com.study.journey.entity;

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
