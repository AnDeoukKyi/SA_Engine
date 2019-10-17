package com.example.an.sa_engine.User.Instance.character.hand;


import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;
import com.example.an.sa_engine.User.Instance.character.hand.finger.Finger;

public class Hand extends SA_Obj {

    public String a = "Hand";


    public Hand(String name, Object parent) {
        SA_Create(name, parent);//인스턴스 생성(이름"name")
        SA_Child(new Finger("손까락", this));

    }
    public Hand SA_Cast(Object obj){//필수
        return (Hand)obj;
    }
}
