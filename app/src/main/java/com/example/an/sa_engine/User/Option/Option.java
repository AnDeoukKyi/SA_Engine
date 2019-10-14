package com.example.an.sa_engine.User.Option;

import com.example.an.sa_engine.SA_ENGINE.System.Option.User.SA_UserOption;

public class Option extends SA_UserOption {

    public Option() {
        View_Type(landscape);//가로모드, 세로모드(portrait,landscape)
        //개발 AVD윈도우사이즈
        View_WindowSize(0, 0);
        DEBUG_MODE(true);
        DEBUG_LOG_CREATEOBJ(true);//Debug시 Obj생성시 Log출력
    }

}
