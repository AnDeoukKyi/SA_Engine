package com.example.an.sa_engine.SA_ENGINE.System.Debug.Log;

import com.example.an.sa_engine.SA_ENGINE.Object.Scroll.SA_Scroll;

public class SA_Debug_Log_Scroll extends SA_Scroll {


    @Override
    public void _Create(String name) {
        super._Create(name);
        Init(SA_SCROLL_VERTICAL, 200, 200);
        ViewScrollBar(20);
    }

    @Override
    public void _Draw() {
        super._Draw();
    }
}
