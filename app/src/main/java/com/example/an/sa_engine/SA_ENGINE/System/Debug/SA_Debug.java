package com.example.an.sa_engine.SA_ENGINE.System.Debug;


import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.SA_ENGINE.System.Room.SA_StartRoom;

import java.util.HashMap;


public class SA_Debug {

    private SA_Engine engine;
    private RelativeLayout debugLayout;

    private ListView lv_Log;
    private HashMap<String, String> HashMap_Log_Index, HashMap_Log_time, HashMap_Log_text;


    public SA_Debug(SA_Engine engine) {
        this.engine = engine;







        debugLayout = ((SA_StartRoom)engine.getContext()).getMain();
        //왼쪽위 인스턴스 이름
        //오른쪽 인스턴스 리스트
        //왼쪽 리스트 인스턴스 정보창
        //아래 로그창
        SetLog();
        //맨위 재생창
    }

    private void SetLog(){//-------------------------------------------------------------------------진행상황
        lv_Log = new ListView(engine.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(100, 100);
        layoutParams.setMargins(0, 0, 0, 0);
        //tv.setLayoutParams(layoutParams);



    }


}
