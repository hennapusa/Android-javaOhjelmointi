package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;
public class Guess extends AppCompatActivity {
    private ImageButton game_Button1;
    private ImageButton game_Button2;
    private ImageButton game_Button3;
    private ImageButton game_Button4;
    private FloatingActionButton restartBtn;

    public class generateRandom {

        public void main(String args[]) {
            //satunnaisluku?
            Random rand = new Random();
            int rand_int1 = rand.nextInt(5);
            System.out.println("Random Integers: " + rand_int1);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        game_Button1 = findViewById(R.id.imageButton1);
        game_Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {handleClickEvents(view);}
        });

        game_Button2 = findViewById(R.id.imageButton3);
        game_Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {handleClickEvents(view);}
        });
        game_Button3 = findViewById(R.id.imageButton3);
        game_Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {handleClickEvents(view);}
        });
        game_Button4 = findViewById(R.id.imageButton4);
        game_Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {handleClickEvents(view);}
        });

        restartBtn = findViewById(R.id.restart_btn);
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { handleClickEvents(view);

            }
        });
    }
    public void handleClickEvents(View view){
        switch (view.getId()){
            case R.id.imageButton1:
                game_Button1.setVisibility(View.INVISIBLE);
                break;

            case R.id.imageButton2:
                game_Button2.setVisibility(View.INVISIBLE);
                break;

            case R.id.imageButton3:
                game_Button3.setVisibility(View.INVISIBLE);
                break;

            case R.id.imageButton4:
                game_Button4.setVisibility(View.INVISIBLE);
                break;

            case R.id.restart_btn:
                finish();
                overridePendingTransition(0,0);
                startActivity(getIntent());
                overridePendingTransition(0,0);

            default:

        }

    }
}