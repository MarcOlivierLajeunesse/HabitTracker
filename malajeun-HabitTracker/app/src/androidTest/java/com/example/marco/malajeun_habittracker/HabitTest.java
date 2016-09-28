package com.example.marco.malajeun_habittracker;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;

/**
 * Created by Marco on 27-Sep-2016.
 */
public class HabitTest extends ActivityInstrumentationTestCase2 {

    public HabitTest(){
        super(MainActivity.class);
    }

    public void testHabitName(){
        Habit habit = new Habit();

        String name = "a habit name";
        habit.setName(name);
        assertTrue(name.equals(habit.getName()));
    }

    public void testHabitDate(){
        Habit habit = new Habit();
        Date aDate = new Date();
        habit.setDate(aDate);
        assertTrue(aDate.equals(habit.getDate()));
    }
}
