package com.study.journey.entity;

public class Info {
    private String ID;
    private String classID;
    private String name;
    private String PIN;



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
