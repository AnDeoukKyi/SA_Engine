package com.example.an.sa_engine.SA_ENGINE.Object.Obj;

import android.graphics.Canvas;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.HashMap;

public class SA_ObjManager {

    private Object parent;
    private ArrayList<Object> AL_Obj;

    public SA_ObjManager(Object parent) {
        this.parent = parent;
        AL_Obj = new ArrayList<>();
    }


    public void add(Object obj){
        AL_Obj.add(obj);
    }

    public void draw(Canvas canvas) {
        for(int i = 0; i<AL_Obj.size(); i++){
            ((SA_Obj)AL_Obj.get(i)).draw(canvas);
        }
    }

    public boolean checkClick(int clickX, int clickY, int relX, int relY) {
        int objX = 0, objY = 0;
        if(parent != null){
            objX = ((SA_Obj)parent).getX() + relX;
            objY = ((SA_Obj)parent).getX() + relY;
        }
        for(int i = 0; i<AL_Obj.size(); i++) {
            //여기서 더탐색해야됨
            if(((SA_Obj) AL_Obj.get(i)).checkClick(clickX, clickY, objX, objY))
                return true;
        }
        return false;
    }

    public Object getParent() {
        return parent;
    }

    public void parentPos(Point p) {
        if(parent != null)
            ((SA_Obj)parent).parentPos(p);
    }
}
