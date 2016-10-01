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
    private int completeCount;
    private CompletedList completed;
    private Boolean isComplete;
    //private Boolean[] days = new Boolean[7]; // days[0] is monday... days[6] is sunday
    //List<Boolean> days = Arrays.asList(new Boolean[7]);// days[0] is monday... days[6] is sunday
    private List<String> days;

    //Constructor
    public Habit(){
        this.completeCount = 0;
        this.completed = new CompletedList();
        //this.date = new Date();
        this.isComplete = false;
        //Arrays.fill(days, false);
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

    public void resetCompletionStatus(){
        //called at midnight of everyday
        isComplete = false;
    }

//    public void checkDay(String day){
//        //days[i] = true;
//        //days.set(i,true);
//        days.add(day);
//    }
//
//    public void uncheckDay(String day){
//        //days[i] = false;
//        //days.set(i,false);
//        days.remove(day);
//    }
    public void setDays(List<String> dayList){
        days = dayList;
    }

    public List getDays(){
        return days;
    }

    @Override
    public String toString(){
        return habitName +"\n" + completionStatus();

    }
}
