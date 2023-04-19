package com.study.journey.model;

public class Info {
    private final String ID;
    private final String name;
    private final String PIN;



    public Info(String ID, String name, String PIN) {
        this.ID = ID;
        this.name = name;
        this.PIN = PIN;
    }




    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPIN() {
        return PIN;
    }



}
