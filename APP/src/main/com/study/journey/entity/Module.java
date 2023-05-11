package com.study.journey.entity;

import java.util.Date;

public class Module {
    protected  String module_name;
    protected  int module_credit;
    protected  String module_info;
    protected Date time = new Date();
    protected String date;

    public Module() {
    }
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
