package com.example.an.sa_engine.SA_ENGINE.Object.Obj.ObjM;

import com.example.an.sa_engine.SA_ENGINE.Sys.Engine.SA_Engine;

public class SA_ObjM {

    private SA_Engine engine;
    private String name;//이름
    private String tag;//테그







    public SA_ObjM() {
        engine = SA_Engine.getEngine();//생성시 engine가지고 있음 그래야 Obj생성할때 전달가능
    }

    protected void Create(String name){//이름설정 Instance에서 호출함
        this.name = name;
        engine.addObjM(this);
    }

    protected void Create(String name, String tag){//이름, tag설정 Instance에서 호출함
        this.name = name;
        this.tag = tag;
        engine.addObjM(this);
    }

    public void Destroy(){
        engine.deleteObjM(this);
    }
}