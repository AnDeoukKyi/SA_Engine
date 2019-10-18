package com.example.an.sa_engine.SA_ENGINE.System.Debug.Log;

import com.example.an.sa_engine.SA_ENGINE.Object.Draw.SA_Draw;
import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;

public class SA_Debug_Log extends SA_Obj{


    public SA_Debug_Log(String name, Object parent) {

        SA_Create(name, null);//인스턴스 생성(이름"name")
        //SA_Deep(5);


        SA_Draw_Camera_Line("선", 9, SA_CAMERA_CENTERX, 0, SA_CAMERA_CENTERX, SA_CAMERA_CENTERY, SA_COLOR_BLACK, 3);

        SA_Draw_Camera_SpriteCenter("위쪽화살표버튼", "sa_engine_log_up", 10, 0, 0, SA_CAMERA_CENTERX, SA_CAMERA_ENDY-10, 50, 50);
        SA_Draw_Camera_RectCenter("사각형버튼", 9, SA_EDGE, SA_CAMERA_CENTERX, SA_CAMERA_ENDY-5, 100, 20, SA_COLOR_BLACK, 3);
        SA_Mask("사각형버튼", SA_MASK_AUTO);
                //SA_MASK_CIRCLE
                //SA_MASK_AUTO



        //SA_Draw_SetDeep("위쪽화살표버튼", 10);
        //SA_Draw_Camera_Rect("사각형버튼", 9, EDGE, 0, 0, 200, 100, 255, BLACK);
        //SA_Draw_Camera_RectEdge("사각형버튼", 9, EDGE, 0, 0, 200, 100, 255, BLACK);

        //SA_Draw_Sprite("사각형버튼", "sa_engine_log_up_square", 9, 0, 0, 0, 0, 200, 100, 255);
        //SA_Draw_Text(false, SA_CenterX, SA_CenterY, );
        //draw_Text();
        int a= 10;
        //SA_Child(new Hand("손", this));


    }
}
