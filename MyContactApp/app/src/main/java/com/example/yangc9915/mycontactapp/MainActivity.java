package com.example.yangc9915.mycontactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName;
    EditText editAge;
    EditText editPhoneNum;
    Button btnAddData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.editText_name);
        editAge = (EditText) findViewById(R.id.editText_age);
        editPhoneNum = (EditText) findViewById(R.id.editText_phoneNum);
    }

    public void addData(View v) {
        boolean isInsertedName = myDb.insertData(editName.getText().toString());
        boolean isInsertedAge = myDb.insertData(editAge.getText().toString());
        boolean isInsertedPhoneNum = myDb.insertData(editPhoneNum.getText().toString());

        if(isInsertedName == true && isInsertedAge == true && isInsertedPhoneNum == true){
            Log.d("MyContact", "Data insertion successful");
            //create toast message to user indicating data inserted correctly
            Toast.makeText(getApplicationContext(), "Data insertion successful", Toast.LENGTH_SHORT).show();
        }

        else{
            Log.d("MyContact", "Data insertion NOT successful");
            //create toast message to user indicating data inserted incorrectly
            Toast.makeText(getApplicationContext(), "Data insertion NOT successful", Toast.LENGTH_SHORT).show();
        }
    }
}
