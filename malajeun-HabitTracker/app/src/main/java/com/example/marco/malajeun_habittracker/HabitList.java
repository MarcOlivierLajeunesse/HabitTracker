package com.example.marco.malajeun_habittracker;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Marco on 27-Sep-2016.
 */
public class HabitList {
    List<Habit> habits = new ArrayList<Habit>();
    public void add(Habit habit) {
        habits.add(habit);
    }

    public boolean hasHabit(Habit habit) {
        return habits.contains(habit);
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public Habit getHabit(Habit habit) {
        int index = habits.indexOf(habit);
        return habits.get(index);
    }

    public Habit getHabitByIndex(int i) {
        return habits.get(i);
    }

    public void deleteHabit(Habit habit) {
        habits.remove(habit);
    }

    public Habit getHabitByName(String habName) {
        Habit habit = new Habit();
        for(int i = 0; i < habits.size(); ++i){
            habit = habits.get(i);
            String habitName = habit.getName();
            if(habName == habitName){
                return habit;
            }
        }
        throw new NoSuchElementException("no habbits have that name");
    }
}
