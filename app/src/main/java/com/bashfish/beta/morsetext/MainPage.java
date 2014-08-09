package com.bashfish.beta.morsetext;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainPage extends Activity {

    Button button;
    String lastMorseCode;
    String morseString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        addListenerOnButton();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addListenerOnButton() {

        button = (Button) findViewById(R.id.button1);

        /*button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {

                    if(lastMorseCode == "-"){
                        lastMorseCode = "*";
                        return false;
                    }else {
                        lastMorseCode = "*";
                        morseCodeBuilder(lastMorseCode);
                    }
                }
                return true;
            }
        });*/

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(lastMorseCode == "-"){
                    lastMorseCode = "*";

                }else {
                    lastMorseCode = "*";
                    morseCodeBuilder(lastMorseCode);
                }
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View arg0) {

                lastMorseCode = "-";
                morseCodeBuilder(lastMorseCode);

                return true;
            }

        });

    }


    public String morseCodeBuilder(String lastMorseCode) {

        morseString += lastMorseCode;

        Log.d("Morse Code", morseString);

        return morseString;
    }

}
