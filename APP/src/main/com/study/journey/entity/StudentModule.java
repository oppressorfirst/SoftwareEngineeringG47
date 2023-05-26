package com.study.journey.entity;
/**
 * The StudentModule class represents a module specific to a student.
 * It extends the Module class, adding a score, finished status, and completion status.
 * copyright  : Copyright (c) 2023/5/26
 * @author Zhongxu Si, Hanyu Wu
 * @version 5.0
 */
public class StudentModule extends Module{
    protected  String score;
    protected  boolean is_finished = true;
    protected  String status;

    /**
     * Default constructor that initializes a new StudentModule object.
     */
    public  StudentModule(){

    }

    /**
     * Constructs a new StudentModule object with the provided details.
     *
     * @param name The name of the module.
     * @param info The info of the module.
     * @param date The date of the module.
     * @param score The score of the student in the module.
     * @param credit The credit of the module.
     * @param status The status of the module (finished or not).
     */
    public StudentModule(String name, String info, String date, String score, int credit, String status) {
        super(name, info, date,credit);
        this.score = score;
        this.status = status;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public boolean isfinished() {
        return is_finished;
    }

    public void setIsfinished(boolean is_finished) {
        this.is_finished = is_finished;
    }

    public String getFinish_percent() {
        return status;
    }

    public void setFinish_percent(String status) {
        this.status = status;
    }
}
