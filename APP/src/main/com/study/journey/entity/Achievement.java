package com.study.journey.entity;

/**
 * The Achievement class represents an achievement earned by a student.
 * Each Achievement object has a name, level, and the year it was earned.
 * Copyright  : Copyright (c) 2023/5/26
 * @author Ruizhi Yang, Jialun Zhang
 * @version 5.0
 */
public class Achievement {

    private String name;
    private String level;
    private String year;

    /**
     * Constructs an Achievement with a name, level, and year.
     *
     * @param name the name of the achievement.
     * @param level the level of the achievement.
     * @param year the year the achievement was earned.
     */
    public Achievement(String name, String level, String year) {
        setName(name);
        setLevel(level);
        setYear(year);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
