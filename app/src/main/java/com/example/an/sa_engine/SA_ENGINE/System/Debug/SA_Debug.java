package com.example.an.sa_engine.SA_ENGINE.System.Debug;


import com.example.an.sa_engine.SA_ENGINE.System.Debug.Grid.SA_Debug_Grid;
import com.example.an.sa_engine.SA_ENGINE.System.Debug.Log.SA_Debug_Log;
import com.example.an.sa_engine.SA_ENGINE.System.Debug.Log.SA_Debug_Log_Data;
import com.example.an.sa_engine.SA_ENGINE.System.Debug.Menu.SA_Debug_Menu;
import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;

import java.util.HashMap;


public class SA_Debug {

    private SA_Engine engine;

    private SA_Debug_Log debug_log;
    private SA_Debug_Grid debug_Instance;
    private SA_Debug_Menu debug_menu;



    private HashMap<Integer, SA_Debug_Log_Data> hashMap_LogData = new HashMap<>();
    private int logIndex = 0;


    public SA_Debug(SA_Engine engine) {
        this.engine = engine;




        //아래 로그창
        debug_menu = new SA_Debug_Menu();
        debug_log = new SA_Debug_Log();

        debug_Instance = new SA_Debug_Grid();

//        new Thread(new Runnable() {
//            public void run() {
//                while (true) {
//                    try {
//                        debug_log.test();
//                        Thread.sleep(10);
//                    } catch (Throwable t) {
//                    }
//                }
//            }
//        }).start();
        //왼쪽위 인스턴스 이름
        //오른쪽 인스턴스 리스트
        //왼쪽 리스트 인스턴스 정보창
        //맨위 재생창
    }

    public void Log(Object text){
        hashMap_LogData.put(logIndex++, new SA_Debug_Log_Data(text.toString()));
    }


}
