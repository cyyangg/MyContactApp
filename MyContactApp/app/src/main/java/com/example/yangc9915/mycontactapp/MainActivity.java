package com.example.yangc9915.mycontactapp;

import android.database.Cursor;
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
        boolean isInsertedName = myDb.insertData(editName.getText().toString(),
                editAge.getText().toString(), editPhoneNum.getText().toString());

        if(isInsertedName == true){
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

    public void viewData(View v){
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0){
            showMessage("Error", "No data found in database");

            //put a Log.d message and toast
            Log.d("My Contact", "No data found in database");
            Toast.makeText(getApplicationContext(), "No data found in database", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuffer buffer = new StringBuffer();
        //setup loop with cursor moveToNext method
        //      append each COL to buffer
        //      use getString method
        while (res != null){
            res.moveToFirst();
            for (int i=0; i<res.getCount(); i++){
                for (int j=0; j<res.getColumnCount(); j++){
                    buffer.append(res.getString(j) + "|");
                }
                buffer.append("\n");
                res.moveToNext();
            }
            res.close();
        }

        showMessage("Data", buffer.toString());

    }

    private void showMessage(String title, String message) {

    }
}
