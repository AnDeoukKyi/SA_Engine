package com.example.an.sa_engine.SA_ENGINE.Object.Camera;

import android.graphics.Point;

public class SA_Camera {

    public Point camera = new Point(0, 0);
    private Object target;


    public SA_Camera SA_SetCamera(Object target) {
        this.target = target;
        return this;
    }
}
