package com.example.yangc9915.mycontactapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SearchActivity extends MainActivity {

    DatabaseHelper myDb;
    EditText search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        myDb = super.myDb;
        search = (EditText) findViewById(R.id.editText_search);

        Intent i = getIntent();



    }

    public void view2Data(View v){
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0){
            showMessage("Error", "No data found in database");

            //put a Log.d message and toast
            Log.d("My Contact", "No data found in database");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        //setup loop with cursor moveToNext method
        //      append each COL to buffer
        //      use getString method
        if (res != null){
            res.moveToFirst();
            for (int i=0; i<res.getCount(); i++){
                for (int j=0; j<res.getColumnCount(); j++){
                    buffer.append(res.getString(j) +  "\n");
                }
                buffer.append("\n");
                res.moveToNext();
            }
            res.close();
        }

        showMessage("Data", buffer.toString());

    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true); //cancel using back button
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }


    public void search2Data(View v){
        Cursor res = myDb.getAllData();
        StringBuffer bufferSearch = new StringBuffer();
        int count = 0;

        if(res != null){
            res.moveToFirst();
            for (int i=0; i<res.getCount(); i++) {
                for (int j = 0; j < res.getColumnCount(); j++) {
                    if (res.getString(j).equals(search.getText().toString())) {
                        bufferSearch.append(res.getString(j) + "\n" +res.getString(j+1) + "\n" + res.getString(j+2) + "\n");
                        count++;
                    }
                }
                bufferSearch.append("\n");
                res.moveToNext();
            }
            res.close();
        }
        if (count != 0){
            showMessage("Search", bufferSearch.toString());
        }
        else{
            showMessage("Search", "No data found");
        }

        search.setText("");
    }

    public void home (View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }





}
