package com.lava.securepass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Updateactivity extends AppCompatActivity {
    EditText username_input,password_input,website_input;
    Button delete_button;
    String id,website,password,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateactivity);
        username_input = findViewById(R.id.user_name1);
        password_input=findViewById(R.id.password1);
        website_input=findViewById(R.id.website1);
        delete_button = findViewById(R.id.delete_button1);
        getIntentData();
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBase myDB = new DataBase(Updateactivity.this);
                myDB.delete(id);
                finish();
            }
        });
    }

    void getIntentData() {

        if (getIntent().hasExtra("id") && getIntent().hasExtra("website") && getIntent().hasExtra("username") && getIntent().hasExtra("password")) {
            id = getIntent().getStringExtra("id");
            website = getIntent().getStringExtra("website");
            username = getIntent().getStringExtra("username");
            password = getIntent().getStringExtra("password");

            username_input.setText(username);
            password_input.setText(password);
            website_input.setText(website);

        }
        else{
            Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
        }
    }
}