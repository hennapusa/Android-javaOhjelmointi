package com.example.myapplication;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class Guess extends AppCompatActivity {
    private ImageButton game_Button1;
    private ImageButton game_Button2;
    private ImageButton game_Button3;
    private ImageButton game_Button4;
    private FloatingActionButton restartBtn;
    int rand_int1;
    Animation animation;
    int bestScore;
    private static final String KEY_HS = "HighestScore: ";
    private static final String TAG = "MyMessage";
    SharedPreferences myPreferences;
    private TextView scoreText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        //animaatio
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation1);
        ImageView image = (ImageView) findViewById(R.id.imageButton1);

        //satunnaisluku
        Random rand = new Random();
        rand_int1 = rand.nextInt(3)+1;
        //sisäinen tallennus
        myPreferences = PreferenceManager.getDefaultSharedPreferences(Guess.this);
        bestScore = myPreferences.getInt(KEY_HS, 0);
        scoreText = findViewById(R.id.scoreBox);
        scoreText.setText(this.getString(R.string.MyScore) +" : "+ bestScore);


        game_Button1 = findViewById(R.id.imageButton1);
        game_Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);

            }
        });

        game_Button2 = findViewById(R.id.imageButton2);
        game_Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });
        game_Button3 = findViewById(R.id.imageButton3);
        game_Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });
        game_Button4 = findViewById(R.id.imageButton4);
        game_Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });

        restartBtn = findViewById(R.id.restart_btn);
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);

            }

        });

    }

    public void handleClickEvents(View view) {
        switch (view.getId()) {
            case R.id.imageButton1:
                game_Button1.setVisibility(View.INVISIBLE);
                game_Button1.startAnimation((animation));
                if (rand_int1 == 1) {
                    game_Button1.setImageResource(R.mipmap.star);
                    game_Button1.setBackgroundColor(Color.YELLOW);
                    game_Button1.setVisibility(View.VISIBLE);
                    game_Button2.setVisibility(View.INVISIBLE);
                    game_Button3.setVisibility(View.INVISIBLE);
                    game_Button4.setVisibility(View.INVISIBLE);
                    bestScore = bestScore+1;
                    scoreText.setText(this.getString(R.string.MyScore) +" : "+ bestScore);
                    SharedPreferences.Editor myEditor = myPreferences.edit();
                    myEditor.putInt(KEY_HS, bestScore);
                    myEditor.commit();
                }
                break;

            case R.id.imageButton2:
                game_Button2.setVisibility(View.INVISIBLE);
                game_Button2.startAnimation((animation));
                if(rand_int1 ==2){
                    game_Button2.setImageResource(R.mipmap.star);
                    game_Button2.setBackgroundColor(Color.YELLOW);
                    game_Button2.setVisibility(View.VISIBLE);
                    game_Button1.setVisibility(View.INVISIBLE);
                    game_Button3.setVisibility(View.INVISIBLE);
                    game_Button4.setVisibility(View.INVISIBLE);
                    bestScore = bestScore+1;
                    scoreText.setText(this.getString(R.string.MyScore) +" : "+ bestScore);
                    SharedPreferences.Editor myEditor = myPreferences.edit();
                    myEditor.putInt(KEY_HS, bestScore);
                    myEditor.commit();
                }

                break;

            case R.id.imageButton3:
                game_Button3.setVisibility(View.INVISIBLE);
                game_Button3.startAnimation((animation));
                if(rand_int1 ==3){
                    game_Button3.setImageResource(R.mipmap.star);
                    game_Button3.setBackgroundColor(Color.YELLOW);
                    game_Button3.setVisibility(View.VISIBLE);
                    game_Button1.setVisibility(View.INVISIBLE);
                    game_Button2.setVisibility(View.INVISIBLE);
                    game_Button4.setVisibility(View.INVISIBLE);
                    bestScore = bestScore+1;
                    scoreText.setText(this.getString(R.string.MyScore) +" : "+ bestScore);
                    SharedPreferences.Editor myEditor = myPreferences.edit();
                    myEditor.putInt(KEY_HS, bestScore);
                    myEditor.commit();
                }
                break;

            case R.id.imageButton4:
                game_Button4.setVisibility(View.INVISIBLE);
                game_Button4.startAnimation((animation));
                if(rand_int1 ==4){
                    game_Button4.setImageResource(R.mipmap.star);
                    game_Button4.setBackgroundColor(Color.YELLOW);
                    game_Button4.setVisibility(View.VISIBLE);
                    game_Button1.setVisibility(View.INVISIBLE);
                    game_Button2.setVisibility(View.INVISIBLE);
                    game_Button3.setVisibility(View.INVISIBLE);
                    bestScore = bestScore+1;
                    scoreText.setText(this.getString(R.string.MyScore) +" : "+ bestScore);
                    SharedPreferences.Editor myEditor = myPreferences.edit();
                    myEditor.putInt(KEY_HS, bestScore);
                    myEditor.commit();
                }
                break;

            case R.id.restart_btn:
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);


            default:

        }

    }

}
