package com.study.journey.entity;

import java.util.ArrayList;

public class Student extends  User{
    protected String classID;
    protected ArrayList<StudentModule> modules = new ArrayList<StudentModule>();

    public Student(String ID, String classID, String PIN, String age, String sex, String name) {
        super(ID, PIN, age, sex, name);
        this.classID = classID;
    }

    public ArrayList<StudentModule> getModules() {
        return modules;
    }

    public void setModules(ArrayList<StudentModule> modules) {
        this.modules = modules;
    }




}
