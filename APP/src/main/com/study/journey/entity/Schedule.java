package com.study.journey.entity;

public class Schedule {
    private int No;
    private String Monday;
    private String Tuesday;
    private String Wednesday;
    private String Thursday;
    private String Friday;
    private String Saturday;
    private String Sunday;

    public Schedule(String Monday, String Tuesday, String Wednesday, String Thursday, String Friday, String Saturday, String Sunday) {
        setMonday(Monday);
        setTuesday(Tuesday);
        setWednesday(Wednesday);
        setThursday(Thursday);
        setFriday(Friday);
        setSaturday(Saturday);
        setSunday(Sunday);
    }

    public String getMonday() {
        return Monday;
    }

    public String getTuesday() {
        return Tuesday;
    }

    public String getWednesday() {
        return Wednesday;
    }

    public String getThursday() {
        return Thursday;
    }

    public String getFriday() {
        return Friday;
    }

    public String getSaturday() {
        return Saturday;
    }

    public String getSunday() {
        return Sunday;
    }

    public void setMonday(String monday) {
        Monday = monday;
    }

    public void setTuesday(String tuesday) {
        Tuesday = tuesday;
    }

    public void setWednesday(String wednesday) {
        Wednesday = wednesday;
    }

    public void setThursday(String thursday) {
        Thursday = thursday;
    }

    public void setFriday(String friday) {
        Friday = friday;
    }

    public void setSaturday(String saturday) {
        Saturday = saturday;
    }

    public void setSunday(String sunday) {
        Sunday = sunday;
    }
}
