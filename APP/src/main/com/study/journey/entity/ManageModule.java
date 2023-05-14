package com.study.journey.entity;

import java.util.ArrayList;

public class ManageModule extends  Module{
    protected  String lecturer;
    ArrayList<Student> student_list= new ArrayList<Student>();

    public ManageModule() {
    }

    public ManageModule(String name, String info, String date,int credit) {
        super(name, info, date,credit);
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public ArrayList<Student> getStudent_list() {
        return student_list;
    }

    public void setStudent_list(ArrayList<Student> student_list) {
        this.student_list = student_list;
    }

    public void add_student(String ID, String classID, String PIN, String age, String sex,String name){
        student_list.add(new Student(ID,classID, PIN, age, sex, name));
    }

    public void remove_student(int index){
        student_list.remove(index);
    }
}
