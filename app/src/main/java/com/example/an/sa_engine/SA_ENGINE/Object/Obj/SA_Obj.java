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


    protected Point pos = new Point(0, 0);
    //protected int x = 0;
    //protected int y = 0;
    private int deep = 0;


    //user_use

    protected int SA_CAMERA_ENDX;
    protected int SA_CAMERA_ENDY;
    protected int SA_CAMERA_CENTERX;
    protected int SA_CAMERA_CENTERY;


    protected int SA_COLOR_RED = Color.RED;
    protected int SA_COLOR_BLACK = Color.BLACK;
    protected int SA_COLOR_WHITE = Color.WHITE;
    protected int SA_COLOR_GRAY = Color.GRAY;


    protected int SA_FILLEDGE;
    protected int SA_FILL;
    protected int SA_EDGE;


    protected int SA_MASK_RECT;
    protected int SA_MASK_CIRCLE;
    protected int SA_MASK_AUTO;


    protected int SA_SCROLL_HORIZONTAL;
    protected int SA_SCROLL_VERTICAL;






    public SA_Obj() {
        engine = SA_Engine.getEngine();


        //userFlag값 지정-----------------------------

        SA_CAMERA_ENDX = engine.getWindowWidth();
        SA_CAMERA_ENDY = engine.getWindowHeight();
        SA_CAMERA_CENTERX = engine.getWindowWidth()/2;
        SA_CAMERA_CENTERY = engine.getWindowHeight()/2;

        SA_FILLEDGE = SA_FLAG.ENGINE_DRAW_OPTION_FILLEDGE;
        SA_FILL = SA_FLAG.ENGINE_DRAW_OPTION_FILL;
        SA_EDGE = SA_FLAG.ENGINE_DRAW_OPTION_EDGE;



        //MASK
        SA_MASK_RECT = SA_FLAG.ENGINE_MASK_CREATE_RECT;
        SA_MASK_CIRCLE = SA_FLAG.ENGINE_MASK_CREATE_CIRCLE;
        SA_MASK_AUTO = SA_FLAG.ENGINE_MASK_CREATE_AUTO;

        SA_SCROLL_HORIZONTAL = SA_FLAG.ENGINE_OBJECT_SCROLL_HORIZONTAL;
        SA_SCROLL_VERTICAL = SA_FLAG.ENGINE_OBJECT_SCROLL_VERTICAL;



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

    @Override
    public void _Start() {
        Log.e("애는 Obj", name);
    }

    protected void SA_RootParent(boolean rootParent) {
        this.rootParent = rootParent;
    }

    protected Object SA_Child(Object obj) {//obj는 자식임
        if(child == null) child = new SA_ObjManager(this);
        child.add(obj);
        ((SA_Obj)obj).setParent(child);
        return obj;
    }

    //point
    //cpoint
    //center
    //ccenter
    //length
    //clength




    //스프라이트, index, speed, x, y, alpha
    //index = 해당 인덱스부터 재생
    //index =  음수 -> 해당 인덱스부터 역재생
    //speed = 0 정지
    //speed = 1 재생
    //speed = 음수 -> 한번만 하고 종료



    //sprite
    protected SA_Draw SA_Draw_Sprite(String name, String sprite, int deep, int index, double speed, int standardX, int standardY, int width_endX, int hegith_endY){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, name, deep, standardX, standardY)
                .InitSprite(sprite, index, speed, width_endX, hegith_endY, ""));
    }
    protected SA_Draw SA_Draw_Sprite(String name, String sprite, int deep, int index, double speed, int standardX, int standardY, int width_endX, int hegith_endY, String option){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, name, deep, standardX, standardY)
                .InitSprite(sprite, index, speed, width_endX, hegith_endY, option));
    }

    protected void SA_Draw_Sprite_Change(String name, String changeSpriteName){
        drawManager.search(name).spriteChange(changeSpriteName);
    }

    //rect
    protected SA_Draw SA_Draw_Rect(String name, int deep, int standardX, int standardY, int width_endX, int hegith_endY, String color){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, name, deep, standardX, standardY)
                .InitRect(width_endX, hegith_endY, color, ""));
    }
    protected SA_Draw SA_Draw_Rect(String name, int deep, int standardX, int standardY, int width_endX, int hegith_endY, String color, String option){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, name, deep, standardX, standardY)
                .InitRect(width_endX, hegith_endY, color, option));
    }

    //roundrect
    protected SA_Draw SA_Draw_RoundRect(String name, int deep, int standardX, int standardY, int width_endX, int hegith_endY, int radius, String color){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, name, deep, standardX, standardY)
                .InitRoundRect(width_endX, hegith_endY, radius, color, ""));
    }
    protected SA_Draw SA_Draw_RoundRect(String name, int deep, int standardX, int standardY, int width_endX, int hegith_endY, int radius, String color, String option){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, name, deep, standardX, standardY)
                .InitRoundRect(width_endX, hegith_endY, radius, color, option));
    }

    //circle
    protected SA_Draw SA_Draw_Circle(String name, int deep, int standardX, int standardY, int radius, String color){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, name, deep, standardX, standardY)
                .InitCircle(radius, color, ""));
    }
    protected SA_Draw SA_Draw_Circle(String name, int deep, int standardX, int standardY, int radius, String color, String option){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, name, deep, standardX, standardY)
                .InitCircle(radius, color, option));
    }

    //line
    protected SA_Draw SA_Draw_Line(String name, int deep, int startX, int startY, int endX, int endY, String color, int thickness){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, name, deep, startX, startY)
                .InitLine(endX, endY, color, thickness, ""));
    }
    protected SA_Draw SA_Draw_Line(String name, int deep, int startX, int startY, int endX, int endY, String color, int thickness, String option){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, name, deep, startX, startY)
                .InitLine(endX, endY, color, thickness, option));
    }


    //text
    protected SA_Draw SA_Draw_Text(String name, int deep, int standardX, int standardY, String text, String color, int fintSize){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, name, deep, standardX, standardY)
                .InitText(text, color, fintSize, ""));
    }
    protected SA_Draw SA_Draw_Text(String name, int deep, int standardX, int standardY, String text, String color, int fintSize, String option){
        if(drawManager == null)
            drawManager = new SA_DrawManager();
        return drawManager.add(new SA_Draw(this, name, deep, standardX, standardY)
                .InitText(text, color, fintSize, option));
    }

    //destroy
    protected void SA_Draw_Destroy(String name){
        if(drawManager.destroy(name) == 0)
            drawManager = null;
    }


    //click
    protected void SA_Click(String name, Object clickClass){
        if(hashMap_ClickListener == null) hashMap_ClickListener = new HashMap<>();
        hashMap_ClickListener.put(name, clickClass);//리스너 등록"이름"으로 되있음
        //여기서 마스크에 맞게 구역 나눠서 배치해야됨
        SA_Draw draw = drawManager.search(name);
        draw.setOn(true);
    }

    //mask
    protected void SA_Mask(String name, int maskType){
        drawManager.search(name).SetMask(maskType);
    }


    public void parentPos(Point p){
        p.x += pos.x;
        p.y += pos.y;
        if(parent != null)
            parent.parentPos(p);
    }

    protected void SA_Draw_Move(String name, int x, int y){
        drawManager.search(name).Move(x, y);
    }


    //Log
    protected void Log(Object text){
        engine.getDebug().Log(text);
    }

    protected void SetPos(int x, int y){
        pos.x = x;
        pos.y = y;
    }

    protected void SA_Draw_SetDeep(String name, int deep){

    }

    public Point getPos() {
        return pos;
    }

    protected void SA_Deep(int deep){
        this.deep = deep;
        //deep sort해야됨
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

    public boolean checkClick(int clickX, int clickY) {
        String click = null;
        if(drawManager != null){
            click = drawManager.checkClick(clickX, clickY);
        }
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
