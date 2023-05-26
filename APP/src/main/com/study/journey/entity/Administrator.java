package com.study.journey.entity;

import java.util.ArrayList;


/**
 * The Administrator class represents an administrator user.
 * It extends the User class, adding functionalities for managing students and modules.
 * Each Administrator object maintains a list of Student and ManageModule objects.
 * It provides methods for adding and removing students, as well as adding modules.
 * copyright  : Copyright (c) 2023/5/26
 * @author Zhongxu Si, Hanyu Wu
 * @version 5.0
 */
public class Administrator extends User{
    protected ArrayList<Student> students = new ArrayList<Student>();
    protected ArrayList<ManageModule> modules = new ArrayList<ManageModule>();

    /**
     * Constructs an Administrator with the specified ID, PIN, age, sex, and name.
     *
     * @param ID the Administrator's ID.
     * @param PIN the Administrator's PIN.
     * @param age the Administrator's age.
     * @param sex the Administrator's sex.
     * @param name the Administrator's name.
     */
    public Administrator(String ID, String PIN, String age, String sex, String name) {
        super(ID, PIN, age, sex, name);
    }

    /**
     * Returns the list of Students managed by this Administrator.
     *
     * @return an ArrayList of Student objects.
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Sets the list of Students to be managed by this Administrator.
     *
     * @param students an ArrayList of Student objects.
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    /**
     * Returns the list of ManageModules managed by this Administrator.
     *
     * @return an ArrayList of ManageModule objects.
     */
    public ArrayList<ManageModule> getModules() {
        return modules;
    }

    /**
     * Sets the list of ManageModules to be managed by this Administrator.
     *
     * @param modules an ArrayList of ManageModule objects.
     */
    public void setModules(ArrayList<ManageModule> modules) {
        this.modules = modules;
    }

    /**
     * Adds a new Student to be managed by this Administrator.
     *
     * @param ID the new Student's ID.
     * @param classID the new Student's class ID.
     * @param PIN the new Student's PIN.
     * @param age the new Student's age.
     * @param sex the new Student's sex.
     * @param name the new Student's name.
     */
    public void addstudent(String ID, String classID, String PIN, String age, String sex, String name){
        students.add(new Student(ID, classID, PIN, age, sex, name));
    }

    /**
     * Removes a Student from the list of students managed by this Administrator.
     *
     * @param index the index of the Student to be removed in the ArrayList.
     */
    public void removestudent(int index){
        students.remove(index);
    }

    /**
     * Adds a new ManageModule to be managed by this Administrator.
     *
     * @param module_name the name of the new ManageModule.
     * @param module_info the information of the new ManageModule.
     * @param module_date the date of the new ManageModule.
     * @param credit the credit of the new ManageModule.
     */
    public void addManageModule(String module_name, String module_info,String module_date,int credit){
        modules.add(new ManageModule(module_name,module_info,module_date,credit));
    }
}
