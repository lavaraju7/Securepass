package com.lava.securepass;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText characters;
    private TextView textview;
    public static String string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        characters = findViewById(R.id.editText);
        textview = findViewById(R.id.password);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(characters.getText().toString())){
                    Snackbar.make(view,"Enter a number or password",Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else {
                    if (TextUtils.isDigitsOnly(characters.getText().toString()) && Integer.parseInt(characters.getText().toString()) >= 8 && Integer.parseInt(characters.getText().toString()) <= 16) {
                        char[] password = password(Integer.parseInt(characters.getText().toString()));
                        string = new String(password);
                        Snackbar.make(view,"Your Secure Password is here",Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                    else string = characters.getText().toString();
                    textview.setText(string);
                    characters.getText().clear();
                }

            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sScreen = new Intent(MainActivity.this,savingScreen.class);
                startActivity(sScreen);
            }
        });
    }
    public char[] password(int size_of_password) {
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "(!@#$%^&*_=+-/?<>)";

        String values = Capital_chars + Small_chars +
                numbers + symbols;

        Random rndm_method = new Random();
            char[] password1 = new char[size_of_password];

            password1[0] = Capital_chars.charAt(rndm_method.nextInt(Capital_chars.length()));
            for (int i = 1; i < size_of_password-2; i++) {
                password1[i] =
                        values.charAt(rndm_method.nextInt(values.length()));

            }
            password1[size_of_password-1] = symbols.charAt(rndm_method.nextInt(symbols.length()));
            password1[size_of_password-2] = numbers.charAt(rndm_method.nextInt(numbers.length()));
            return password1;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent savedpasswords = new Intent(MainActivity.this,showPasswords.class);
            startActivity(savedpasswords);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
