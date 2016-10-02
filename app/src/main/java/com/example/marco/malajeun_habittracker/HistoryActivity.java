package com.example.marco.malajeun_habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private ListView historyListV;
    private TextView titleText;
    private ArrayAdapter<Date> adapter;

    private HabitListController hlc = new HabitListController(); // controller for habit list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        titleText = (TextView) findViewById(R.id.textHabitHistory);
        // set Habit Name
        titleText.setText(hlc.getCurrentHabitName() + "has been completed on");

        historyListV = (ListView) findViewById(R.id.historyListView);

        registerForContextMenu(historyListV); // allows for context menu

        List<Date> hList = hlc.getHistory().getCompleted();
        adapter = new ArrayAdapter<Date>(this, R.layout.history_list_item, hList);
        historyListV.setAdapter(adapter);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.history_context_menu, menu);
    }

    @Override
    //context menu
    public boolean onContextItemSelected(MenuItem item){
        HabitListController hlc = new HabitListController(); // controller for habit list

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        //delete button
        switch (item.getItemId()){
            case R.id.historyMenueDelete:
                Toast.makeText(HistoryActivity.this, "record deleted", Toast.LENGTH_SHORT).show();
                hlc.deleteCompleted(info.id);
//                hlc.saveInFile(this);
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
