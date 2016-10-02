package com.example.marco.malajeun_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HabitInfoActivity extends AppCompatActivity {

    HabitListController hlc = new HabitListController(); // controller for habit list
    private int habitIndex;
    private TextView titleText;
    private TextView countText;
    private ListView daysListV;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habit_info);

        habitIndex = hlc.getCurrentHabitIndex();

        //list view
        daysListV = (ListView) findViewById(R.id.chosenDayList);

        List<String> dayList = hlc.getDays();
        adapter = new ArrayAdapter<String>(this, R.layout.history_list_item, dayList);
        daysListV.setAdapter(adapter);

        //text views
        titleText = (TextView) findViewById(R.id.habitTitle);
        countText = (TextView) findViewById(R.id.textTimeCompleted);
        // set Habit Name
        titleText.setText(hlc.getCurrentHabitName());
        // displays count
        countText.setText("Number of times completed: " + hlc.getCompleteCount());

        //complete button
        Button completeButton = (Button) findViewById(R.id.completeButton);
        completeButton.setOnClickListener(new View.OnClickListener(){
            //complete habit
            public void onClick(View v){
                Toast.makeText(HabitInfoActivity.this, "habit completed", Toast.LENGTH_SHORT).show();
                hlc.complete(habitIndex);
                countText.setText("Number of times completed: " + hlc.getCompleteCount());
            }
        });
        //delete button
        Button deleteButton = (Button) findViewById(R.id.deleteHabitButton);
        deleteButton.setOnClickListener(new View.OnClickListener(){
            //delete habit
            public void onClick(View v){
                Toast.makeText(HabitInfoActivity.this, "habit deleted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HabitInfoActivity.this, MainActivity.class);

                hlc.delete(habitIndex);
                // return to habit list
                startActivity(intent);
                finish(); // prevents going back
            }
        });
        //view history button
        Button historyButton = (Button) findViewById(R.id.viewHistoryButton);
        historyButton.setOnClickListener(new View.OnClickListener(){
            //delete habit
            public void onClick(View v){
                Intent intent = new Intent(HabitInfoActivity.this, HistoryActivity.class);

                // return to habit list
                startActivity(intent);
                finish(); // prevents going back
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        adapter.notifyDataSetChanged();
    }

}
