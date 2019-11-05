package com.example.an.sa_engine.User.Instance.character;

import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;


public class Character2 extends SA_Obj {

    @Override
    public void _Create(String name) {
        super._Create("케릭터");
        SA_RootParent(true);
        SetPos(500, 500);
    }

    @Override
    public void _Draw() {
        super._Draw();
        SA_Draw_Rect("asdf", 20, 300, 300, 100, 100, "red","camera");
        SA_Draw_Rect("asdf", 20, 0, 0, 100, 100, "black");


        int k = 0;
    }
}
