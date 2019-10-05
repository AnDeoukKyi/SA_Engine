package com.example.an.sa_engine.SA_ENGINE.Sys.Engine;

import android.content.Context;
import android.content.res.Resources;
import com.example.an.sa_engine.SA_ENGINE.Object.Obj.ObjM.SA_ObjM;
import com.example.an.sa_engine.SA_ENGINE.Object.Obj.ObjM.SA_ObjMaster;
import com.example.an.sa_engine.SA_ENGINE.Sys.Option.FlagManager.SA_Engine_FlagManager;

import java.util.HashMap;


public class SA_Engine{//singleton

    public SA_ObjMaster objMaster;
    private HashMap<String, Integer> hashMap_Flag = new HashMap<>();
    private Context context;
    private Resources resources;



    public void Init(Context context){
        this.context = context;
        this.resources = context.getResources();
        objMaster = new SA_ObjMaster();//ObjMaster생성
        hashMap_Flag = new SA_Engine_FlagManager().getHashMapFlag(this);//FlagMaster 생성



    }


    public void addObjM(SA_ObjM objM){
        objMaster.add(objM);
    }

    public void deleteObjM(SA_ObjM objM){
        objMaster.delete(objM);
    }

    public HashMap<String, Integer> getHashMap_Flag() {
        return hashMap_Flag;
    }

    public int getFlag(String flag, String subFlag) {
        hashMap_Flag = hashMap_Flag;
        return hashMap_Flag.get(flag + "_" + subFlag);
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
