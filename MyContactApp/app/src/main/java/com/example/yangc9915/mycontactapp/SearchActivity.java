package com.example.yangc9915.mycontactapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class SearchActivity extends MainActivity {

    DatabaseHelper myDb;
    EditText search;

    Intent intent = getIntent();
    String data = intent.getStringExtra("data");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        myDb = super.myDb;
        search = (EditText) findViewById(R.id.editText_search);



    }

    public void searchData(View v){
        super.searchData(v);
    }

    public void home (View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }





}
