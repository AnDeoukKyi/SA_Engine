package com.example.an.sa_engine.SA_ENGINE.System.Debug.Menu;

import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;

public class SA_Debug_Menu extends SA_Obj{

    @Override
    public void _Create(String name) {
        super._Create("메뉴");
        SA_RootParent(true);
    }

    @Override
    public void _Draw() {
        super._Draw();


//        for(int i = 0; i<=SA_CAMERA_ENDX/100; i++){
//            SA_Draw_Line_Point("선", 12, i*100, 0, i*100, SA_CAMERA_ENDY, SA_COLOR_RED, 3);
//        }
//
//        for(int i = 0; i<=SA_CAMERA_ENDY/100; i++){
//            SA_Draw_Line_Point("선", 12, 0, i*100, SA_CAMERA_ENDX, i*100, SA_COLOR_RED, 3);
//        }

//        SA_Draw_Sprite_Length_Camera("메뉴버튼화살표", "sa_engine_plus", 11, 0, 0, 0, 0, 50, 50);
//        SA_Draw_Rect_Length_Camera("메뉴버튼", 10, SA_FILLEDGE, 0, 0, 50, 50, SA_COLOR_GRAY, SA_COLOR_BLACK, 3);
//        SA_Mask("메뉴버튼", SA_MASK_RECT);
//        SA_Click("메뉴버튼", new SA_Debug_Menu_Click());




        //SA_Draw_Sprite_Camera_Center("숨김버튼화살표", "sa_engine_arrow_right", 10, 0, 0, SA_CAMERA_CENTERX, SA_CAMERA_ENDY-20, 100, 60);
        //SA_Draw_Rect_Camera_Point("숨김버튼", 10, SA_EDGE, SA_CAMERA_CENTERX, SA_CAMERA_ENDY-20, 200, 40, SA_COLOR_BLACK, 3);
        //SA_Mask("숨김버튼", SA_MASK_RECT);
        //SA_Click("숨김버튼", new SA_Debug_Log_Click());



    }

    public void MenuOpen(){

        //SA_Draw_Rect_Length_Camera("메뉴", 10, SA_FILLEDGE, 0, 50, 400, SA_CAMERA_ENDY-50, SA_COLOR_GRAY, SA_COLOR_BLACK, 3);

//        SA_Draw_Move("숨김버튼", 0, -200);
//        SA_Draw_Move("숨김버튼화살표", 0, -200);
//        SA_Draw_Sprite_Change("숨김버튼화살표", "sa_engine_log_down");

    }

    public void MenuClose(){

        //SA_Draw_Destroy("메뉴");

//        SA_Draw_Move("숨김버튼", 0, 200);
//        SA_Draw_Move("숨김버튼화살표", 0, 200);
//        SA_Draw_Sprite_Change("숨김버튼화살표", "sa_engine_log_up");
    }


    public void test(){
        //x++;
    }
}
