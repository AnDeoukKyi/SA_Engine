package com.example.an.sa_engine.SA_ENGINE.System.Debug.Log;

import android.util.Log;

import com.example.an.sa_engine.SA_ENGINE.Object.Click.SA_Click;

public class SA_Debug_Log_Click extends SA_Click {


    @Override
    public void Click(Object targetObj) {
        super.Click(targetObj);
        Log.e("asdfasdfasdf", targetObj.getClass().toString());
    }

    @Override
    public void Drag(Object targetObj) {
        super.Drag(targetObj);
    }
}
