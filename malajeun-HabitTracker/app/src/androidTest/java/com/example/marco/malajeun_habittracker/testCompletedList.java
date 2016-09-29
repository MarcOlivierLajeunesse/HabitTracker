package com.example.marco.malajeun_habittracker;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Marco on 28-Sep-2016.
 */
public class testCompletedList extends ActivityInstrumentationTestCase2 {

    public testCompletedList(){
        super(MainActivity.class);
    }

    public void testCompletedList(){
        CompletedList cList = new CompletedList();

        assertTrue(cList.size() == 0);
    }

    public void testAddCompleDateList(){
        CompletedList cList = new CompletedList();

        Date date = new Date();

        cList.addCompleted(date);

        assertEquals(date, cList.getDate(0));
    }

    public void testAddCompleList(){
        CompletedList cList = new CompletedList();

        cList.addCompleted();

        assertTrue(cList.getDate(0) != null);
    }

    public void testSize(){
        CompletedList cList = new CompletedList();

        Date date1 = new Date();
        Date date2 = new Date();
        Date date3 = new Date();

        assertEquals(0, cList.size());

        cList.addCompleted(date1);
        cList.addCompleted(date2);

        assertEquals(2, cList.size());

        cList.addCompleted();
        cList.addCompleted(date3);
        cList.addCompleted();
        cList.addCompleted();
        cList.addCompleted(new Date());

        assertEquals(7, cList.size());
    }

    public void testDeleteDate(){
        CompletedList cList = new CompletedList();

        Date date1 = new Date();

        assertEquals(0, cList.size());

        cList.addCompleted(date1);
        assertEquals(1, cList.size());

        cList.delete(date1);
        assertEquals(0, cList.size());
    }

    public void testDeleteIndex(){
        CompletedList cList = new CompletedList();

        Date date1 = new Date();

        assertEquals(0, cList.size());

        cList.addCompleted(date1);
        assertEquals(1, cList.size());

        cList.delete(0);
        assertEquals(0, cList.size());
    }

    public void testGetCompleted(){
        CompletedList cList = new CompletedList();

        Date date1 = new Date();
        Date date2 = new Date();
        Date date3 = new Date();

        cList.addCompleted(date1);
        cList.addCompleted(date2);
        cList.addCompleted(date3);

        List<Date> list = new ArrayList<Date>();
        list.add(date1);
        list.add(date2);
        list.add(date3);

        assertEquals(list, cList.getCompleted());
    }
}
