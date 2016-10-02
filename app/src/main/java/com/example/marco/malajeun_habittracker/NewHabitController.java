package com.example.marco.malajeun_habittracker;

import android.widget.CheckBox;

import java.util.List;

/**
 * Created by Marco on 01-Oct-2016.
 */
public class NewHabitController {

    //not a true controller, but a helper class for NewHabitActivity

    public static void resetCheckBoxes(CheckBox check){
        // based on code from http://stackoverflow.com/questions/13377904/how-to-clear-checkboxes-when-reset-button-is-clicked
        if(check.isChecked()){
            check.setChecked(false);
        }
    }

    public static void isChecked(boolean checked, List<String> days, String day){
        // based on code from http://stackoverflow.com/questions/13377904/how-to-clear-checkboxes-when-reset-button-is-clicked
        if (checked){
            days.add(day);
        } else{
            if(days.contains(day)){
                days.remove(day);
            }
        }
    }
}
