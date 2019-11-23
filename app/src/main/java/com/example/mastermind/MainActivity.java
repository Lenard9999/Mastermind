package com.example.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final GameView game = new GameView(this);

        Button btnGuess = new Button(this);
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(game.c)
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(game);
    }
}
