package com.example.an.sa_engine.User.Instance.character.foot;


import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;

public class Foot extends SA_Obj {

    public String a = "Foot";

    public Foot(String name, Object parent) {
        SA_Create(name, parent);//인스턴스 생성(이름"name")

    }

    public Foot SA_Cast(Object obj){//필수
        return (Foot)obj;
    }
}
