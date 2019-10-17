package com.example.an.sa_engine.SA_ENGINE.System.Room;

import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.SA_ENGINE.System.Log.SA_Log;

public class SA_Room{

    private SA_Engine engine;


    public SA_Room() {
        engine = SA_Engine.getEngine();
    }



    protected void roomMove(Object obj){

    }

    protected void setEngine(SA_Engine engine){
        this.engine = engine;
    }


}
