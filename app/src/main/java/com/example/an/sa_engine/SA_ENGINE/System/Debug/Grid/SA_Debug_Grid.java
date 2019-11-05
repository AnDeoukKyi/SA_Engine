package com.example.an.sa_engine.SA_ENGINE.System.Debug.Grid;

import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;

public class SA_Debug_Grid extends SA_Obj{

    @Override
    public void _Create(String name) {
        super._Create("격자");
        SA_RootParent(true);
    }

    @Override
    public void _Draw() {
        super._Draw();
        //일단 카메라 위치를 알아와야됨
        //해당 위치 기준으로 선을 그음




    }

    public void Open(){
//        SA_Draw_Move("숨김버튼", 0, -200);
//        SA_Draw_Move("숨김버튼화살표", 0, -200);
//        SA_Draw_Sprite_Change("숨김버튼화살표", "sa_engine_log_down");

    }

    public void Close(){
//        SA_Draw_Move("숨김버튼", 0, 200);
//        SA_Draw_Move("숨김버튼화살표", 0, 200);
//        SA_Draw_Sprite_Change("숨김버튼화살표", "sa_engine_log_up");
    }


    public void test(){
        //x++;
    }
}
