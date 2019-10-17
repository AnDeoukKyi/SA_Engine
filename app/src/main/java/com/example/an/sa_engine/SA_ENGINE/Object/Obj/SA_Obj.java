package com.example.an.sa_engine.SA_ENGINE.Object.Obj;


import android.graphics.Canvas;

import com.example.an.sa_engine.SA_ENGINE.Object.Draw.SA_Draw;
import com.example.an.sa_engine.SA_ENGINE.Object.Draw.SA_DrawManager;
import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;
import android.graphics.Color;

public class SA_Obj{

    private SA_Engine SA_engine;
    private int SA_id;
    private String SA_ObjName;
    private String SA_tag = "";
    private SA_ObjManager objManager;
    private Object parent;
    private SA_DrawManager drawManager;


    private int SA_x = 0, SA_y = 0;
    private int deep = 0;


    //user_use

    protected int SA_CAMERA_WIDTH;
    protected int SA_CAMERA_HEIGHT;
    protected int SA_CAMERA_CENTERX;
    protected int SA_CAMERA_CENTERY;


    protected int SA_COLOR_RED = Color.RED;
    protected int SA_COLOR_BLACK = Color.BLACK;


    protected int SA_EDGE;






    public SA_Obj() {
        SA_engine = SA_Engine.getEngine();

        SA_CAMERA_WIDTH = SA_engine.getWindowWidth();
        SA_CAMERA_HEIGHT = SA_engine.getWindowHeight();
        SA_CAMERA_CENTERX = SA_engine.getWindowWidth()/2;
        SA_CAMERA_CENTERY = SA_engine.getWindowHeight()/2;

        SA_EDGE = SA_FLAG.ENGINE_DRAW_OPTION_EDGE;


    }

    protected void SA_Create(String name, Object parent) {//인스턴스 생성
        this.SA_ObjName = name;
        if(parent == null)
            this.SA_id = SA_engine.SA_AddObj(this, false);
        else
            this.SA_id = SA_engine.SA_AddObj(this, true);
        this.parent = parent;
    }

    protected void SA_Child(Object child) {//자식생성
        if(objManager == null)
            objManager = new SA_ObjManager();
        objManager.add(child);
    }




    //sprite

    protected void SA_Draw_Sprite(String name, String sprite, int deep, int index, double speed, int startX, int startY, int width, int height){
        //스프라이트, index, speed, x, y, alpha
        //index = 해당 인덱스부터 재생
        //index =  음수 -> 해당 인덱스부터 역재생
        //speed = 0 정지
        //speed = 1 재생
        //speed = 음수 -> 한번만 하고 종료


        if(drawManager == null)
            drawManager = new SA_DrawManager();
        drawManager.add(new SA_Draw(SA_FLAG.ENGINE_DRAW_SPRITE_CREATE, SA_engine, name, sprite, deep, index, speed, startX, startY, width, height));

    }

    protected void SA_Draw_Camera_SpriteCenter(String name, String sprite, int deep, int index, double speed, int centerX, int centerY, int width, int height){
        //스프라이트, index, speed, x, y, alpha
        //index = 해당 인덱스부터 재생
        //index =  음수 -> 해당 인덱스부터 역재생
        //speed = 0 정지
        //speed = 1 재생
        //speed = 음수 -> 한번만 하고 종료


        if(drawManager == null)
            drawManager = new SA_DrawManager();
        drawManager.add(new SA_Draw(SA_FLAG.ENGINE_DRAW_SPRITE_CREATE, SA_FLAG.ELSE_POS_CENTER, SA_engine, name, sprite, deep, index, speed, centerX, centerY, width, height));

    }


//    protected  void SA_Draw_Camera_Rect(String name, int deep, int option, int startX, int startY, int width, int height, int alpha, int color){
//        if(drawManager == null)
//            drawManager = new SA_DrawManager();
//        drawManager.add(new SA_Draw(SA_FLAG.ENGINE_DRAW_RECT_CREATE, SA_FLAG.ELSE_NOTHING, SA_engine, name, deep, option, startX, startY, width, height, alpha, color));
//    }

    //rect

    protected void SA_Draw_Camera_RectCenter(String name, int deep, int drawOption, int centerX, int centerY, int width, int height, int color, int thickness){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        drawManager.add(new SA_Draw(SA_FLAG.ENGINE_DRAW_RECT_CREATE, SA_FLAG.ELSE_POS_CENTER, name, deep, drawOption, centerX, centerY, width, height, color, thickness));
    }




    protected void SA_Draw_Camera_Line(String name, int deep, int startX, int startY, int endX, int endY, int color, int thickness){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        drawManager.add(new SA_Draw(SA_FLAG.ENGINE_DRAW_LINE_CREATE, SA_FLAG.ELSE_POS_NOTHING, name, deep, startX, startY, endX, endY, color, thickness));
    }





    protected void SA_Draw_SetDeep(String name, int deep){

    }

    protected void SA_Deep(int deep){
        this.deep = deep;
        //deep sort해야됨
    }

    protected void SA_Draw_Text(boolean relative, int x, int y, int color, String text){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        //위치,
    }

    public void draw(Canvas canvas) {
        drawManager.draw(canvas);
    }
}
