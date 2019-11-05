package com.example.an.sa_engine.SA_ENGINE.Object.Obj;

import android.graphics.Canvas;
import android.graphics.Point;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    public boolean checkClick(int clickX, int clickY) {
        for(int i = 0; i<AL_Obj.size(); i++) {
            if(((SA_Obj) AL_Obj.get(i)).checkClick(clickX, clickY))
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

    public void run() {
        for(int i = 0; i<AL_Obj.size(); i++) {
            try {
                Object obj = AL_Obj.get(i);
                Method method = obj.getClass().getMethod("_Start");
                method.invoke(obj);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
