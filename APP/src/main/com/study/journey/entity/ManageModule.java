package com.study.journey.entity;

import java.util.ArrayList;

/**
 * The ManageModule class represents a specific module in the system that can be managed.
 * It extends from the Module class, with additional properties such as the lecturer
 * of the module and a list of students enrolled in this module.
 * It provides methods for adding and removing students, among others.
 * copyright  : Copyright (c) 2023/5/26
 * @author Ruizhi Yang, Zhongxu Si, Hanyu Wu
 * @version 5.0
 */
public class ManageModule extends  Module{
    protected  String lecturer;
    ArrayList<Student> student_list= new ArrayList<Student>();

    /**
     * Default constructor of ManageModule.
     */
    public ManageModule() {
    }

    /**
     * Construct a new ManageModule object with specific details.
     *
     * @param name The name of the module.
     * @param info Information about the module.
     * @param date The date associated with the module.
     * @param credit The credit value of the module.
     */
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

    /**
     * Add a student to the module.
     *
     * @param ID The ID of the student.
     * @param classID The class ID of the student.
     * @param PIN The PIN of the student.
     * @param age The age of the student.
     * @param sex The sex of the student.
     * @param name The name of the student.
     */
    public void add_student(String ID, String classID, String PIN, String age, String sex,String name){
        student_list.add(new Student(ID,classID, PIN, age, sex, name));
    }

    /**
     * Remove a student from the module by index.
     *
     * @param index The index of the student to be removed in the list.
     */
    public void remove_student(int index){
        student_list.remove(index);
    }
}
