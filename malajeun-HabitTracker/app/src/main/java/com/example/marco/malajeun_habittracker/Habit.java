package com.example.marco.malajeun_habittracker;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Marco on 27-Sep-2016.
 */
public class Habit{
    //Attributes
    private String habitName;
    private Date date;
    private CompletedList completed;
    private Boolean isComplete;
    private List<String> days; //days of the week that the habit will be completed

    //Constructor
    public Habit() {
        this.completed = new CompletedList();
        this.isComplete = false;
    }

    //Methods
    public void setName(String name) {
        habitName = name;
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
        isComplete = true;
    }

    public CompletedList viewCompleted(){
        return completed;
    }

    public int getCount(){
        return completed.size();
    }

    private String completionStatus(){
        if (completed.size() == 0){
            //if the completion history is deleted, then the habit is marked as incomplete
            isComplete = false;
        }
        if(isComplete){
            return "completed for the day";
        } else{
            return "inclompleted";
        }
    }


    public void setDays(List<String> dayList){
        // set days of the week that the habit will be completed
        days = dayList;
    }

    public List getDays(){
        // return days of the week that the habit will be completed
        return days;
    }

    @Override
    public String toString(){
        return habitName +"\n" + completionStatus();

    }
}
