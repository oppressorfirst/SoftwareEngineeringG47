package com.study.journey.entity;

public class StudentModule extends Module{
    protected  String score;
    protected  boolean is_finished = true;
    protected  String status;

    public  StudentModule(){

    }
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
