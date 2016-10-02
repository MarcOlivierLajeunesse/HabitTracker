package com.example.marco.malajeun_habittracker;

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

        //add habit
        Button addHabit = (Button) findViewById(R.id.addHabitButton);
        addHabit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                hlc.add(textName.getText().toString(), textDate.getText().toString(), days);
                Toast.makeText(NewHabitActivity.this, "Habit Added", Toast.LENGTH_SHORT).show();

                //reset fields
                textDate.setText(resetDate());
                textName.setText("");
                resetCheckBoxes();
                days = new ArrayList<String>(); // empty day list
            }
        });
    }

    // based on code from https://developer.android.com/guide/topics/ui/controls/checkbox.html
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        NewHabitController nhc = new NewHabitController();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBoxMonday:
                nhc.isChecked(checked, days, "Monday");
                break;
            case R.id.checkBoxTuesday:
                nhc.isChecked(checked, days, "Tuesday");
                break;
            case R.id.checkBoxWednesday:
                nhc.isChecked(checked, days, "Wednesday");
                break;
            case R.id.checkBoxThursday:
                nhc.isChecked(checked, days, "Thursday");
                break;
            case R.id.checkBoxFriday:
                nhc.isChecked(checked, days, "Friday");
                break;
            case R.id.checkBoxSaturday:
                nhc.isChecked(checked, days, "Saturday");
                break;
            case R.id.checkBoxSunday:
                nhc.isChecked(checked, days, "Sunday");
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

    private void resetCheckBoxes(){
        CheckBox Mon = (CheckBox)findViewById(R.id.checkBoxMonday);
        CheckBox Tue = (CheckBox)findViewById(R.id.checkBoxTuesday);
        CheckBox Wed = (CheckBox)findViewById(R.id.checkBoxWednesday);
        CheckBox Thu = (CheckBox)findViewById(R.id.checkBoxThursday);
        CheckBox Fri = (CheckBox)findViewById(R.id.checkBoxFriday);
        CheckBox Sat = (CheckBox)findViewById(R.id.checkBoxSaturday);
        CheckBox Sun = (CheckBox)findViewById(R.id.checkBoxSunday);

        NewHabitController nhc = new NewHabitController();
        nhc.resetCheckBoxes(Mon);
        nhc.resetCheckBoxes(Tue);
        nhc.resetCheckBoxes(Wed);
        nhc.resetCheckBoxes(Thu);
        nhc.resetCheckBoxes(Fri);
        nhc.resetCheckBoxes(Sat);
        nhc.resetCheckBoxes(Sun);

    }

}
