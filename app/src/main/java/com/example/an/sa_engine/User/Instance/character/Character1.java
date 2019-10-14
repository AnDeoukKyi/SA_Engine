package com.example.an.sa_engine.User.Instance.character;

import android.util.Log;

import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;
import com.example.an.sa_engine.User.Instance.character.hand.Hand;


public class Character1 extends SA_Obj {

    public String str = "Character1";

    public Character1(String name){
        SA_Create(name);//인스턴스 생성(이름"name")



        //SA_SetChild(new Hand());
        //등록후 자식관계설정
    }
}
