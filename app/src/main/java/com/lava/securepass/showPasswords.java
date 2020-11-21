package com.lava.securepass;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class showPasswords extends AppCompatActivity {
    RecyclerView recyclerView;
    DataBase myDB;
    ArrayList<String> id,website,username,password;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_passwords);

        myDB = new DataBase(showPasswords.this);
        id = new ArrayList<>();
        website = new ArrayList<>();
        username = new ArrayList<>();
        password = new ArrayList<>();
        displayData();
        recyclerView = findViewById(R.id.recyclerview);

        customAdapter = new CustomAdapter(showPasswords.this,this,id,website,username,password);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(showPasswords.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            recreate();
        }
    }

    void displayData(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this,"No Data",Toast.LENGTH_LONG).show();
        }
        else {
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                website.add(cursor.getString(1));
                username.add(cursor.getString(2));
                password.add(cursor.getString(3));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
