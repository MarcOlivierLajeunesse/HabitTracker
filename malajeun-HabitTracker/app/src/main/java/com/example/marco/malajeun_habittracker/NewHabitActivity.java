package com.example.marco.malajeun_habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewHabitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_habit);

        Button addHabit = (Button) findViewById(R.id.addHabitButton);
        addHabit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(NewHabitActivity.this, "new habit", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
