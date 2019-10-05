package com.example.an.sa_engine.SA_ENGINE.Sys.Engine;

import com.example.an.sa_engine.SA_ENGINE.Object.Obj.ObjM.SA_ObjM;
import com.example.an.sa_engine.SA_ENGINE.Object.Obj.ObjM.SA_ObjMaster;


public class SA_Engine {//singleton

    private SA_ObjMaster objMaster;

    public SA_Engine() {
        Init();//설정 초기화

    }


    private void Init(){
        objMaster = new SA_ObjMaster();//ObjMaster생성
    }


    public void addObjM(SA_ObjM objM){
        objMaster.add(objM);
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
