package com.study.journey.entity;

public class Info {
    private final String ID;
    private final String classID;
    private final String name;
    private final String PIN;



    public Info(String ID, String classID, String name, String PIN) {
        this.ID = ID;
        this.classID = classID;
        this.name = name;
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
