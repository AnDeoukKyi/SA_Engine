package com.example.an.sa_engine.SA_ENGINE.Object.Obj;


import android.graphics.Canvas;

import com.example.an.sa_engine.SA_ENGINE.Object.Draw.SA_Draw;
import com.example.an.sa_engine.SA_ENGINE.Object.Draw.SA_DrawManager;
import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;
import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class SA_Obj implements Essential{

    private SA_Engine engine;
    private int id;
    private String name;
    private String tag = "";
    private SA_ObjManager child;
    private SA_ObjManager parent;
    private SA_DrawManager drawManager;
    private HashMap<String, Object> hashMap_ClickListener;
    private boolean rootParent = false;


    protected int x = 0;
    protected int y = 0;
    private int deep = 0;


    //user_use

    protected int SA_CAMERA_ENDX;
    protected int SA_CAMERA_ENDY;
    protected int SA_CAMERA_CENTERX;
    protected int SA_CAMERA_CENTERY;


    protected int SA_COLOR_RED = Color.RED;
    protected int SA_COLOR_BLACK = Color.BLACK;


    protected int SA_EDGE;


    protected int SA_MASK_RECT;
    protected int SA_MASK_CIRCLE;
    protected int SA_MASK_AUTO;






    public SA_Obj() {
        engine = SA_Engine.getEngine();


        //userFlag값 지정-----------------------------

        SA_CAMERA_ENDX = engine.getWindowWidth();
        SA_CAMERA_ENDY = engine.getWindowHeight();
        SA_CAMERA_CENTERX = engine.getWindowWidth()/2;
        SA_CAMERA_CENTERY = engine.getWindowHeight()/2;

        SA_EDGE = SA_FLAG.ENGINE_DRAW_OPTION_EDGE;



        //MASK
        SA_MASK_RECT = SA_FLAG.ENGINE_MASK_CREATE_RECT;
        SA_MASK_CIRCLE = SA_FLAG.ENGINE_MASK_CREATE_CIRCLE;
        SA_MASK_AUTO = SA_FLAG.ENGINE_MASK_CREATE_AUTO;

        //userFlag값 지정-----------------------------


        this.id = engine.SA_GetEmptyID();
        _Create("");
        if(rootParent)
            engine.SA_AddRootObj(this);
        else
            engine.SA_AddObj(this);

        //부모가 없으면 등록

        _Draw();


    }

    @Override
    public void _Create(String name) {
        this.name = name;
    }

    @Override
    public void _Draw() {

    }

    public void SA_RootParent(boolean rootParent) {
        this.rootParent = rootParent;
    }

    protected Object SA_Child(Object obj) {//obj는 자식임
        if(child == null) child = new SA_ObjManager(this);
        child.add(obj);
        ((SA_Obj)obj).setParent(child);
        return obj;
    }





    //sprite


    protected SA_Draw SA_Draw_Sprite_Center(String name, String sprite, int deep, int index, double speed, int centerX, int centerY, int width, int height){
        //스프라이트, index, speed, x, y, alpha
        //index = 해당 인덱스부터 재생
        //index =  음수 -> 해당 인덱스부터 역재생
        //speed = 0 정지
        //speed = 1 재생
        //speed = 음수 -> 한번만 하고 종료


        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, SA_FLAG.ENGINE_DRAW_OPTION_RELATIVE, SA_FLAG.ENGINE_DRAW_SPRITE_CREATE, SA_FLAG.PARAM_POS_CENTER, name, deep, sprite, index, speed, centerX, centerY, width, height));
    }




    protected void SA_Draw_Sprite(String name, String sprite, int deep, int index, double speed, int startX, int startY, int width, int height){
        //스프라이트, index, speed, x, y, alpha
        //index = 해당 인덱스부터 재생
        //index =  음수 -> 해당 인덱스부터 역재생
        //speed = 0 정지
        //speed = 1 재생
        //speed = 음수 -> 한번만 하고 종료


        if(drawManager == null)
            drawManager = new SA_DrawManager();
        drawManager.add(new SA_Draw(this, SA_FLAG.ENGINE_DRAW_OPTION_RELATIVE, SA_FLAG.ENGINE_DRAW_SPRITE_CREATE, SA_FLAG.PARAM_POS_LENGTH, name, deep, sprite, index, speed, startX, startY, width, height));

    }

    protected SA_Draw SA_Draw_Sprite_Camera_Center(String name, String sprite, int deep, int index, double speed, int centerX, int centerY, int width, int height){
        //스프라이트, index, speed, x, y, alpha
        //index = 해당 인덱스부터 재생
        //index =  음수 -> 해당 인덱스부터 역재생
        //speed = 0 정지
        //speed = 1 재생
        //speed = 음수 -> 한번만 하고 종료


        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, SA_FLAG.ENGINE_DRAW_OPTION_CAMERA, SA_FLAG.ENGINE_DRAW_SPRITE_CREATE, SA_FLAG.PARAM_POS_CENTER, name, deep, sprite, index, speed, centerX, centerY, width, height));
    }


//    protected  void SA_Draw_Camera_Rect(String name, int deep, int option, int startX, int startY, int width, int height, int alpha, int color){
//        if(drawManager == null)
//            drawManager = new SA_DrawManager();
//        drawManager.add(new SA_Draw(SA_FLAG.ENGINE_DRAW_RECT_CREATE, SA_FLAG.ELSE_NOTHING, engine, name, deep, option, startX, startY, width, height, alpha, color));
//    }


    protected SA_Draw SA_Draw_Rect_Camera_Center(String name, int deep, int drawOption, int centerX, int centerY, int width, int height, int color, int thickness){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, SA_FLAG.ENGINE_DRAW_OPTION_CAMERA, SA_FLAG.ENGINE_DRAW_RECT_CREATE, SA_FLAG.PARAM_POS_CENTER, name, deep, drawOption, centerX, centerY, width, height, color, thickness));
    }


    protected SA_Draw SA_Draw_Line(String name, int deep, int startX, int startY, int endX, int endY, int color, int thickness){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, SA_FLAG.ENGINE_DRAW_OPTION_RELATIVE, SA_FLAG.ENGINE_DRAW_LINE_CREATE, SA_FLAG.PARAM_POS_LENGTH, name, deep, startX, startY, endX, endY, color, thickness));
    }

    protected SA_Draw SA_Draw_Line_Camera_Point(String name, int deep, int startX, int startY, int endX, int endY, int color, int thickness){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, SA_FLAG.ENGINE_DRAW_OPTION_CAMERA, SA_FLAG.ENGINE_DRAW_LINE_CREATE, SA_FLAG.PARAM_POS_POINT2POINT, name, deep, startX, startY, endX, endY, color, thickness));
    }


    public void SA_Engine_Click(String clickOption){
        try {
            Object clickObject = hashMap_ClickListener.get(clickOption);
            Method method = clickObject.getClass().getDeclaredMethod(clickOption);
            method.setAccessible(true);
            method.invoke(clickObject);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void SA_Click(String name, Object clickClass){
        if(hashMap_ClickListener == null) hashMap_ClickListener = new HashMap<>();
        hashMap_ClickListener.put(name, clickClass);//리스너 등록"이름"으로 되있음
        //여기서 마스크에 맞게 구역 나눠서 배치해야됨
        SA_Draw draw = drawManager.search(name);
        draw.setOn(true);
    }


    protected void SA_Mask(String name, int maskType){
        drawManager.search(name).SetMask(maskType);
    }


    public void parentPos(Point p){
        p.x += x;
        p.y += y;
        if(parent != null)
            parent.parentPos(p);
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

    public SA_DrawManager getDrawManager() {
        return drawManager;
    }

    public void setParent(SA_ObjManager parent) {
        parent = new SA_ObjManager(null);
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public SA_Engine getEngine() {
        return engine;
    }

    public void draw(Canvas canvas) {
        if(child != null)
            child.draw(canvas);
        if(drawManager != null)
            drawManager.draw(canvas);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean checkClick(int clickX, int clickY) {
        String click = null;
        if(drawManager != null){
            click = drawManager.checkClick(clickX, clickY);
        }
        click = click;
        if(click == null){
            //더탐색
            if(child == null) return false;
            return child.checkClick(clickX, clickY);
        }
        else{
            //실행
            try {
                Object clickObject = hashMap_ClickListener.get(click);
                Method method = clickObject.getClass().getDeclaredMethod("Click", Object.class);
                method.setAccessible(true);
                method.invoke(clickObject, this);

                Log.e(click, "크크크크크크크" + click);
                return true;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
