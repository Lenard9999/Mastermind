package com.example.mastermind;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GameView gameView;//extends SurfaceView
    FrameLayout game;// Sort of "holder" for everything we are placing
    RelativeLayout GameButtons;//Holder for the buttons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        gameView = new GameView(this);
        game = new FrameLayout(this);
        GameButtons = new RelativeLayout(this);

        Button btnGuess = new Button(this);
        btnGuess.setText("Guess");
        btnGuess.setId(123456);

        btnGuess.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean decision = gameView.checkCorrect();

                if(decision){
                    Toast.makeText(MainActivity.this, "TAMA", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(MainActivity.this, "MALI", Toast.LENGTH_LONG).show();
                }

            }
        });

        RelativeLayout.LayoutParams b1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT);
        GameButtons.setLayoutParams(params);

        GameButtons.addView(btnGuess);
        b1.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        btnGuess.setLayoutParams(b1);

        game.addView(gameView);
        game.addView(GameButtons);

        super.onCreate(savedInstanceState);
        setContentView(game);
    }
}
