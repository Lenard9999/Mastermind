package com.example.mastermind;

import java.util.ArrayList;
import java.util.Collections;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlendMode;
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
import java.util.Random;

public class GameView extends SurfaceView {

    public SurfaceHolder holder;
    public ArrayList<Bitmap> choices = new ArrayList<>();
    public int choiceIndex1 = 0;
    public int choiceIndex2 = 0;
    public int choiceIndex3 = 0;
    public int choiceIndex4 = 0;
    public int randomComb[];

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
                    choiceIndex1++;
                    GameView.this.invalidate();
                }

                if( x > 270 && x < 270 + choices.get(0).getWidth() && y > 50 && y < 50 + choices.get(0).getHeight() )
                {
                    choiceIndex2++;
                    GameView.this.invalidate();
                }

                if( x > 520 && x < 520 + choices.get(0).getWidth() && y > 50 && y < 50 + choices.get(0).getHeight() )
                {
                    choiceIndex3++;
                    GameView.this.invalidate();
                }

                if( x > 770 && x < 770 + choices.get(0).getWidth() && y > 50 && y < 50 + choices.get(0).getHeight() )
                {
                    choiceIndex4++;
                    GameView.this.invalidate();
                }
            }
                return true;
        }
        return false;
    }


}
