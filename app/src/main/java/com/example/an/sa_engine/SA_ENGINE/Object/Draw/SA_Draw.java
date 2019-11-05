package com.example.an.sa_engine.SA_ENGINE.Object.Draw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

import com.example.an.sa_engine.SA_ENGINE.Object.Camera.SA_Camera;
import com.example.an.sa_engine.SA_ENGINE.Object.Draw.Option.SA_Draw_Circle_Option;
import com.example.an.sa_engine.SA_ENGINE.Object.Draw.Option.SA_Draw_Line_Option;
import com.example.an.sa_engine.SA_ENGINE.Object.Draw.Option.SA_Draw_Rect_Option;
import com.example.an.sa_engine.SA_ENGINE.Object.Draw.Option.SA_Draw_Sprite_Option;
import com.example.an.sa_engine.SA_ENGINE.Object.Draw.Option.SA_Draw_Text_Option;
import com.example.an.sa_engine.SA_ENGINE.Object.Mask.SA_Mask;
import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;
import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;

import java.util.HashMap;

public class SA_Draw {

    private SA_Obj obj;
    private boolean draw = true;
    private HashMap<String, Boolean> hashMap_Option;





    private String name;
    private int deep = 0;
    private int standardX, standardY;//기준점
    private int viewOption = SA_FLAG.ENGINE_DRAW_OPTION_RELATIVE;//상대/카메라
    private int drawType;//뭐그릴지
    private int drawOptionX = SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_LEFT;//시작위치 기준 옵션
    private int drawOptionY = SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_TOP;//시작위치 기준 옵션
    private int posType = SA_FLAG.ENGINE_DRAW_OPTION_POS_LENGTH;//p2p인지 길이인지





    private int startX, startY, endX, endY, centerX, centerY, width, height;
    private Point relative = new Point(0, 0);
    private Point camera;


    //sprite
    private Bitmap sprite;
    private int index;
    private double speed;



    //shape
    private Paint paint = new Paint();
    private Paint inPaint;
    private int radius;
    private int thickness = 0;//??필요한가?
    private int shapeOption = SA_FLAG.ENGINE_DRAW_OPTION_FILL;
    private RectF rectf;

    //text
    private String text;
    private Bitmap textSprite;
    private TextPaint textPaint;
    private int fontSize;
    private String backgroundColor;
    private int maxWidth = 0;




    //mask
    private SA_Mask mask;

    //click
    private boolean click;




    public SA_Draw(SA_Obj obj, String name, int deep, int standardX, int standardY) {
        this.obj = obj;
        this.name = name;
        this.deep = deep;
        this.standardX = standardX;
        this.standardY = standardY;
        camera = obj.getEngine().getCamera().getPos();
    }

    public void draw(Canvas canvas){
        if(!draw) return;
        camera = obj.getEngine().getCamera().getPos();
        relative.x = 0;
        relative.y = 0;
        if(viewOption == SA_FLAG.ENGINE_DRAW_OPTION_RELATIVE){
            obj.parentPos(relative);
            relative.x -= camera.x - obj.getEngine().getWindowWidth()/2;
            relative.y -= camera.y - obj.getEngine().getWindowHeight()/2;
        }
        switch(drawType){
            case SA_FLAG.ENGINE_DRAW_CREATE_SPRITE:
                if(sprite != null)
                    canvas.drawBitmap(sprite, null, new Rect(startX + relative.x, startY + relative.y, endX + relative.x, endY + relative.y), null);
                break;
            case SA_FLAG.ENGINE_DRAW_CREATE_RECT:
                if(inPaint != null)
                    canvas.drawRect(startX + relative.x, startY + relative.y, endX + relative.x, endY + relative.y, inPaint);
                canvas.drawRect(startX + relative.x, startY + relative.y, endX + relative.x, endY + relative.y, paint);
                break;
            case SA_FLAG.ENGINE_DRAW_CREATE_ROUNDRECT:
                if(inPaint != null){
                    canvas.drawRect(startX + relative.x, startY + radius + relative.y, startX + radius + relative.x, endY - radius + relative.y, inPaint);
                    canvas.drawRect(endX - radius + relative.x, startY + radius + relative.y, endX + relative.x, endY - radius + relative.y, inPaint);
                    canvas.drawRect(startX + radius + relative.x, startY + relative.y, endX - radius + relative.x, startY + radius + relative.y, inPaint);
                    canvas.drawRect(startX + radius + relative.x, endY - radius + relative.y, endX - radius + relative.x, endY + relative.y, inPaint);
                    canvas.drawRect(startX + radius + relative.x, startY +radius + relative.y, endX - radius + relative.x, endY - relative.y, inPaint);

                    rectf.set(startX + relative.x, startY + relative.y, startX + radius*2 + relative.x, startY + radius*2 + relative.y);
                    canvas.drawArc(rectf, 180, 90, true, inPaint);
                    rectf.set(endX - radius*2 + relative.x, startY + relative.y, endX + relative.x, startY + radius*2 + relative.y);
                    canvas.drawArc(rectf, 270, 90, true, inPaint);
                    rectf.set(endX - radius*2 + relative.x, endY - radius*2 + relative.y, endX + relative.x, endY + relative.y);
                    canvas.drawArc(rectf, 0, 90, true, inPaint);
                    rectf.set(startX + relative.x, endY - radius*2 + relative.y, startX + radius*2 + relative.x, endY + relative.y);
                    canvas.drawArc(rectf, 90, 90, true, inPaint);
                }
                if(shapeOption == SA_FLAG.ENGINE_DRAW_OPTION_FILL){
                    canvas.drawRect(startX + relative.x, startY + radius + relative.y, startX + radius + relative.x, endY - radius + relative.y, paint);
                    canvas.drawRect(endX - radius + relative.x, startY + radius + relative.y, endX + relative.x, endY - radius + relative.y, paint);
                    canvas.drawRect(startX + radius + relative.x, startY + relative.y, endX - radius + relative.x, startY + radius + relative.y, paint);
                    canvas.drawRect(startX + radius + relative.x, endY - radius + relative.y, endX - radius + relative.x, endY + relative.y, paint);
                    canvas.drawRect(startX + radius + relative.x, startY +radius + relative.y, endX - radius + relative.x, endY - relative.y, paint);
                    //코드 중복임 수정바람
                    rectf.set(startX + relative.x, startY + relative.y, startX + radius*2 + relative.x, startY + radius*2 + relative.y);
                    canvas.drawArc(rectf, 180, 90, true, paint);
                    rectf.set(endX - radius*2 + relative.x, startY + relative.y, endX + relative.x, startY + radius*2 + relative.y);
                    canvas.drawArc(rectf, 270, 90, true, paint);
                    rectf.set(endX - radius*2 + relative.x, endY - radius*2 + relative.y, endX + relative.x, endY + relative.y);
                    canvas.drawArc(rectf, 0, 90, true, paint);
                    rectf.set(startX + relative.x, endY - radius*2 + relative.y, startX + radius*2 + relative.x, endY + relative.y);
                    canvas.drawArc(rectf, 90, 90, true, paint);
                }
                else{
                    canvas.drawLine(startX + radius + relative.x, startY + relative.y, endX - radius + relative.x, startY + relative.y, paint);//t
                    canvas.drawLine(endX + relative.x, startY + radius+ relative.y, endX + relative.x, endY - radius + relative.y, paint);//r
                    canvas.drawLine(startX + radius + relative.x, endY + relative.y, endX - radius + relative.x, endY + relative.y, paint);//b
                    canvas.drawLine(startX + relative.x, startY + radius + relative.y, startX + relative.x, endY - radius + relative.y, paint);//l

                    rectf.set(startX + relative.x, startY + relative.y, startX + radius*2 + relative.x, startY + radius*2 + relative.y);
                    canvas.drawArc(rectf, 180, 90, false, paint);
                    rectf.set(endX - radius*2 + relative.x, startY + relative.y, endX + relative.x, startY + radius*2 + relative.y);
                    canvas.drawArc(rectf, 270, 90, false, paint);
                    rectf.set(endX - radius*2 + relative.x, endY - radius*2 + relative.y, endX + relative.x, endY + relative.y);
                    canvas.drawArc(rectf, 0, 90, false, paint);
                    rectf.set(startX + relative.x, endY - radius*2 + relative.y, startX + radius*2 + relative.x, endY + relative.y);
                    canvas.drawArc(rectf, 90, 90, false, paint);
                }
                break;
            case SA_FLAG.ENGINE_DRAW_CREATE_LINE:
                canvas.drawLine(startX + relative.x, startY + relative.y, endX + relative.x, endY + relative.y, paint);
                break;
            case SA_FLAG.ENGINE_DRAW_CREATE_CIRCLE:
                if(inPaint != null)
                    canvas.drawCircle(startX + relative.x, startY + relative.y, radius, inPaint);
                canvas.drawCircle(startX + relative.x, startY + relative.y, radius, paint);
                break;
            case SA_FLAG.ENGINE_DRAW_CREATE_TEXT:
                if(textSprite != null)
                    canvas.drawBitmap(textSprite, null, new Rect(startX + relative.x, startY + relative.y, endX + relative.x, endY + relative.y), null);
                //canvas.drawText(text, startX + relative.x, startY + relative.y, paint);
                break;

        }
    }



    public SA_Draw InitSprite(String spriteName, int index, double speed, int int1, int int2, String option){
        //sprite, index, speed, width_endX, hegith_endY ,option
        this.drawType = SA_FLAG.ENGINE_DRAW_CREATE_SPRITE;
        hashMap_Option = new SA_Draw_Sprite_Option().getOption();
        setOpiont(option);
        setPosInit(int1, int2);
        sprite = BitmapFactory.decodeResource(obj.getEngine().getResources(), obj.getEngine().getResources().getIdentifier(spriteName, "drawable", obj.getEngine().getPackageName()));
        this.index = index;
        this.speed = speed;
        return this;
    }

    public SA_Draw InitRect(int int1, int int2, String color, String option){
        //drawOption, width_endX, hegith_endY, color, thickness, option
        this.drawType = SA_FLAG.ENGINE_DRAW_CREATE_RECT;
        hashMap_Option = new SA_Draw_Rect_Option().getOption();
        setOpiont(option);
        setPosInit(int1, int2);
        setPaint(paint, color, thickness);
        return this;
    }

    public SA_Draw InitRoundRect(int int1, int int2, int radius, String color, String option){
        //drawOption, width_endX, hegith_endY, color, thickness, option
        this.drawType = SA_FLAG.ENGINE_DRAW_CREATE_ROUNDRECT;
        hashMap_Option = new SA_Draw_Rect_Option().getOption();
        this.radius = radius;
        rectf = new RectF();
        setOpiont(option);
        setPosInit(int1, int2);
        setPaint(paint, color, thickness);
        int min = width;
        if(width > height) min = height;
        if(radius * 2 > min) this.radius = min/2;
        return this;
    }

    public SA_Draw InitLine(int int1, int int2, String color, int thickness, String option){
        //width_endX, hegith_endY, color, option
        this.drawType = SA_FLAG.ENGINE_DRAW_CREATE_LINE;
        hashMap_Option = new SA_Draw_Line_Option().getOption();
        this.thickness = thickness;
        posType = SA_FLAG.ENGINE_DRAW_OPTION_POS_POINT2POINT;
        startX = standardX;
        startY = standardY;
        endX = int1;
        endY = int2;
        setOpiont(option);
        setPaint(paint, color, thickness);
        return this;
    }

    public SA_Draw InitCircle(int radius, String color, String option){
        //radius, color, option
        this.drawType = SA_FLAG.ENGINE_DRAW_CREATE_CIRCLE;
        hashMap_Option = new SA_Draw_Circle_Option().getOption();
        this.radius = radius;
        setOpiont(option);
        startX = standardX;
        startY = standardY;
        setPaint(paint, color, thickness);
        return this;
    }

    public SA_Draw InitText(String text, String color, int fontSize, String option){
        //text, color, fintSize
        this.drawType = SA_FLAG.ENGINE_DRAW_CREATE_TEXT;
        hashMap_Option = new SA_Draw_Text_Option().getOption();
        this.text = text;
        this.fontSize = fontSize;
        setOpiont(option);
        width = maxWidth;
        textSprite = Bitmap.createBitmap(TextSprite(color), 0, 0, width, height);
        setPosLength();
        return this;
    }

    private Bitmap TextSprite(String color) {
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.LINEAR_TEXT_FLAG);
        textPaint.setStyle(Paint.Style.FILL);
        setColor(textPaint, color);
        textPaint.setTextSize(fontSize);

        int width = (int)textPaint.measureText(text)+1;
        if(maxWidth == 0 || maxWidth > width)
            maxWidth = width;

        StaticLayout mTextLayout = new StaticLayout(text, textPaint, maxWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.width = mTextLayout.getWidth();
        height = mTextLayout.getHeight();
        Bitmap b = Bitmap.createBitmap(width, mTextLayout.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas c = new Canvas(b);

        if(backgroundColor != null){
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.LINEAR_TEXT_FLAG);
            paint.setStyle(Paint.Style.FILL);
            setColor(paint, backgroundColor);
            c.drawPaint(paint);
        }

        c.save();
        c.translate(0, 0);
        mTextLayout.draw(c);
        c.restore();
        return b;
    }





    private void setPosInit(int int1, int int2){
        if(posType == SA_FLAG.ENGINE_DRAW_OPTION_POS_LENGTH){
            width = int1;
            height = int2;
            setPosLength();
        }
        else{//SA_FLAG.ENGINE_DRAW_OPTION_POS_POINT2POINT
            startX = standardX;
            startY = standardY;
            endX = int1;
            endY = int2;
            width = endX - startX;
            height = endY - startY;
        }
    }//위치지정start,end,width,height

    private void setPosLength(){
        switch(drawOptionY){
            case SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_TOP:
                startY = standardY;
                break;
            case SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_MIDDLE:
                startY = standardY - height/2;
                break;
            case SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_BOTTOM:
                startY = standardY - height;
                break;
        }
        switch(drawOptionX){
            case SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_LEFT:
                startX = standardX;
                break;
            case SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_CENTER:
                startX = standardX - width/2;
                break;
            case SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_RIGHT:
                startX = standardX - width;
                break;
        }
        endX = startX + width;
        endY = startY + height;
    }

    private void setPosOption(String option){
        switch(option){
            case "t":
            case "top":
                drawOptionY = SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_TOP;
                break;
            case "m":
            case "middle":
                drawOptionY = SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_MIDDLE;
                break;
            case "b":
            case "bottom":
                drawOptionY = SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_BOTTOM;
                break;
            case "l":
            case "left":
                drawOptionX = SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_LEFT;
                break;
            case "c":
            case "center":
                drawOptionX = SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_CENTER;
                break;
            case "r":
            case "right":
                drawOptionX = SA_FLAG.ENGINE_DRAW_OPTION_ALIGN_RIGHT;
                break;
        }
    }//시작점기준 나아갈방향tmb/lcr

    private void setOpiont(String option){
        String[] tmp;
        if(!option.equals("")) {//옵션있으면 지정
            tmp = option.replaceAll(" ", "").toLowerCase().split(",");
            for(int i = 0; i<tmp.length; i++) {
                String[] subOption = tmp[i].split("=");
                if(hashMap_Option.get(subOption[0])){
                    switch(subOption[0]){
                        case "camera":
                            viewOption = SA_FLAG.ENGINE_DRAW_OPTION_CAMERA;
                            break;
                        case "p2p":
                            posType = SA_FLAG.ENGINE_DRAW_OPTION_POS_POINT2POINT;
                            break;
                        case "thickness":
                            this.thickness = Integer.parseInt(subOption[1]);
                            if(inPaint == null)
                                shapeOption = SA_FLAG.ENGINE_DRAW_OPTION_EDGE;
                            break;
                        case "pos":
                            String[] subOption1 = subOption[1].split("/");
                            for(int j = 0; j<subOption1.length; j++){
                                setPosOption(subOption1[j]);
                            }
                            break;
                        case "incolor":
                            shapeOption = SA_FLAG.ENGINE_DRAW_OPTION_FILLEDGE;
                            inPaint = new Paint();
                            setPaint(inPaint, subOption[1], 0);
                            break;
                        case "background":
                            this.backgroundColor = subOption[1];
                            break;
                        case "width":
                            maxWidth = Integer.parseInt(subOption[1]);
                            break;
                    }
                }
            }
        }
    }


    //paint
    public void setPaint(Paint paint, String color, int thickness){
        if(thickness != 0){
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(thickness);
        }
        setColor(paint, color);
    }

    private void setColor(Paint paint, String color){
        color.toLowerCase();
        switch(color){
            case "black":
                paint.setColor(Color.BLACK);
                break;
            case "red":
                paint.setColor(Color.RED);
                break;
            case "white":
                paint.setColor(Color.WHITE);
                break;

            default:
                paint.setColor(Color.parseColor(color));
                break;
        }
    }

    //roundRect
    public void changeRoundRect(int radius){
        this.drawType = SA_FLAG.ENGINE_DRAW_CREATE_ROUNDRECT;
        this.radius = radius;
        rectf = new RectF();
        int min = width;
        if(width > height) min = height;
        if(radius * 2 > min) this.radius = min/2;

    }







    //mask
    public void SetMask(int maskType){
        mask = new SA_Mask(this, maskType);
    }

    public void setOn(boolean clickOnoff){
        this.click = clickOnoff;
    }




    //move
    public void Move(int x, int y) {
        startX += x;
        startY += y;
        endX += x;
        endY += y;
        if(mask != null)
            mask.Move(x, y);
    }

    public SA_Obj getObj() {
        return obj;
    }

    public boolean isClick() {
        return click;
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

    public String checkClick(int clickX, int clickY) {
        Point p = new Point(0, 0);
        if(viewOption != SA_FLAG.ENGINE_DRAW_OPTION_CAMERA){
            obj.parentPos(p);
            p.x -= camera.x;
            p.y -= camera.y;
        }
        //카메라보다 초과범위면 클릭 검사안함------------------------------------------------------------------
        if(mask.getMaskManager().checkClick(clickX - p.x, clickY - p.y))
            return name;

        return null;
    }

    public void spriteChange(String changeSpriteName) {
        sprite = BitmapFactory.decodeResource(obj.getEngine().getResources(), obj.getEngine().getResources().getIdentifier(changeSpriteName, "drawable", obj.getEngine().getPackageName()));
    }



}
