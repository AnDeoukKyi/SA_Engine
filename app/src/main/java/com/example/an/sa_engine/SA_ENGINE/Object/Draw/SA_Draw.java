package com.example.an.sa_engine.SA_ENGINE.Object.Draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.an.sa_engine.SA_ENGINE.Object.Draw.Shape.SA_Draw_Shape;
import com.example.an.sa_engine.SA_ENGINE.Object.Draw.Sprite.SA_Draw_Sprite;
import com.example.an.sa_engine.SA_ENGINE.Object.Draw.Text.SA_Draw_Text;
import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;

public class SA_Draw {

    private SA_Draw_Shape shape;
    private SA_Draw_Sprite sprite;
    private SA_Draw_Text text;
    private int deep = 0;
    private String name;
    private int drawType;
    private int drawOption;
    private int drawPosOption;
    private Paint paint;


    public SA_Draw(Object... obj) {
        //obj[0] = flag(int)
        drawType = (Integer)obj[0];
        this.drawPosOption = (Integer)obj[1];
        switch((Integer)obj[0]){
            case SA_FLAG.ENGINE_DRAW_SPRITE_CREATE:
                //SA_FLAG.ENGINE_DRAW_SPRITE_CREATE, SA_FLAG.ELSE_POS_CENTER, SA_engine, name, sprite, deep, index, speed, centerX, centerY, width, height
                name = (String)obj[3];
                deep = (Integer)obj[5];
                sprite = new SA_Draw_Sprite(drawPosOption, (SA_Engine)obj[2], (String)obj[4], (Integer)obj[6], (Double)obj[7], (Integer)obj[8], (Integer)obj[9], (Integer)obj[10], (Integer)obj[11]);
                break;
            case SA_FLAG.ENGINE_DRAW_RECT_CREATE:
                //SA_FLAG.ENGINE_DRAW_RECT_CREATE, SA_FLAG.ELSE_POS_CENTER, name, deep, drawOption, centerX, centerY, width, height, color, thickness, alpha
                if(paint == null)
                    paint = new Paint();
                paint.reset();
                shape = new SA_Draw_Shape(drawPosOption, obj[5], obj[6], obj[7], obj[8]);
                name = (String)obj[2];
                deep = (Integer)obj[3];
                drawOption = (Integer)obj[4];
                switch((Integer)obj[4]){
                    case SA_FLAG.ENGINE_DRAW_OPTION_EDGE:
                        paint.setStyle(Paint.Style.STROKE);
                        break;
                    case SA_FLAG.ENGINE_DRAW_OPTION_FILL:
                        paint.setStyle(Paint.Style.FILL);
                }
                setPaint((Integer)obj[9], (Integer)obj[10]);
                break;
            case SA_FLAG.ENGINE_DRAW_LINE_CREATE:
                //SA_FLAG.ENGINE_DRAW_LINE_CREATE, SA_FLAG.ELSE_POS_CENTER, name, deep, startX, startY, endX, endY, color, thickness
                if(paint == null)
                    paint = new Paint();
                paint.reset();
                name = (String)obj[2];
                deep = (Integer)obj[3];
                shape = new SA_Draw_Shape(drawPosOption, obj[4], obj[5], obj[6], obj[7]);
                setPaint((Integer)obj[8], (Integer)obj[9]);

                break;



            case SA_FLAG.ENGINE_DRAW_TEXT_CREATE:
                break;
        }
    }


    public void draw(Canvas canvas){
        switch(drawType){
            case SA_FLAG.ENGINE_DRAW_SPRITE_CREATE:
                if(sprite.getSprite() != null)
                    canvas.drawBitmap(sprite.getSprite(), null, new Rect(sprite.getStartX(), sprite.getStartY(), sprite.getEndX(), sprite.getEndY()), null);
                break;
            case SA_FLAG.ENGINE_DRAW_RECT_CREATE:
                canvas.drawRect(shape.getStartX(), shape.getStartY(), shape.getEndX(), shape.getEndY(), paint);
                break;

            case SA_FLAG.ENGINE_DRAW_LINE_CREATE:
                canvas.drawLine(shape.getStartX(), shape.getStartY(), shape.getEndX(), shape.getEndY(), paint);

                break;
            case SA_FLAG.ENGINE_DRAW_TEXT_CREATE:
                break;
        }
    }


    public void setPaint(int color, int thickness){
        paint.setColor(color);
        paint.setStrokeWidth(thickness);
    }

    public int getDeep() {
        return deep;
    }

    public int getDrawType() {
        return drawType;
    }
}
