package com.example.an.sa_engine.SA_ENGINE.Object.Obj;


import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.SA_ENGINE.System.Log.SA_Log;

public class SA_Obj extends SA_Log{

    private SA_Engine SA_engine;
    private int SA_id;
    private String SA_ObjName;
    private String SA_tag = "";



    public SA_Obj() {
        SA_engine = SA_Engine.getEngine();
    }

    protected void SA_Create(String name) {
        this.SA_ObjName = name;
        Log("CreateObj", name + " 인스턴스가 생성되었습니다.");
        this.SA_id = SA_engine.SA_AddObj(this);
    }
}
