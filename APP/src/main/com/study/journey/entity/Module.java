package com.study.journey.entity;

import java.util.Date;

/**
 * The Module class represents an educational module in the system.
 * It contains properties such as the name of the module, the credit value,
 * information about the module, and the date associated with the module.
 * The class also provides getters and setters for these properties.
 * copyright  : Copyright (c) 2023/5/26
 * @author Zhongxu Si, Hanyu Wu
 * @version 5.0
 */
public class Module {
    protected  String module_name;
    protected  int module_credit;
    protected  String module_info;
    protected Date time = new Date();
    protected String date;

    /**
     * Default constructor of Module.
     */
    public Module() {
    }

    /**
     * Construct a new Module object with specific details.
     *
     * @param name The name of the module.
     * @param info Information about the module.
     * @param date The date associated with the module.
     * @param credit The credit value of the module.
     */
    public Module(String name, String info, String date, int credit){
        this.date = date;
        this.module_name = name;
        this.module_info = info;
        this.module_credit = credit;
    }

    public int getModule_credit() {
        return module_credit;
    }

    public void setModule_credit(int module_credit) {
        this.module_credit = module_credit;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getModule_info() {
        return module_info;
    }

    public void setModule_info(String module_info) {
        this.module_info = module_info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
