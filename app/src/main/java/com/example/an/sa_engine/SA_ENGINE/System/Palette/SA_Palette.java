package com.example.an.sa_engine.SA_ENGINE.System.Palette;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Color;

import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;

public class SA_Palette extends View {


    private SA_Engine engine;
    private boolean printWindowSize = false;
    private Paint paint;


    public SA_Palette(Context context) {
        super(context);
    }

    public SA_Palette(Context context, AttributeSet attrs) {
        super(context, attrs);
        engine = SA_Engine.getEngine();
        printWindowSize = engine.isPrintWindowSize();
        paint = new Paint();
        paint.setTextSize(30);
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        engine.getObjMaster().draw(canvas);

        invalidate();
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                engine.SA_Touch(SA_FLAG.ENGINE_CLICK_DOWN, (int)event.getX(), (int)event.getY());
                break;
            case MotionEvent.ACTION_UP:
                engine.SA_Touch(SA_FLAG.ENGINE_CLICK_UP, (int)event.getX(), (int)event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                engine.SA_Touch(SA_FLAG.ENGINE_CLICK_DRAG, (int)event.getX(), (int)event.getY());
                break;
        }

        return true;
    }
}
