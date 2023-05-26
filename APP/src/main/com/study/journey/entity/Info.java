package com.study.journey.entity;

/**
 * The Info class is an entity that represents information about a user in the system.
 * It encapsulates details such as ID, class ID, name, and PIN associated with a user.
 * There are getters and setters provided for accessing and updating these attributes.
 * copyright  : Copyright (c) 2023/5/26
 * @author Ruizhi Yang, Jialun Zhang
 * @version 5.0
 */
public class Info {
    private String ID;
    private String classID;
    private String name;
    private String PIN;


    /**
     * Construct a new Info object.
     *
     * @param ID The ID of the user.
     * @param classID The class ID of the user.
     * @param name The name of the user.
     * @param PIN The PIN of the user.
     */
    public Info(String ID, String classID, String name, String PIN) {
        this.ID = ID;
        this.classID = classID;
        this.name = name;
        this.PIN = PIN;
    }


    public void setID(String ID){
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getID() {
        return ID;
    }

    public String getClassID() {
        return classID;
    }

    public String getName() {
        return name;
    }

    public String getPIN() {
        return PIN;
    }



}
