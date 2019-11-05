package com.example.an.sa_engine.SA_ENGINE.System.Debug.Log;

import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;

public class SA_Debug_Log_Manager extends SA_Obj{


    private SA_Debug_Log_Scroll logScroll;

    @Override
    public void _Create(String name) {
        super._Create("로그매니저");

    }

    @Override
    public void _Draw() {
        super._Draw();
//        SA_Draw_Rect_Length_Camera("로그매니저", 10, SA_FILLEDGE, SA_CAMERA_CENTERX + 400, SA_CAMERA_ENDY, 20, 200, SA_COLOR_GRAY, SA_COLOR_BLACK, 3);
//        SA_Draw_Rect_Center_Camera("로그1", 10, SA_FILLEDGE, SA_CAMERA_CENTERX, SA_CAMERA_ENDY + 20, 800, 40, SA_COLOR_GRAY, SA_COLOR_BLACK, 3);
//        SA_Draw_Rect_Center_Camera("로그2", 10, SA_FILLEDGE, SA_CAMERA_CENTERX, SA_CAMERA_ENDY + 60, 800, 40, SA_COLOR_GRAY, SA_COLOR_BLACK, 3);
//        SA_Draw_Rect_Center_Camera("로그3", 10, SA_FILLEDGE, SA_CAMERA_CENTERX, SA_CAMERA_ENDY + 100, 800, 40, SA_COLOR_GRAY, SA_COLOR_BLACK, 3);
//        SA_Draw_Rect_Center_Camera("로그4", 10, SA_FILLEDGE, SA_CAMERA_CENTERX, SA_CAMERA_ENDY + 140, 800, 40, SA_COLOR_GRAY, SA_COLOR_BLACK, 3);
//        SA_Draw_Rect_Center_Camera("로그5", 10, SA_FILLEDGE, SA_CAMERA_CENTERX, SA_CAMERA_ENDY + 180, 800, 40, SA_COLOR_GRAY, SA_COLOR_BLACK, 3);




    }

    public void Open(){

//        SA_Draw_Move("로그매니저", 0, -200);
//        SA_Draw_Move("로그1", 0, -200);
//        SA_Draw_Move("로그2", 0, -200);
//        SA_Draw_Move("로그3", 0, -200);
//        SA_Draw_Move("로그4", 0, -200);
//        SA_Draw_Move("로그5", 0, -200);

    }

    public void Close(){

//        SA_Draw_Move("로그매니저", 0, 200);
//        SA_Draw_Move("로그1", 0, 200);
//        SA_Draw_Move("로그2", 0, 200);
//        SA_Draw_Move("로그3", 0, 200);
//        SA_Draw_Move("로그4", 0, 200);
//        SA_Draw_Move("로그5", 0, 200);
    }
}
