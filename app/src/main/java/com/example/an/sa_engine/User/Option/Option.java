package com.example.an.sa_engine.User.Option;

import com.example.an.sa_engine.SA_ENGINE.System.Option.User.SA_UserOption;

public class Option extends SA_UserOption {

    public Option() {
        View_WindowSize(0, 0);//개발 AVD윈도우사이즈
        DEBUG_MODE(true);
        View_Type(SA_LANDSCAPE);//가로모드, 세로모드(portrait,landscape)
        DEBUG_LOG_CREATEOBJ(true);//Debug시 Obj생성시 Log출력



    }

}
