package com.example.an.sa_engine.SA_ENGINE.System.Engine;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;

import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_ObjMaster;
import com.example.an.sa_engine.SA_ENGINE.System.Debug.SA_Debug;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;
import com.example.an.sa_engine.SA_ENGINE.System.Option.User.SA_UserOptionManager;
import com.example.an.sa_engine.SA_ENGINE.System.Room.SA_RoomManager;

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


    //click
    private Object clickObj;

    //

    private SA_ObjMaster objMaster;

    private String packageName;






    //-----------------------확실

    public void Init_1(Context context){
        this.context = context;
        this.resources = context.getResources();
        hashMap_Flag = new HashMap<>();
        new SA_UserOptionManager().getHashMapFlag(this);
        objMaster = new SA_ObjMaster(this);
        packageName = context.getPackageName();

    }

    public void Init_2(){
        DisplayMetrics metrics = resources.getDisplayMetrics();
        windowWidth = metrics.widthPixels;
        windowHeight = metrics.heightPixels;

        //----------------------USER OPTION까지 가져옴

        CheckWindowSize();


        //화면출력해야됨



        DebugMode(CheckDebugMode());


    }


    //터치
    public void SA_Touch(int touchFlag, int x, int y){

        Object touch = Touch_Obj(x, y);

        Log.e("asdf", Integer.toString(x) + "," + Integer.toString(y));

        switch(touchFlag){
            case SA_FLAG.ENGINE_CLICK_DOWN:
                clickObj = touch;
                //flag 변경(focus)
                break;
            case SA_FLAG.ENGINE_CLICK_UP:
                clickObj = null;
                //flag 변경(focus)
                break;
            case SA_FLAG.ENGINE_CLICK_DRAG:
                break;
        }


    }

    private Object Touch_Obj(int x, int y){
        //find obj

        return null;
    }

    //





    public int SA_AddObj(Object obj, boolean child){
        return objMaster.add(obj, child);
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
        if(getFlag("USER_VIEW_WINDOWSIZE_X") != windowWidth || getFlag("USER_VIEW_WINDOWSIZE_Y") != windowHeight){
            //Log.r("User-Option-Option.class의 View_WindowSize(0 0)을 View_WindowSize(1230, 300)으로 변경해주세요.");
            //올스톱
        }
        else{

            new SA_RoomManager();//룸메니저 생성->룸시작함
        }
    }

    public SA_ObjMaster getObjMaster() {
        return objMaster;
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

    public String getPackageName() {
        return packageName;
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
