package com.example.an.sa_engine.User.Instance.character;

import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;
import com.example.an.sa_engine.User.Instance.character.foot.Foot;
import com.example.an.sa_engine.User.Instance.character.hand.Hand;


public class Character1 extends SA_Obj {


    int a = 0, b = 0;
    @Override
    public void _Create(String name) {
        super._Create("케릭터");
        SA_RootParent(true);
        SetPos(1000, 1000);
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        SetPos(1200-a, 1200-b);
                        Thread.sleep(10);
                        a++;
                        b++;
                    } catch (Throwable t) {
                    }
                }
            }
        }).start();
    }

    @Override
    public void _Draw() {
        super._Draw();
        SA_Draw_Sprite("케릭터", "sprite0", 20, 0, 0, 0, 0, 100, 100, "pos=m/c");


        int k = 0;
    }
}
