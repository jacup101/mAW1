package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.RenderScript;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //define variables outside of methods
    private Button button_hi;
    private int number = 0;
    private TextView textView_count;
    private int numTries = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // part of the android lifecycle
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //links the activity to the xml layout called activity_main

        // look up the button by its id

        button_hi = findViewById(R.id.button_hello);
        textView_count = findViewById(R.id.textView_count);
        // create logs to keep track of errors
        Log.d("MainActivity","I was not able to see the toast when clicking the button");
        //tag -> location where this is found
        //msg -> actual log information of what happened
        // add an event listener to listen for the click
        button_hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handle what happens after I click
                sayHello(v);
            }
        });

        // when click happens, I do something
    }
    private void sayHello(View view) {
        //create a toast with a message saying hello
        Toast toast = Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);
        // short -> 2 seconds?
        //long -> something longer than short lol
        toast.show();
    }
    public void countUp(View view) {
        //increment the value and display in the text view
        //set the text of the text view to the number
        number++;
        numTries = 0;
        //when you see an object, you want to check to make sure its not null
        if(textView_count != null) textView_count.setText(Integer.toString(number)); //setText takes a String

    }
    public void countDown(View view) {
        //increment the value and display in the text view
        //set the text of the text view to the number
        //Log.d("CountDown","Counting Down!");
        if(number > 0) {
            number--;
            if(textView_count != null) textView_count.setText(Integer.toString(number)); //setText takes a String
        } else {

            numTries ++;
            if(numTries == 5) {
                Toast toast = Toast.makeText(this,R.string.count_warning,Toast.LENGTH_SHORT);
                toast.show();
            } if(numTries == 20) {
                Toast toast = Toast.makeText(this,R.string.suicide_warning,Toast.LENGTH_SHORT);
                toast.show();
            }if(numTries > 25) {
                finish();
                System.exit(0);
            }
        }
        //when you see an object, you want to check to make sure its not null


    }
}