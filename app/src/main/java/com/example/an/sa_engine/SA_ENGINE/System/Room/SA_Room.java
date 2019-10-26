package com.example.an.sa_engine.SA_ENGINE.System.Room;

import com.example.an.sa_engine.SA_ENGINE.Object.Camera.SA_Camera;
import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;

public class SA_Room{

    private SA_Engine engine;
    private SA_Camera camera;


    public SA_Room() {
        engine = SA_Engine.getEngine();
        camera = new SA_Camera();
    }



    protected void SA_RoomMove(Object obj){

    }

    protected void setEngine(SA_Engine engine){
        this.engine = engine;
    }


}
