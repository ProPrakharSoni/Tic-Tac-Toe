package com.myappcompany.proprakhar.conct3game;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int active=0;
    int count=0;
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int[] gameState={2,2,2,2,2,2,2,2,2};
    boolean gameActive=true;
    //0 circle ,1 cross, 2 empty
    MediaPlayer mediaPlayer;
    public void dropin(View view) {

        ImageView counter = (ImageView) view;

        int tappedCounter=Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter]==2&&gameActive) {

            mediaPlayer.start();
            count=count+1;
            gameState[tappedCounter] = active;
            //if(gameState[tappedCounter]==2)
            counter.setTranslationY(-1500);
            if (active == 0) {
                counter.setImageResource(R.drawable.ticcircle);
                active = 1;
            } else {
                counter.setImageResource(R.drawable.cross);
                active = 0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    //someone has win the game
                    String message;
                    if (active == 1)
                        message = "Circle";
                    else
                        message = "Cross";
                   // Toast.makeText(this, message + " wins the game", Toast.LENGTH_SHORT).show();
                 gameActive=false;
                    TextView  textView=(TextView)  findViewById(R.id.textView);
                    Button button=(Button) findViewById(R.id.button);
                     textView.setText(message + " wons the game");
                     textView.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);

                }
                else if (count==9) {
                    gameActive=false;
                    TextView  textView=(TextView)  findViewById(R.id.textView);
                    Button button=(Button) findViewById(R.id.button);
                    textView.setText("Game Draws");
                    textView.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);

                }
            }
        }
    }
    public void playAgain(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        //  textView.setText(message + " wons the game");
        textView.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
       //GridLayout gridLayout =(GridLayout) findViewById(R.id.gridLayout);
        // GridLayout gridLayout =(GridLayout) findViewById(R.id.gridLayout);


       ImageView imageView0 = (ImageView) findViewById(R.id.imageView0);
        imageView0.setImageDrawable(null);
        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView1.setImageDrawable(null);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageDrawable(null);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView3.setImageDrawable(null);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView4.setImageDrawable(null);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView5.setImageDrawable(null);
        ImageView imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView6.setImageDrawable(null);
        ImageView imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView7.setImageDrawable(null);
        ImageView imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView8.setImageDrawable(null);

        active = 0;
        //  gameState={2,2,2,2,2,2,2,2,2};
        for (int i = 0; i < 9; i++) {
            gameState[i] = 2;
        }
        gameActive = true;
        count = 0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(this,R.raw.button);
    }
}
