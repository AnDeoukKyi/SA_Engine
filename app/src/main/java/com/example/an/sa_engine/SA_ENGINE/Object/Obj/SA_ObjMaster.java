package com.example.an.sa_engine.SA_ENGINE.Object.Obj;

import com.example.an.sa_engine.SA_ENGINE.Sys.Engine.SA_Engine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class SA_ObjMaster {

    private SA_Engine engine;
    private HashMap<Integer, SA_Obj> HashMap_Obj;

    public SA_ObjMaster(SA_Engine engine) {
        this.engine = engine;
        HashMap_Obj = new HashMap<>();
        engine.setHashMap_Obj(HashMap_Obj);
    }

    public void add(SA_Obj obj) {
        int index = 1;
        while(true){
            if(!HashMap_Obj.containsKey(index)) {//0부터 해당키 있는지 탐색후 없으면 추가
                HashMap_Obj.put(index, obj);//리스트에 추가
                break;
            }
            index++;
        }//hashmap등록

        //부모자식관계 설정해야됨
        //부모설정

        //자식설정



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
