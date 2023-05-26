package com.study.journey.entity;

import java.util.ArrayList;
/**
 * The Student class represents a student in the system.
 * It extends the User class, adding a classID property and a list of StudentModule objects.
 * copyright  : Copyright (c) 2023/5/26
 * @author Ruizhi Yang, Zhongxu Si, Hanyu Wu
 * @version 5.0
 */
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
