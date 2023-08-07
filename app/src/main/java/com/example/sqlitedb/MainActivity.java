package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // for DB Table calling , we have to get object of the MyDBHelper Class

        try (MyDBHelper dbHelper = new MyDBHelper(getApplicationContext())) {
            dbHelper.addContact("RAMen","54661131566");
            dbHelper.addContact("AMen","851131566");
            dbHelper.addContact("Men","622661131566");
            dbHelper.addContact("en","545561131566");
            dbHelper.addContact("RAn","001221566");
            dbHelper.addContact("RAen","5467864131566");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}