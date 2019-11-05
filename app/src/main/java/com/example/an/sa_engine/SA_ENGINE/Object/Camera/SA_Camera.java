package com.example.an.sa_engine.SA_ENGINE.Object.Camera;

import android.graphics.Point;

import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;

public class SA_Camera extends SA_Obj{

    private Point pos = new Point(0, 0);
    private SA_Obj target;


    public void SA_SetCamera(SA_Obj target) {
        this.target = target;
        pos = target.getPos();
    }

    public Point getPos() {
        return pos;
    }


    @Override
    public void _Create(String name) {
        super._Create("카메라");

    }

    @Override
    public void _Draw() {
        super._Draw();
    }
}
