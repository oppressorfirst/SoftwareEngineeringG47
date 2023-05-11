package com.study.journey.entity;

public class User {


    protected String UserID;
    protected String UserPIN;
    protected String age;
    protected String sex;
    protected String name;

    public User() {
    }

    public User(String ID, String PIN, String age, String sex, String name){
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.UserPIN = PIN;
        this.UserID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserPIN() {
        return UserPIN;
    }

    public void setUserPIN(String userPIN) {
        UserPIN = userPIN;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
}
