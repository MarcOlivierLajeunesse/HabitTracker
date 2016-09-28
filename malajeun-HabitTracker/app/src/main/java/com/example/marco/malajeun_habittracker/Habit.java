package com.example.marco.malajeun_habittracker;

import java.util.Date;

/**
 * Created by Marco on 27-Sep-2016.
 */
public class Habit {
    private String habitName;
    private Date date;


    public void setName(String name) {
        this.habitName = name;
    }

    public String getName() {
        return habitName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
