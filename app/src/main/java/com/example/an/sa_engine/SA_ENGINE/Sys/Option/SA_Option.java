package com.example.an.sa_engine.SA_ENGINE.Sys.Option;

import com.example.an.sa_engine.SA_ENGINE.Sys.Engine.SA_Engine;

public abstract class SA_Option implements SA_Option_Flag{

    SA_Engine engine;


    public SA_Option() {
        engine = SA_Engine.getEngine();
    }

    protected void ViewType(int type){
        switch(type){
            case flag_option_landscape:

                break;
            case flag_option_portrait:
                break;
        }
    }


    protected void StartRoom(String roomName){

    }

}
