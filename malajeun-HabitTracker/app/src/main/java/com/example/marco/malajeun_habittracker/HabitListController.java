package com.example.marco.malajeun_habittracker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Marco on 30-Sep-2016.
 */

//based on studentPicker code from https://www.youtube.com/watch?v=uLnoI7mbuEo&feature=youtu.be
public class HabitListController {

    private static long currentSelected = 0; // index of currently selected habit. long, since id's are long
    private static HabitList habitList = null;


    static public HabitList getHabitList(){
        if (habitList == null){
            habitList = new HabitList();
        }
        return habitList;
    }

    static public void delete(long index){
        habitList.deleteHabitByIndex((int)index);
    }

    static public void complete(long index){
        habitList.completeHabit((int) index);
    }

    static public void add(String name, String dateString){
        //convert dateString from string to date
        //converter based off of code from from http://stackoverflow.com/questions/6510724/how-to-convert-java-string-to-date-object
        DateFormat df = new SimpleDateFormat("yyy-mm-dd");
        Date date = null;
        try{
            date = df.parse(dateString);
        } catch(ParseException e){
        }
        Habit habit = new Habit();
        habit.setName(name);
        habit.setDate(date);
        habitList.add(habit);
    }


    static public void setCurrentHabitIndex(long i){
        currentSelected = i;
    }
    static public int getCurrentHabitIndex(){
        // sets the index of the current habit
        // used to select a habit from MainActivity, and view it using HabitInfoAcitivity
        return (int)currentSelected;
    }
    static public String getCurrentHabitName(){
        // return the name of the currently selected habit
        // used for habit info
        return habitList.getHabitByIndex((int)currentSelected).getName();
    }
    static public int getCompleteCount(){
        //returns the number of times the currently selected habit has been complete
        //used for habit info
        return habitList.getHabitByIndex((int)currentSelected).getCount();
    }
    static public CompletedList getHistory(){
        return habitList.getHabitByIndex((int)currentSelected).viewCompleted();
    }
    static public void deleteCompleted(long id){
        habitList.getHabitByIndex((int)currentSelected).viewCompleted().delete((int) id);
    }
}
