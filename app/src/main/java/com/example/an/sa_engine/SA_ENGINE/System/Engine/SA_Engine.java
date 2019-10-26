package com.example.an.sa_engine.SA_ENGINE.System.Engine;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;

import com.example.an.sa_engine.SA_ENGINE.Object.Draw.SA_Draw;
import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;
import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_ObjMaster;
import com.example.an.sa_engine.SA_ENGINE.System.Debug.SA_Debug;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;
import com.example.an.sa_engine.SA_ENGINE.System.Option.User.SA_UserOptionManager;
import com.example.an.sa_engine.SA_ENGINE.System.Room.SA_RoomManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    private int maskLength = 100;

    private Object clickObj;


    //

    private SA_ObjMaster objMaster;

    private String packageName;



    public int cameraX = 100, cameraY = 100;



    //-----------------------확실

    public void Init_1(Context context){
        this.context = context;
        this.resources = context.getResources();
        hashMap_Flag = new HashMap<>();
        new SA_UserOptionManager().getHashMapFlag(this);
        objMaster = new SA_ObjMaster(this);
        packageName = context.getPackageName();
        //Thread();
    }

    public void Init_2(){
        DisplayMetrics metrics = resources.getDisplayMetrics();
        windowWidth = metrics.widthPixels;
        windowHeight = metrics.heightPixels;
        //----------------------USER OPTION까지 가져옴
        CheckWindowSize();
        DebugMode(CheckDebugMode());

        //화면출력해야됨

//        new Thread(new Runnable() {
//            public void run() {
//                while (true) {
//                    try {
//                        cameraX--;
//                        cameraY--;
//                        Thread.sleep(10);
//                    } catch (Throwable t) {
//                    }
//                }
//            }
//        }).start();





    }
//
//    public void Thread(){
//        new Thread(new Runnable() {
//            public void run() {
//                while (true) {
//                    try {
//                        objMaster.posUpdate();
//                        objMaster.maskUpdate();
//                        Thread.sleep(10);
//                    } catch (Throwable t) {
//                    }
//                }
//            }
//        }).start();
//    }


    public void addClickMask(Object obj, SA_Draw draw, Object clickClass){
        //object, draw, clickListener만 전달
        //this, drawManager.search(name), clickClass



//        try {
//            Method method = SA_Obj.class.getClass().getDeclaredMethod("SA_Engine_Click", Object.class, String.class);
//            method.setAccessible(true);
//            method.invoke(obj, clickClass, "Click");
//            method.invoke(obj, clickClass, "Drag");
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

    }



    boolean touch = false;
    boolean drag = false;

    int preClickX = -100, preClickY = -100;

    //터치
    public void SA_Touch(int touchFlag, int clickX, int clickY){

        //Object touch = Touch_Obj(clickX, clickY);


        //카메라 다뒤지고 없으면 절대좌표 뒤져야됨
        //카메라 0, 0이라 가정하고
        //x/maskLength
        //y/maskLength
        //해보고 없으면 절대좌표로 바꿔서 ㄱ
        switch(touchFlag){
            case SA_FLAG.ENGINE_CLICK_DOWN:
                if(preClickX != clickX && preClickY != clickY){
                    preClickX = clickX;
                    preClickY = clickY;
                    this.touch = true;
                }
                //flag 변경(focus)
                break;
            case SA_FLAG.ENGINE_CLICK_UP:
                if(!this.drag){
                    preClickX = -100;
                    preClickY = -100;
                    this.touch = false;
                    Log.e("클릭함", Integer.toString(clickX) + "," + Integer.toString(clickY));
                    Touch_Obj(clickX, clickY);
                }
                else{
                    preClickX = -100;
                    preClickY = -100;
                    this.touch = false;
                    this.drag = false;
                    Log.e("드래그끝", Integer.toString(clickX) + "," + Integer.toString(clickY));
                }


                //flag 변경(focus)
                break;
            case SA_FLAG.ENGINE_CLICK_DRAG:
                if(this.touch)
                    if(preClickX != clickX && preClickY != clickY){
                        preClickX = clickX;
                        preClickY = clickY;
                        drag = true;
                        //드래그
                        //Log.e("드래그중", Integer.toString(clickX) + "," + Integer.toString(clickY));
                    }
                break;
        }



        //터치쪽에서 해야될 일
        //터치된 좌표의 Object가 필요함
    }

    private Object Touch_Obj(int clickX, int clickY){
        //find obj
        objMaster.click(clickX, clickY);

        return null;
    }





    public int SA_GetEmptyID(){
        return objMaster.getEmtpyID();
    }

    public void SA_AddRootObj(Object obj){
        objMaster.addRoot(obj);
    }


    public void SA_AddObj(Object obj){
        objMaster.add(obj);
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
