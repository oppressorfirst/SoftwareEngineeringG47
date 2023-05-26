package com.study.journey.entity;

/**
 * The User class serves as a base class representing a user in the system.
 * This class includes fields for user ID, PIN, age, sex, and name.
 * copyright  : Copyright (c) 2023/5/26
 * @author Zhongxu Si, Hanyu Wu
 * @version 5.0
 */
public class User {


    protected String UserID;
    protected String UserPIN;
    protected String age;
    protected String sex;
    protected String name;

    /**
     * Default constructor that initializes a new User object.
     */
    public User() {
    }

    /**
     * Constructs a new User object with the provided details.
     *
     * @param ID The ID of the user.
     * @param PIN The PIN of the user.
     * @param age The age of the user.
     * @param sex The sex of the user.
     * @param name The name of the user.
     */
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
