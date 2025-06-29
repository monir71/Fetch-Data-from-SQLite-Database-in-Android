package com.example.sqlitedatafetch;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        /* Data Insertion
        try {
            MyDBHelper myContactDB = new MyDBHelper(this);
            myContactDB.addContact("Md Moniruzzaman", "01710389323");
            myContactDB.addContact("Md Rokonuzzaman", "01724035774");
            myContactDB.addContact("Taosif Monir Taquii", "01740193069");

        } catch (Exception e)
        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
        */

        try {
            MyDBHelper dbHelper = new MyDBHelper(this);
            ArrayList<MyDBModel> data = dbHelper.fetchData();
            for (int i = 0; i < data.size(); i++)
            {
                Log.d("Database Info: ", "ID: " + data.get(i).id + ", Name: " + data.get(i).name + ", Phone Number: " + data.get(i).contact_no);
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}