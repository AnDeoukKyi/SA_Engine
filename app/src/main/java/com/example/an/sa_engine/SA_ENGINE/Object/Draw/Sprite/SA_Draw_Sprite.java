package com.example.an.sa_engine.SA_ENGINE.Object.Draw.Sprite;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;

public class SA_Draw_Sprite {

    private Bitmap sprite;
    private int startX, startY, endX, endY, centerX, centerY, width, height;
    private double speed = 1;
    private int alpha = 255;


    public SA_Draw_Sprite(int drawPosOption, SA_Engine engine, String spriteName, int index, double speed, int startX, int startY, int width, int height) {
        sprite = BitmapFactory.decodeResource(engine.getResources(), engine.getResources().getIdentifier(spriteName, "drawable", engine.getPackageName()));
        switch(drawPosOption){
            case SA_FLAG.ELSE_POS_CENTER:
                this.centerX = startX;
                this.centerY = startY;
                this.width = width;
                this.height = height;
                this.startX = centerX - width/2;
                this.startY = centerY - height/2;
                this.endX = this.startX + width;
                this.endY = this.startY + height;
                break;


//
//            case SA_FLAG.ELSE_NOTHING:
//                break;
        }




//        this.startX = startX;
//        this.startY = startY;
//        this.width = width;
//        this.height = height;
//        endX = startX + width;
//        endY = startY + height;
//
//
//        centerX = startX + width/2;
//        centerY = startY + height/2;

    }

    public Bitmap getSprite() {
        return sprite;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
