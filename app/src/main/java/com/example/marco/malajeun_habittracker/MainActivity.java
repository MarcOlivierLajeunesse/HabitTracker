/*
Habit Tracker: App to keep track of daily habbits
        Copyright (C) 2016  Marc-Olivier Lajeunesse malajeun@ualberta.ca

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.example.marco.malajeun_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import java.util.List;



public class MainActivity extends AppCompatActivity {


    private ListView habitListV;

    private List<Habit> hList;

    private ArrayAdapter<Habit> adapter;

    private HabitListController hlc = new HabitListController(); // controller for habit list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        habitListV = (ListView) findViewById(R.id.habitListView);

        hList = new HabitListController().getHabitList().getHabits();
        adapter = new ArrayAdapter<Habit>(this, R.layout.habit_list_item, hList);
        habitListV.setAdapter(adapter);

        registerForContextMenu(habitListV);// allows for context menu

        Button newHabitButton = (Button) findViewById(R.id.newHabitButton);
        newHabitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, NewHabitActivity.class);
                startActivity(intent);
            }
        });
        habitListV.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                hlc.setCurrentHabitIndex(id);
                Intent intent = new Intent(MainActivity.this, HabitInfoActivity.class);

                startActivity(intent);
            }
        });



    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.habit_context_menu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.habitMenuComplete:
                Toast.makeText(MainActivity.this, "habit completed for the day", Toast.LENGTH_SHORT).show();
                hlc.complete(info.id);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.habitMenueDelete:
                Toast.makeText(MainActivity.this, "habit deleted", Toast.LENGTH_SHORT).show();

                hlc.delete(info.id);
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    @Override
    // from LonelyTwitter
    protected void onStart() {
        super.onStart();
        adapter.notifyDataSetChanged();
    }



}
