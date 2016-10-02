package com.example.marco.malajeun_habittracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Marco on 28-Sep-2016.
 */
public class CompletedList {
    //Attributes
    private List<Date> cHabits = new ArrayList<Date>();

    //Constructor: Default Constructor

    //Methods
    public void addCompleted(Date date){
        //used for testing purposes
        cHabits.add(date);
    }
    public void addCompleted(){
        cHabits.add(new Date());
    }

    public int size(){
        return cHabits.size();
    }

    public Date getDate(int i) {
        return cHabits.get(i);
    }


    public void delete(int i){
        Date date = cHabits.get(i);
        cHabits.remove(date);
    }

    public List getCompleted(){
        return cHabits;
    }

}
