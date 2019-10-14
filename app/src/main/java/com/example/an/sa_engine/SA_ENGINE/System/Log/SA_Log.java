package com.example.an.sa_engine.SA_ENGINE.System.Log;

import android.util.Log;

public class SA_Log {

    protected void Log(String tag, String str){
        Log.e(tag, str);
    }

    protected void Log(String tag, Boolean flag){
        Log.e(tag, flag.toString());
    }

    protected void Log(String tag, int num){
        Log.e(tag, Integer.toString(num));
    }

    protected void Log(String tag, double num){
        Log.e(tag, Double.toString(num));
    }

    protected void Log(String tag, float num){
        Log.e(tag, Float.toString(num));
    }
}
