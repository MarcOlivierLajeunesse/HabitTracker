package com.example.marco.malajeun_habittracker;

import org.xml.sax.HandlerBase;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Marco on 27-Sep-2016.
 */
public class HabitList {
    //Attributes
    private List<Habit> habits = new ArrayList<Habit>();

    //Constructor: Default constructor

    //Methods
    public void add(Habit habit) {
        habits.add(habit);
    }

    public Habit getHabitByIndex(int i) {
        return habits.get(i);
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public boolean hasHabit(Habit habit) {
        return habits.contains(habit);
    }

    public void deleteHabitByIndex(int i){
        Habit habit = habits.get(i);
        habits.remove(habit);
    }

    public int size() {
        return habits.size();
    }



    public void completeHabit(int i){
        Habit habit = habits.get(i);
        habit.complete();
    }

}
