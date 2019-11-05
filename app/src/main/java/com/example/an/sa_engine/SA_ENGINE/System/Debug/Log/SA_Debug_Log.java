package com.example.an.sa_engine.SA_ENGINE.System.Debug.Log;

import android.util.Log;

import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;

public class SA_Debug_Log extends SA_Obj{


    private SA_Debug_Log_Manager logManager;

    private SA_Debug_Log_Scroll logScroll;


    @Override
    public void _Create(String name) {
        super._Create("로그");
        SA_RootParent(true);
        logScroll = (SA_Debug_Log_Scroll)SA_Child(new SA_Debug_Log_Scroll());
    }

    @Override
    public void _Draw() {
        super._Draw();

//        SA_Draw_Sprite("숨김버튼화살표", "sa_engine_arrow_up", 10, 0, 0, SA_CAMERA_CENTERX, SA_CAMERA_ENDY, 30, 30, "camera, pos=b/c");
        //SA_Draw_Rect("숨김버튼", 10, 100, 100, 100, 100, "red", "thickness=3, incolor=black,camera").changeRoundRect(30);
//        SA_Draw_Circle("원", 10, 100, 100, 150, "red");
//        SA_Draw_Line("선", 12, 100, 100, 200, 200, "red", 3);
        //SA_Draw_Text("글자", 10, 300, 300, "asdfasdf!", "red", 30, "background=black");
        //SA_Draw_Text("글자", 10, 500, 500, "asdaefaefaefaefaefaefaef", "red", 30, "width=100,pos=m/c");
        //SA_Draw_RoundRect("숨김버튼", 15, 100, 100, 100, 100, 30, "red", "thickness=3,incolor=black");
        //테두리만 그리는 경우 thickness
        //테두리 안쪽 다그리는 경우 thickness incolor
        //안쪽만 그리는 경우


        //"edge, incolor=#121313
        //"edge"
        //SA_Mask("숨김버튼", SA_MASK_RECT);
        //SA_Click("숨김버튼", new SA_Debug_Log_Click());


        //SA_Draw_Text_Point_Camera("adsfasdfasdf", 10, 300, 300, "adsfadsfadsfy", SA_COLOR_BLACK, 40);



//        SA_Draw_Sprite_Camera_Center("asdf", "sprite0", 10, 0, 0, 0, 0, 200, 200);
//        SA_Mask("asdf", SA_MASK_AUTO);
//        SA_Click("asdf", new SA_Debug_Log_Click());

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

    @Override
    public void _Start() {
        super._Start();
        Log.e("asdfff", "start실행");
    }

    public void Open(){
        SA_Draw_Move("숨김버튼", 0, -200);
        SA_Draw_Move("숨김버튼화살표", 0, -200);
        SA_Draw_Sprite_Change("숨김버튼화살표", "sa_engine_arrow_down");
        logManager.Open();

    }

    public void Close(){
        SA_Draw_Move("숨김버튼", 0, 200);
        SA_Draw_Move("숨김버튼화살표", 0, 200);
        SA_Draw_Sprite_Change("숨김버튼화살표", "sa_engine_arrow_up");
        logManager.Close();
    }

}
