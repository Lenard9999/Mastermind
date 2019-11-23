package com.example.mastermind;

import java.util.ArrayList;
import java.util.Collections;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class GameView extends SurfaceView {

    public SurfaceHolder holder;
    public ArrayList<Bitmap> choices = new ArrayList<>();
    public int choiceIndex1 = 0;
    public int choiceIndex2 = 0;
    public int choiceIndex3 = 0;
    public int choiceIndex4 = 0;
    public ArrayList<Integer> randomComb = new ArrayList<>();

    public GameView(Context context){
        super(context);

        holder = getHolder();
        choices.add(scaleDown(BitmapFactory.decodeResource(getResources(), R.drawable.bugs_bunny), 250, true));
        choices.add(scaleDown(BitmapFactory.decodeResource(getResources(), R.drawable.daffy_duck), 250, true));
        choices.add(scaleDown(BitmapFactory.decodeResource(getResources(), R.drawable.coyote), 250, true));
        choices.add(scaleDown(BitmapFactory.decodeResource(getResources(), R.drawable.marvin_martian), 250, true));
        choices.add(scaleDown(BitmapFactory.decodeResource(getResources(), R.drawable.roadrunner), 250, true));
        choices.add(scaleDown(BitmapFactory.decodeResource(getResources(), R.drawable.silvester), 250, true));
        choices.add(scaleDown(BitmapFactory.decodeResource(getResources(), R.drawable.tweety_bird), 250, true));


        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<7; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int j=0; j<4; j++) {
            randomComb.add(list.get(j));
        }





        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Canvas canvas = holder.lockCanvas(null);
                draw(canvas);
                holder.unlockCanvasAndPost(canvas);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    public void onDraw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(choices.get(choiceIndex1), 20, 50, null);
        canvas.drawBitmap(choices.get(choiceIndex2), 270, 50, null);
        canvas.drawBitmap(choices.get(choiceIndex3), 520, 50, null);
        canvas.drawBitmap(choices.get(choiceIndex4), 770, 50   , null);
        setWillNotDraw(false);
    }

    public static Bitmap scaleDown(Bitmap realImage, float maxImageSize,
                                   boolean filter) {
        float ratio = Math.min(
                (float) maxImageSize / realImage.getWidth(),
                (float) maxImageSize / realImage.getHeight());
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = Math.round((float) ratio * realImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float x = event.getX();
        float y = event.getY();
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN: {
                //Check if the x and y position of the touch is inside the bitmap
                if( x > 20 && x < 20 + choices.get(0).getWidth() && y > 50 && y < 50 + choices.get(0).getHeight() )
                {
                    if(choiceIndex1 == 6)
                        choiceIndex1 = 0;
                    else
                        choiceIndex1++;
                    GameView.this.invalidate();
                }

                if( x > 270 && x < 270 + choices.get(0).getWidth() && y > 50 && y < 50 + choices.get(0).getHeight() )
                {
                    if(choiceIndex2 == 6)
                        choiceIndex2 = 0;
                    else
                        choiceIndex2++;
                    GameView.this.invalidate();
                }

                if( x > 520 && x < 520 + choices.get(0).getWidth() && y > 50 && y < 50 + choices.get(0).getHeight() )
                {
                    if(choiceIndex3 == 6)
                        choiceIndex3 = 0;
                    else
                        choiceIndex3++;
                    GameView.this.invalidate();
                }

                if( x > 770 && x < 770 + choices.get(0).getWidth() && y > 50 && y < 50 + choices.get(0).getHeight() )
                {
                    if(choiceIndex4 == 6)
                        choiceIndex4 = 0;
                    else
                        choiceIndex4++;
                    GameView.this.invalidate();
                }
                //Toast.makeText(getContext(), String.valueOf(randomComb), Toast.LENGTH_SHORT).show();
                checkCorrect();
            }
                return true;
        }
        return false;
    }

    public boolean checkCorrect(){
        boolean decision = false;

        if(choiceIndex1 == randomComb.get(0) ||
            choiceIndex2 == randomComb.get(1) ||
            choiceIndex3 == randomComb.get(3) ||
            choiceIndex4 == randomComb.get(4)){
            decision = true;
            Toast.makeText(getContext(), "Correct", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getContext(), String.valueOf(randomComb), Toast.LENGTH_SHORT).show();
        return decision;


    public String checkCorrect(){
        String decision = "0 correct guesses, 0 in wrong position";
        int correctGuess = 0;
        int wrongPosition = 0;

        if(choiceIndex1 == randomComb[0]){
            correctGuess++;
        } else if(choiceIndex1 == randomComb[1] || choiceIndex1 == randomComb[2] || choiceIndex1 == randomComb[3]){
            wrongPosition++;
        }

        if(choiceIndex2 == randomComb[1]){
            correctGuess++;
        } else if(choiceIndex1 == randomComb[0] || choiceIndex1 == randomComb[2] || choiceIndex1 == randomComb[3]){
            wrongPosition++;
        }

        if(choiceIndex3 == randomComb[2]){
            correctGuess++;
        } else if(choiceIndex1 == randomComb[0] || choiceIndex1 == randomComb[1] || choiceIndex1 == randomComb[3]){
            wrongPosition++;
        }

        if(choiceIndex4 == randomComb[3]){
            correctGuess++;
        } else if(choiceIndex1 == randomComb[0] || choiceIndex1 == randomComb[1] || choiceIndex1 == randomComb[2]){
            wrongPosition++;
        }

        return "" + correctGuess + "correct Guesses, " + wrongPosition + "in wrong position.";
    }

}
