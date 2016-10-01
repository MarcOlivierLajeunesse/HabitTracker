package com.example.marco.malajeun_habittracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Marco on 28-Sep-2016.
 */
public class CompletedList {
    //Attributes
    private List<Date> cHabits = new ArrayList<Date>();

    //Contructor: Default Constructor

    //Methods
    void addCompleted(Date date){
        cHabits.add(date);
    }
    void addCompleted(){
        cHabits.add(new Date());
    }

    int size(){
        return cHabits.size();
    }

    public Date getDate(int i) {
        return cHabits.get(i);
    }

    void delete(Date date){
        cHabits.remove(date);
    }

    void delete(int i){
        Date date = cHabits.get(i);
        cHabits.remove(date);
    }

    List getCompleted(){
        return cHabits;
    }

//    public String toString(Date aDate){
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
//        String dString = df.format(aDate);
//        return dString;
//    }
}
