package com.example.an.sa_engine.User.Instance.character.hand.finger;


import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;

public class Finger extends SA_Obj {

    public String a = "Finger";

    public Finger(String name, Object parent) {
        //SA_Create_Child(name, parent);//인스턴스 생성(이름"name")

    }

    public Finger SA_Cast(Object obj){//필수
        return (Finger)obj;
    }
}
