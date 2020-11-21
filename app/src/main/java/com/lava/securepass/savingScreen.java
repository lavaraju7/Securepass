package com.lava.securepass;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.snackbar.Snackbar;


public class savingScreen extends AppCompatActivity {
    public String website_name,user_name;
    public EditText user_name1;
    public Button save_button;
    GridLayout grid;
    TextView text3,endnote;
    protected ImageButton inst,facebook,amazon,twitter,gmail,pinterest,steam,linkedin,spotify;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getIntent();
        setContentView(R.layout.saving_screen);
        inst = findViewById(R.id.insta_button);
        facebook = findViewById(R.id.fb_button);
        amazon = findViewById(R.id.amazon_button);
        twitter = findViewById(R.id.twitter_button);
        gmail = findViewById(R.id.gmail_button);
        pinterest = findViewById(R.id.pin_button);
        steam = findViewById(R.id.steam_button);
        linkedin = findViewById(R.id.linkedin_button);
        spotify = findViewById(R.id.spot_button);
        grid = findViewById(R.id.grid1);
        text3 = findViewById(R.id.textview3);
        endnote = findViewById(R.id.endnote);
        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                website_name=getString(R.string.Insta);
                user_name1 = findViewById(R.id.user_name);
                save_button.setVisibility(View.VISIBLE);
                grid.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);
                user_name1.setVisibility(View.VISIBLE);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                website_name=getString(R.string.Fb);
                user_name1 = findViewById(R.id.user_name);
                save_button.setVisibility(View.VISIBLE);
                grid.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);
                user_name1.setVisibility(View.VISIBLE);
            }
        });
        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                website_name=getString(R.string.Amazon);
                user_name1 = findViewById(R.id.user_name);
                save_button.setVisibility(View.VISIBLE);
                grid.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);
                user_name1.setVisibility(View.VISIBLE);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                website_name=getString(R.string.Twitter);
                user_name1 = findViewById(R.id.user_name);
                user_name1.setVisibility(View.VISIBLE);
                grid.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);
                save_button.setVisibility(View.VISIBLE);
            }
        });
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                website_name=getString(R.string.Gmail);
                user_name1 = findViewById(R.id.user_name);
                save_button.setVisibility(View.VISIBLE);
                grid.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);
                user_name1.setVisibility(View.VISIBLE);
            }
        });
        pinterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                website_name=getString(R.string.Pinterest);
                user_name1 = findViewById(R.id.user_name);
                save_button.setVisibility(View.VISIBLE);
                grid.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);
                user_name1.setVisibility(View.VISIBLE);
            }
        });
        steam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                website_name=getString(R.string.Steam);
                user_name1 = findViewById(R.id.user_name);
                save_button.setVisibility(View.VISIBLE);
                grid.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);
                user_name1.setVisibility(View.VISIBLE);
            }
        });
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                website_name=getString(R.string.Link);
                user_name1 = findViewById(R.id.user_name);
                save_button.setVisibility(View.VISIBLE);
                grid.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);
                user_name1.setVisibility(View.VISIBLE);
            }
        });
        spotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                website_name=getString(R.string.Spot);
                user_name1 = findViewById(R.id.user_name);
                save_button.setVisibility(View.VISIBLE);
                grid.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);
                user_name1.setVisibility(View.VISIBLE);
            }
        });
        save_button = findViewById(R.id.save_button);
            save_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(TextUtils.isEmpty(user_name1.getText().toString())){
                        Snackbar.make(view,"Enter the username",Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                    else {
                        DataBase mydatabase = new DataBase(savingScreen.this);
                        user_name = user_name1.getText().toString();
                        user_name1.setVisibility(View.GONE);
                        save_button.setVisibility(View.GONE);
                        endnote.setVisibility(View.VISIBLE);
                        mydatabase.addPassword(website_name,user_name,MainActivity.string);
                    }
                }
            });
        }
}