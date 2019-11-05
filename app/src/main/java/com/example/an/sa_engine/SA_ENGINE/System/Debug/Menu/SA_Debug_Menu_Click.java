package com.example.an.sa_engine.SA_ENGINE.System.Debug.Menu;

import com.example.an.sa_engine.SA_ENGINE.Object.Click.SA_Click;
import com.example.an.sa_engine.SA_ENGINE.System.Debug.Log.SA_Debug_Log;

public class SA_Debug_Menu_Click extends SA_Click {

    private boolean click = false;

    @Override
    public void Click(Object targetObj) {
        super.Click(targetObj);

        if(click) {
            ((SA_Debug_Menu) targetObj).MenuClose();
            click = false;
        }
        else {
            ((SA_Debug_Menu) targetObj).MenuOpen();
            click = true;
        }
    }

    @Override
    public void Drag(Object targetObj) {
        super.Drag(targetObj);
    }
}
