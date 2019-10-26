package com.example.an.sa_engine.SA_ENGINE.System.Debug.Log;

import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;

public class SA_Debug_Log2 extends SA_Obj{


    @Override
    public void _Create(String name) {
        super._Create("디버그로그2");
        //이름, 태그 설정

        x = 300;
        y = 300;

    }

    @Override
    public void _Draw() {
        super._Draw();
        SA_Draw_Sprite_Center("asdf2", "sprite0", 10, 0, 0, 0, 0, 200, 200);
        SA_Mask("asdf2", SA_MASK_AUTO);
        SA_Click("asdf2", new SA_Debug_Log_Click());

        int a = 10;


//        SA_Draw_Line_Camera_Point("선", 9, SA_CAMERA_CENTERX, 0, SA_CAMERA_CENTERX, SA_CAMERA_ENDY, SA_COLOR_BLACK, 3);
//        //SA_Draw_Line_Camera_Length
//        SA_Draw_Sprite_Camera_Center("위쪽화살표버튼", "sa_engine_log_up", 10, 0, 0, SA_CAMERA_CENTERX, SA_CAMERA_ENDY-10, 50, 50);
//        SA_Draw_Rect_Camera_Center("사각형버튼", 9, SA_EDGE, SA_CAMERA_CENTERX, SA_CAMERA_ENDY-5, 100, 20, SA_COLOR_BLACK, 3);
//        SA_Mask("사각형버튼", SA_MASK_AUTO);
//        //SA_MASK_CIRCLE
        //SA_MASK_AUTO


        //SA_Click("사각형버튼", new SA_Debug_Log_Click(this));



        //SA_Deep(5);



        //SA_Draw_SetDeep("위쪽화살표버튼", 10);
        //SA_Draw_Camera_Rect("사각형버튼", 9, EDGE, 0, 0, 200, 100, 255, BLACK);
        //SA_Draw_Camera_RectEdge("사각형버튼", 9, EDGE, 0, 0, 200, 100, 255, BLACK);

        //SA_Draw_Sprite("사각형버튼", "sa_engine_log_up_square", 9, 0, 0, 0, 0, 200, 100, 255);
        //SA_Draw_Text(false, SA_CenterX, SA_CenterY, );
        //draw_Text();
        //SA_Child(new Hand("손", this));
    }

    public void Open(){

    }

    public void Close(){

    }


    public void test(){
        //x++;
    }
}
