package com.example.an.sa_engine.SA_ENGINE.Object.Obj;

import android.graphics.Canvas;

import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;

import java.util.ArrayList;
import java.util.HashMap;

public class SA_ObjMaster {

    private SA_Engine engine;
    private SA_ObjManager objManager;
    private HashMap<Integer, Object> HashMap_Obj;

    public SA_ObjMaster(SA_Engine engine) {
        this.engine = engine;
        objManager = new SA_ObjManager();
        HashMap_Obj = new HashMap<>();
    }

    public int add(Object obj, boolean child) {
        int index = 1;
        while(true){
            if(!HashMap_Obj.containsKey(index)) {//0부터 해당키 있는지 탐색후 없으면 추가
                HashMap_Obj.put(index, obj);//리스트에 추가
                if(!child)
                    objManager.add(obj);
                break;
            }
            index++;
        }
        return index;
    }

    public void draw(Canvas canvas) {
        objManager.draw(canvas);
    }


//    private int search(SA_Obj obj){
//        Iterator iterator = HashMap_Obj.entrySet().iterator();
//        while (iterator.hasNext()) {//전체 탐색
//            Entry entry = (Entry)iterator.next();
//            if(entry.getValue() == obj)//value가 동일하면 key(index)반환
//                return (int)(entry.getKey());
//        }
//        return 0;
//    }//없으면 0 있으면 index


//
//    public void add(SA_ObjM objM){
//        int index = 0;
//        while(true){
//            if(!HashMap_ObjM.containsKey(index)) {//0부터 해당키 있는지 탐색후 없으면 추가
//                HashMap_ObjM.put(index, objM);//리스트에 추가
//                return;
//            }
//            index++;
//        }
//    }
//
//    private int search(SA_ObjM objM){//탐색
//        Iterator iterator = HashMap_ObjM.entrySet().iterator();
//        while (iterator.hasNext()) {//전체 탐색
//            Entry entry = (Entry)iterator.next();
//            if(entry.getValue() == objM)//value가 동일하면 key(index)반환
//                return (int)(entry.getKey());
//        }
//        return 0;
//    }
//
//    public void delete(SA_ObjM objM){
//        HashMap_ObjM.remove(search(objM));
//    }
}
