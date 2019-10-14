package com.example.an.sa_engine.SA_ENGINE.System.Option.User;

import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;

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
        portrait = SA_FLAG.USER_VIEW_TYPE_PORTRAIT;
        landscape = SA_FLAG.USER_VIEW_TYPE_LANDSCAPE;
    }//초기화 진행


    //-----------------------------------------------------------------------------------


    protected void View_WindowSize(int windowX, int windowY){
        AddFlag("VIEW_WINDOWSIZE_X", windowX);
        AddFlag("VIEW_WINDOWSIZE_Y", windowY);
    }

    protected void DEBUG_LOG_CREATEOBJ(boolean flag){
        AddFlag("DEBUG_LOG_CREATEOBJ", (flag)? SA_FLAG.USER_DEBUG_LOG_CREATEOBJ_YES : SA_FLAG.USER_DEBUG_LOG_CREATEOBJ_NO);
    }

    protected void DEBUG_MODE(boolean flag){
        AddFlag("DEBUG_MODE", (flag)? SA_FLAG.USER_DEBUG_MODE_YES : SA_FLAG.USER_DEBUG_MODE_NO);
    }

    protected void View_Type(int flag){
        AddFlag("VIEW_TYPE", flag);
    }


    //-----------------------------------------------------------------------------------





    private void AddFlag(String subFlag, int flag){
        hashMap_UserOption.put(subFlag, flag);
    }//flag등록

    public HashMap<String, Integer> getFlag() {
        return hashMap_UserOption;
    }

}
