package com.example.an.sa_engine.SA_ENGINE.Object.Draw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.an.sa_engine.SA_ENGINE.Object.Mask.SA_Mask;
import com.example.an.sa_engine.SA_ENGINE.Object.Mask.SA_MaskPoint;
import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SA_Draw {

    private SA_Obj obj;
    private int startX, startY, endX, endY, centerX, centerY, width, height;
    private boolean draw = true;
    private boolean click;




    private Bitmap sprite;
    private String text;
    private int deep = 0;
    private String name;
    private int viewOption;
    private int drawType;
    private int drawOption;
    private int posType;
    private Paint paint;
    private SA_Mask mask;
    private Point relative = new Point(0, 0);
    int relativeX = 0, relativeY = 0;



    public SA_Draw(SA_Obj obj, int viewOption, int drawType, int posType, String name, int deep, Object... objects) {
        this.obj = obj;
        this.viewOption = viewOption;
        this.drawType = drawType;
        this.posType = posType;
        this.name = name;
        this.deep = deep;
        if(paint == null)
            paint = new Paint();
        switch(drawType){
            case SA_FLAG.ENGINE_DRAW_SPRITE_CREATE:
                //spriteName, index, speed, centerX, centerY, width, height
                setDrawPos(posType, 3, objects);
                sprite = BitmapFactory.decodeResource(obj.getEngine().getResources(), obj.getEngine().getResources().getIdentifier((String)objects[0], "drawable", obj.getEngine().getPackageName()));
                break;
            case SA_FLAG.ENGINE_DRAW_RECT_CREATE:
                //drawOption, centerX, centerY, width, height, color, thickness
                setDrawPos(posType, 1, objects);
                drawOption = (Integer)objects[0];
                switch(drawOption){
                    case SA_FLAG.ENGINE_DRAW_OPTION_EDGE:
                        paint.setStyle(Paint.Style.STROKE);
                        break;
                    case SA_FLAG.ENGINE_DRAW_OPTION_FILL:
                        paint.setStyle(Paint.Style.FILL);
                }
                setPaint((Integer)objects[5], (Integer)objects[6]);
                break;
            case SA_FLAG.ENGINE_DRAW_LINE_CREATE:
                //startX, startY, endX, endY, color, thickness
                setDrawPos(posType, 0, objects);
                setPaint((Integer)objects[4], (Integer)objects[5]);
                break;
            case SA_FLAG.ENGINE_DRAW_TEXT_CREATE:
                break;
        }
    }



    public void SetMask(int maskType){
        mask = new SA_Mask(this, maskType);
    }

    public void setOn(boolean clickOnoff){
        this.click = clickOnoff;
    }

    public void registerMask(HashMap<String, ArrayList<Object>> hashMap_camera) {

        //mask가져와서 구역나누고 저장해야됨


    }




    public void draw(Canvas canvas){
        if(viewOption == SA_FLAG.ENGINE_DRAW_OPTION_RELATIVE){
            relative.x = 0;
            relative.y = 0;
            obj.parentPos(relative);
            relativeX = obj.getX();
            relativeY = obj.getY();
        }
        switch(drawType){
            case SA_FLAG.ENGINE_DRAW_SPRITE_CREATE:
                if(sprite != null)
                    canvas.drawBitmap(sprite, null, new Rect(startX + relative.x, startY + relative.y, endX + relative.x, endY + relative.y), null);
                break;
            case SA_FLAG.ENGINE_DRAW_TEXT_CREATE:
                break;
            case SA_FLAG.ENGINE_DRAW_RECT_CREATE:
                canvas.drawRect(startX + relative.x, startY + relative.y, endX + relative.x, endY + relative.y, paint);
                break;
            case SA_FLAG.ENGINE_DRAW_LINE_CREATE:
                canvas.drawLine(startX + relative.x, startY + relative.y, endX + relative.x, endY + relative.y, paint);
                break;
        }
    }

    private void setDrawPos(int posType, int startIndex, Object... objects) {
        switch(posType){
            case SA_FLAG.PARAM_POS_CENTER:
                centerX = (Integer)objects[startIndex];
                centerY = (Integer)objects[startIndex + 1];
                width = (Integer)objects[startIndex + 2];
                height = (Integer)objects[startIndex + 3];
                startX = centerX - width/2;
                startY = centerY - height/2;
                endX = startX + width;
                endY = startY + height;
                break;
            case SA_FLAG.PARAM_POS_LENGTH:
                startX = (Integer)objects[startIndex];
                startY = (Integer)objects[startIndex + 1];
                width = (Integer)objects[startIndex + 2];
                height = (Integer)objects[startIndex + 3];
                centerX = startX + width/2;
                centerY = startY + width/2;
                endX = startX + width;
                endY = startY + height;
                break;
            case SA_FLAG.PARAM_POS_POINT2POINT:
                startX = (Integer)objects[startIndex];
                startY = (Integer)objects[startIndex + 1];
                endX = (Integer)objects[startIndex + 2];
                endY = (Integer)objects[startIndex + 3];
                width = endX - startX;
                height = endY - startY;
                centerX = startX + width/2;
                centerY = startY + width/2;
                break;
        }
    }

    public int getDrawOption() {
        return drawOption;
    }

    public SA_Obj getObj() {
        return obj;
    }

    public boolean isClick() {
        return click;
    }

    public void setPaint(int color, int thickness){
        paint.setColor(color);
        paint.setStrokeWidth(thickness);
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

    public int getDeep() {
        return deep;
    }

    public int getDrawType() {
        return drawType;
    }

    public String getText() {
        return text;
    }

    public int getViewOption() {
        return viewOption;
    }

    public String getName() {
        return name;
    }

    public String checkClick(int clickX, int clickY, int relX, int relY) {
        if(mask.getMaskManager().checkClick(clickX-relX, clickY-relY))
            return name;

        return null;
    }
}
