package com.example.marco.malajeun_habittracker;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public void testViewCompleted(){
        Habit habit = new Habit();
        //List<Date> list = new ArrayList<>();

        //assertEquals(list, habit.viewCompleted());
        assertTrue(habit.getCount() == 0);

        CompletedList cList = habit.viewCompleted();
        assertTrue(cList.size() == 0);

        habit.complete();
        assertTrue(habit.getCount() == 1);
        cList = habit.viewCompleted();
        assertTrue(cList.size() == 1);

        habit.complete();
        assertTrue(habit.getCount() == 2);
        cList = habit.viewCompleted();
        assertTrue(cList.size() == 2);
    }

    public void testDeleteHistory(){
        Habit habit = new Habit();
        habit.complete();
        assertTrue(habit.getCount() == 1);
        CompletedList list = habit.viewCompleted();
        assertTrue(list.size() == 1);

        list.delete(0);
        assertTrue(list.size() == 0);
        assertTrue(habit.getCount() == 0);
    }
}
