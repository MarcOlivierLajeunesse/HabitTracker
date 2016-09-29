package com.example.marco.malajeun_habittracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Marco on 27-Sep-2016.
 */
public class Habit {
    //Attributes
    private String habitName;
    private Date date;
    private int completeCount;
    private CompletedList completed;

    //Constructor
    public Habit(){
        completeCount = 0;
        completed = new CompletedList();
    }

    //Methods
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

    public void complete(){
        completed.addCompleted();
        completeCount = completed.size();
    }

    public List viewCompleted(){
        return completed.getCompleted();
    }

    public int getCount(){
        return completed.size();
    }

    public void updateCount(){
        completeCount = completed.size();
    }
}
