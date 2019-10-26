package com.example.an.sa_engine.SA_ENGINE.System.Debug;


import com.example.an.sa_engine.SA_ENGINE.System.Debug.Log.SA_Debug_Log;
import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;

import java.util.HashMap;


public class SA_Debug {

    private SA_Engine engine;

    private SA_Debug_Log debug_log;




    private HashMap<String, String> HashMap_Log_Index, HashMap_Log_time, HashMap_Log_text;


    public SA_Debug(SA_Engine engine) {
        this.engine = engine;


        //아래 로그창
        debug_log = new SA_Debug_Log();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        debug_log.test();
                        Thread.sleep(10);
                    } catch (Throwable t) {
                    }
                }
            }
        }).start();
        //왼쪽위 인스턴스 이름
        //오른쪽 인스턴스 리스트
        //왼쪽 리스트 인스턴스 정보창
        //맨위 재생창
    }



}
