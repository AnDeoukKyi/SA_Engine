package com.example.an.sa_engine.SA_ENGINE.Sys.Option.User;

import com.example.an.sa_engine.SA_ENGINE.Sys.Engine.SA_Engine;
import java.util.HashMap;

public abstract class SA_UserOption{

    SA_Engine engine;

    private HashMap<String, Integer> hashMap_UserOption;

    //user_use
    protected int portrait;
    protected int landscape;


    public SA_UserOption() {
        engine = SA_Engine.getEngine();
        Init();
        hashMap_UserOption = new HashMap<>();
    }

    private void Init(){
        portrait = engine.getFlag("VIEW", "portrait");
        landscape = engine.getFlag("VIEW", "landscape");
    }//초기화 진행

    protected void ViewType(int flag){
        AddFlag("view", flag);
    }//user_view flag등록

    private void AddFlag(String subFlag, int flag){
        hashMap_UserOption.put(subFlag, flag);
    }//flag등록

    public HashMap<String, Integer> getFlag() {
        return hashMap_UserOption;
    }

}
