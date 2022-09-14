package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
public class Guess extends AppCompatActivity {
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;

    public class generateRandom {

        public void main(String args[]) {
            //satunnaisluku?
            Random rand = new Random();
            int rand_int1 = rand.nextInt(5);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);


    }
}