package com.example.an.sa_engine.User.Instance.character;

import android.util.Log;

import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;
import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.User.Instance.character.foot.Foot;
import com.example.an.sa_engine.User.Instance.character.hand.Hand;


public class Character1 extends SA_Obj {

    public String str = "Character1";

    public Character1(String name, Object parent){//필수
        SA_Create(name, null);//인스턴스 생성(이름"name")
        SA_Child(new Hand("손", this));
        SA_Child(new Foot("발", this));
    }

    public Character1 SA_Cast(Object obj){//필수
        return (Character1)obj;
    }
}
