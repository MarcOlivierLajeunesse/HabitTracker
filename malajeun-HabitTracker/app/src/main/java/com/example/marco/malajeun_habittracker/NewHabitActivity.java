package com.example.marco.malajeun_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewHabitActivity extends AppCompatActivity {
    private List<String> days;

    private EditText textDate;
    private EditText textName;

    HabitListController hlc = new HabitListController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_habit);

        days = new ArrayList<String>();
        textDate = (EditText) findViewById(R.id.editDate);
        textName = (EditText) findViewById(R.id.editName);

        textDate.setText(resetDate()); // set default date

        Button addHabit = (Button) findViewById(R.id.addHabitButton);
        addHabit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //EditText textName = (EditText) findViewById(R.id.editName);
                //EditText dateName = (EditText) findViewById(R.id.editDate);

                hlc.add(textName.getText().toString(), textDate.getText().toString(), days);
                Toast.makeText(NewHabitActivity.this, "Habit Added", Toast.LENGTH_SHORT).show();

                //reset fields
                textDate.setText(resetDate());
                textName.setText("");
                resetCheckBoxes();
                days = new ArrayList<String>(); // empty day list

                //Intent intent = new Intent(NewHabitActivity.this, MainActivity.class);

                //startActivity(intent);
            }
        });
    }

    // from https://developer.android.com/guide/topics/ui/controls/checkbox.html
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBoxMonday:
                if (checked){
                    //hlc.setDay(0);
                    days.add("Monday");
                } else{
                    //hlc.unsetDay(0);
                    if(days.contains("Monday")){
                        days.remove("Monday");
                    }
                }
                break;
            case R.id.checkBoxTuesday:
                if (checked){
                    //hlc.setDay(1);
                    days.add("Tuesday");
                } else{
                    //hlc.unsetDay(1);
                    if(days.contains("Tuesday")){
                        days.remove("Tuesday");
                    }
                }
                break;
            case R.id.checkBoxWednesday:
                if (checked){
                    //hlc.setDay(2);
                    days.add("Wednesday");
                } else{
                    //hlc.unsetDay(2);
                    if(days.contains("Wednesday")){
                        days.remove("Wednesday");
                    }
                }
                break;
            case R.id.checkBoxThursday:
                if (checked){
                    //hlc.setDay(3);
                    days.add("Thursday");
                } else{
                    //hlc.unsetDay(3);
                    if(days.contains("Thursday")){
                        days.remove("Thursday");
                    }
                }
                break;
            case R.id.checkBoxFriday:
                if (checked){
                    //hlc.setDay(4);
                    days.add("Friday");
                } else{
                    //hlc.unsetDay(4);
                    if(days.contains("Friday")){
                        days.remove("Friday");
                    }
                }
                break;
            case R.id.checkBoxSaturday:
                if (checked){
                    //hlc.setDay(5);
                    days.add("Saturday");
                } else{
                    //hlc.unsetDay(5);
                    if(days.contains("Saturday")){
                        days.remove("Saturday");
                    }
                }
                break;
            case R.id.checkBoxSunday:
                if (checked){
                    //hlc.setDay(6);
                    days.add("Sunday");
                } else{
                    //hlc.unsetDay(6);
                    if(days.contains("Sunday")){
                        days.remove("Sunday");
                    }
                }
                break;
        }
    }

    private String resetDate(){
        //converts string to date
        Date currentDate = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        String dString = df.format(currentDate);
        return dString;
    }

    public void resetCheckBoxes(){
        CheckBox Mon = (CheckBox)findViewById(R.id.checkBoxMonday);
        CheckBox Tue = (CheckBox)findViewById(R.id.checkBoxTuesday);
        CheckBox Wed = (CheckBox)findViewById(R.id.checkBoxWednesday);
        CheckBox Thu = (CheckBox)findViewById(R.id.checkBoxThursday);
        CheckBox Fri = (CheckBox)findViewById(R.id.checkBoxFriday);
        CheckBox Sat = (CheckBox)findViewById(R.id.checkBoxSaturday);
        CheckBox Sun = (CheckBox)findViewById(R.id.checkBoxSunday);
        // based on code from http://stackoverflow.com/questions/13377904/how-to-clear-checkboxes-when-reset-button-is-clicked
        if(Mon.isChecked()){
            Mon.setChecked(false);
        }if(Tue.isChecked()){
            Tue.setChecked(false);
        }if(Wed.isChecked()){
            Wed.setChecked(false);
        }if(Thu.isChecked()){
            Thu.setChecked(false);
        }if(Fri.isChecked()){
            Fri.setChecked(false);
        }if(Sat.isChecked()){
            Sat.setChecked(false);
        }if(Sun.isChecked()){
            Sun.setChecked(false);
        }

    }

}
