package com.example.an.sa_engine.SA_ENGINE.Sys.Palette;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class SA_Palette extends View {


    public SA_Palette(Context context) {
        super(context);
    }

    public SA_Palette(Context context, AttributeSet attrs) {
        super(context, attrs);
//        systems = Systems.getInstance();
//        listObjMManager = systems.getListObjMManager();
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        for(int i = 0; i<listObjMManager.size(); i++)
//            listObjMManager.getObjM(i).draw(canvas);
//
        invalidate();

    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        return true;
//    }
}
