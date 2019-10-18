package com.example.an.sa_engine.SA_ENGINE.Object.Draw;

import android.graphics.Canvas;

import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SA_DrawManager {

    private ArrayList<Object> AL_Draw;

    public SA_DrawManager() {
        AL_Draw = new ArrayList<>();
    }


    public void add(Object obj){
        AL_Draw.add(obj);
        deepSort();
    }

    private void deepSort(){
        Comparator<Object> cmpDeep = new Comparator<Object>() {
            @Override
            public int compare(Object draw1, Object draw2) {
                return ((SA_Draw)draw1).getDeep() - ((SA_Draw)draw2).getDeep();
            }
        };
        Collections.sort(AL_Draw, cmpDeep);
    }

    public void draw(Canvas canvas){
        for(int i = 0; i<AL_Draw.size(); i++)
            ((SA_Draw)AL_Draw.get(i)).draw(canvas);
    }

    public SA_Draw search(String name) {
        for(int i = 0; i<AL_Draw.size(); i++)
            if(((SA_Draw)AL_Draw.get(i)).getName().equals(name))
                return (SA_Draw)AL_Draw.get(i);
        return null;
    }
}
