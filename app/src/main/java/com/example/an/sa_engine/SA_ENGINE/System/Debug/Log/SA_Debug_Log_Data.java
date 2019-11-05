package com.example.an.sa_engine.SA_ENGINE.System.Debug.Log;


public class SA_Debug_Log_Data {

    private String systemType;
    private String targetobject;
    private String text;


    public SA_Debug_Log_Data(String text) {
        this.text = text;
    }

    public String getSystemType() {
        return systemType;
    }

    public String getTargetobject() {
        return targetobject;
    }

    public String getText() {
        return text;
    }
}
