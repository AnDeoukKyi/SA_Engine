package com.example.an.sa_engine.SA_ENGINE.Object.Obj;

import android.graphics.Canvas;

import java.util.ArrayList;

public class SA_ObjManager {

    private ArrayList<Object> AL_Obj;


    public SA_ObjManager() {
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
}
