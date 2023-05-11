package com.study.journey.entity;

import java.util.ArrayList;

public class Student extends  User{
    protected ArrayList<StudentModule> modules = new ArrayList<StudentModule>();

    public Student(String ID, String PIN, String age, String sex, String name) {
        super(ID, PIN, age, sex, name);
    }

    public ArrayList<StudentModule> getModules() {
        return modules;
    }

    public void setModules(ArrayList<StudentModule> modules) {
        this.modules = modules;
    }


}
