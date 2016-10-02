package com.example.marco.malajeun_habittracker;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * Created by Marco on 27-Sep-2016.
 */
public class HabitListTest extends ActivityInstrumentationTestCase2 {

    public HabitListTest(){
        super(MainActivity.class);
    }

    public void testHabitList(){
        HabitList hList = new HabitList();

        assertTrue(hList.size() == 0);
    }

    public void testAddHabitList(){
        HabitList hList = new HabitList();

        Habit habit = new Habit();
        String habName = "habit a";
        habit.setName(habName);

        hList.add(habit);

        assertTrue(hList.hasHabit(habit));
    }

//    public void testGetHabit(){
//        HabitList hList = new HabitList();
//
//        Habit habit = new Habit();
//        String habName = "habit a";
//        habit.setName(habName);
//
//        hList.add(habit);
//
//        assertEquals(habit, hList.getHabit(habit));
//
//    }

    public void getHabitByIndex(){
        HabitList hList = new HabitList();

        Habit habit = new Habit();
        String habName = "habit a";
        habit.setName(habName);

        hList.add(habit);

        assertEquals(habit, hList.getHabitByIndex(0));
    }

//    public void getHabitByName(){
//        HabitList hList = new HabitList();
//
//        Habit a = new Habit();
//        Habit b = new Habit();
//        String habName = "habit a";
//        String habNameB = "habit b";
//        String habNameC = " habbit c";
//        a.setName(habName);
//        b.setName(habNameB);
//
//        hList.add(a);
//        hList.add(b);
//
//        assertEquals(a, hList.getHabitByName(habName));
//        assertFalse(a == hList.getHabitByName(habNameB));
//
//        try{
//            Habit c = hList.getHabitByName(habNameC);
//            fail();
//        } catch(NoSuchElementException e){
//
//        }
//    }

//    public void testDeleteHabit(){
//        HabitList hList = new HabitList();
//
//        Habit a = new Habit();
//        String habName = "habit a";
//        a.setName(habName);
//
//        hList.add(a);
//        assertTrue(hList.hasHabit(a));
//
//        hList.deleteHabit(a);
//        assertFalse(hList.hasHabit(a));
//
//        assertTrue(hList.size() == 0);
//    }

    public void testDeleteHabitByIndex(){
        HabitList hList = new HabitList();

        Habit a = new Habit();
        String habName = "habit a";
        a.setName(habName);

        hList.add(a);
        assertTrue(hList.hasHabit(a));

        hList.deleteHabitByIndex(0);
        assertFalse(hList.hasHabit(a));

        assertTrue(hList.size() == 0);
    }

    public void testGetHabits(){
        HabitList hList = new HabitList();

        Habit a = new Habit();
        Habit b = new Habit();
        String habName = "habit a";
        String habNameB = "habit b";
        a.setName(habName);
        b.setName(habNameB);

        hList.add(a);
        hList.add(b);

        List<Habit> list = new ArrayList<Habit>();
        list.add(a);
        list.add(b);

        assertEquals(list, hList.getHabits());

    }
}
