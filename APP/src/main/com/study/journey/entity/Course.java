package com.study.journey.entity;

import java.util.Date;
/**
 * The Course class represents a course in the system.
 * It contains information about the course including course number,
 * course title, course time, class place, course type, credit and a flag indicating if it's chosen or not.
 * copyright  : Copyright (c) 2023/5/26
 * @author Jialun Zhang
 * @version 5.0
 */
public class Course {
     private String courseNumber;
    private String courseTitle;
    private Date courseTime;
    private String classPlace;
   // private String    week参数不想要了
    private String courseType;
    private int credit;
    private boolean isChosen;
}
