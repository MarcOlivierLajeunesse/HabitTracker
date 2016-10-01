package com.example.marco.malajeun_habittracker;


import java.util.Date;

/**
 * Created by Marco on 27-Sep-2016.
 */
public class Habit{
    //Attributes
    private String habitName;
    private Date date;
    private int completeCount;
    private CompletedList completed;
    private Boolean isComplete;



    //Constructor
    public Habit(){
        this.completeCount = 0;
        this.completed = new CompletedList();
        //this.date = new Date();
        this.isComplete = false;
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
        isComplete = true;
    }

    public CompletedList viewCompleted(){
        //return completed.getCompleted();
        return completed;
    }

    public int getCount(){
        return completed.size();
    }

    public void updateCount(){
        completeCount = completed.size();
    }

    private String completionStatus(){
        if(isComplete){
            return "completed for the day";
        } else{
            return "inclompleted";
        }
    }

    public void resetCompletionStatus(){
        //called at midnight of everyday
        isComplete = false;
    }

    @Override
    public String toString(){
        return habitName +"\n" + completionStatus();

    }
}
