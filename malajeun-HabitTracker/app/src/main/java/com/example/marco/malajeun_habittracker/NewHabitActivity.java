package com.example.marco.malajeun_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewHabitActivity extends AppCompatActivity {

    private EditText textDate;
    private EditText textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_habit);

        textDate = (EditText) findViewById(R.id.editDate);
        textName = (EditText) findViewById(R.id.editName);

        textDate.setText(resetDate()); // set default date

        Button addHabit = (Button) findViewById(R.id.addHabitButton);
        addHabit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //EditText textName = (EditText) findViewById(R.id.editName);
                //EditText dateName = (EditText) findViewById(R.id.editDate);
                HabitListController hlc = new HabitListController();
                hlc.add(textName.getText().toString(), textDate.getText().toString());
                Toast.makeText(NewHabitActivity.this, "Habit Added", Toast.LENGTH_SHORT).show();

                //reset fields
                textDate.setText(resetDate());
                textName.setText("");

                //Intent intent = new Intent(NewHabitActivity.this, MainActivity.class);

                //startActivity(intent);
            }
        });
    }

    private String resetDate(){
        //converts string to date
        Date currentDate = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        String dString = df.format(currentDate);
        return dString;
    }

}
