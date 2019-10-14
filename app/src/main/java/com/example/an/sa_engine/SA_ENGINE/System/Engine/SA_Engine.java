package com.example.an.sa_engine.SA_ENGINE.System.Engine;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;
import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_ObjMaster;
import com.example.an.sa_engine.SA_ENGINE.System.Debug.SA_Debug;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;
import com.example.an.sa_engine.SA_ENGINE.System.Option.User.SA_UserFlag;
import com.example.an.sa_engine.SA_ENGINE.System.Room.SA_StartRoom;

import java.util.HashMap;


public class SA_Engine{//singleton

    //----------------------확실
    private HashMap<String, Integer> hashMap_Flag;
    private Context context;
    private Resources resources;

    //WindowSize
    private boolean play = false;
    private boolean printWindowSize = false;
    private int windowWidth, windowHeight;

    //-------------------디버깅모드 수정중
    private boolean debugMode = false;
    private SA_Debug debug;


        //

    private SA_ObjMaster objMaster;






    //-----------------------확실

    public void Init(Context context){
        this.context = context;
        this.resources = context.getResources();
        hashMap_Flag = new HashMap<>();
        new SA_UserFlag().getHashMapFlag(this);

        DisplayMetrics metrics = resources.getDisplayMetrics();
        windowWidth = metrics.widthPixels;
        windowHeight = metrics.heightPixels;

        //WindowSize출력
        CheckWindowSize();

        //----------------------USER OPTION까지 가져옴
        DebugMode(CheckDebugMode());





        objMaster = new SA_ObjMaster(this);








    }




    public int SA_AddObj(Object obj){
        int num = objMaster.add(obj);
        return num;
    }




    private void DebugMode(boolean flag){
        debugMode = flag;
        if(debugMode){
            debug = new SA_Debug(this);
        }
    }

    private boolean CheckDebugMode(){
        return (getFlag("USER_DEBUG_MODE") == SA_FLAG.USER_DEBUG_MODE_YES)? true: false;
    }




    private void CheckWindowSize(){
        if(getFlag("VIEW_WINDOWSIZE_X") == 0 || getFlag("VIEW_WINDOWSIZE_Y") == 0){

        }
    }


    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public boolean isPrintWindowSize() {
        return printWindowSize;
    }


    //----------------------------------------

    public void setHashMap_Flag(HashMap<String, Integer> hashMap_Flag) {
        this.hashMap_Flag = hashMap_Flag;
    }

    public int getFlag(String flag) {
        return hashMap_Flag.get(flag);
    }

    public Context getContext() {
        return context;
    }

    public Resources getResources() {
        return resources;
    }

    //엔진 호출
    //ex)SA_Engine engine = SA_Engine.getEngine();
    private static class EngineHolder {
        public static final SA_Engine engine = new SA_Engine();
    }

    public static SA_Engine getEngine() {
        return EngineHolder.engine;
    }
}
