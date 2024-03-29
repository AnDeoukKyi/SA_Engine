package com.example.an.sa_engine.SA_ENGINE.System.Debug.Log;

import android.util.Log;

import com.example.an.sa_engine.SA_ENGINE.Object.Click.SA_Click;

public class SA_Debug_Log_Click extends SA_Click {

    private boolean click = false;

    @Override
    public void Click(Object targetObj) {
        super.Click(targetObj);

        if(click) {
            ((SA_Debug_Log) targetObj).Close();
            click = false;
        }
        else {
            ((SA_Debug_Log) targetObj).Open();
            click = true;
        }
    }

    @Override
    public void Drag(Object targetObj) {
        super.Drag(targetObj);
    }
}
