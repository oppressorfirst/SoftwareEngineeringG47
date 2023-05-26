package com.study.journey.entity;

/**
 * The Schedule class represents a weekly schedule.
 * It contains properties representing each day of the week, from Monday to Sunday.
 * The class provides getters and setters for these properties.
 * copyright  : Copyright (c) 2023/5/26
 * @author Ruizhi Yang, Jialun Zhang
 * @version 5.0
 */
public class Schedule {
    private int No;
    private String Monday;
    private String Tuesday;
    private String Wednesday;
    private String Thursday;
    private String Friday;
    private String Saturday;
    private String Sunday;

    /**
     * Construct a new Schedule object with specific details for each day of the week.
     *
     * @param Monday The details for Monday.
     * @param Tuesday The details for Tuesday.
     * @param Wednesday The details for Wednesday.
     * @param Thursday The details for Thursday.
     * @param Friday The details for Friday.
     * @param Saturday The details for Saturday.
     * @param Sunday The details for Sunday.
     */
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
