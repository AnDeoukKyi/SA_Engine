package com.example.an.sa_engine.SA_ENGINE.Object.Draw;

import android.graphics.Canvas;
import android.graphics.Point;

import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SA_DrawManager {

    private ArrayList<SA_Draw> AL_Draw;

    public SA_DrawManager() {
        AL_Draw = new ArrayList<>();
    }


    public SA_Draw add(SA_Draw draw){
        AL_Draw.add(draw);
        deepSort();
        return draw;
    }

    private void deepSort(){
        Comparator<SA_Draw> cmpDeep = new Comparator<SA_Draw>() {
            @Override
            public int compare(SA_Draw draw1, SA_Draw draw2) {
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

    public String checkClick(int clickX, int clickY){

        for(int i = 0; i<AL_Draw.size(); i++){
            if(((SA_Draw)AL_Draw.get(i)).isClick()){
                return ((SA_Draw)AL_Draw.get(i)).checkClick(clickX, clickY);
            }
        }
        return null;
    }
}
