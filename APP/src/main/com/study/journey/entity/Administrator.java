package com.study.journey.entity;

import java.util.ArrayList;

public class Administrator extends User{
    protected ArrayList<Student> students = new ArrayList<Student>();
    protected ArrayList<ManageModule> modules = new ArrayList<ManageModule>();

    public Administrator(String ID, String PIN, String age, String sex, String name) {
        super(ID, PIN, age, sex, name);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<ManageModule> getModules() {
        return modules;
    }

    public void setModules(ArrayList<ManageModule> modules) {
        this.modules = modules;
    }

    public void addstudent(String ID, String PIN, String age, String sex, String name){
        students.add(new Student(ID, PIN, age, sex, name));
    }
    public void removestudent(int index){
        students.remove(index);
    }

    public void addManageModule(String module_name, String module_info,String module_date,int credit){
        modules.add(new ManageModule(module_name,module_info,module_date,credit));
    }
}
