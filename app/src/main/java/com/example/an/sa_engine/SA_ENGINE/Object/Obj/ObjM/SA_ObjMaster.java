package com.example.an.sa_engine.SA_ENGINE.Object.Obj.ObjM;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class SA_ObjMaster {
    private HashMap<Integer, SA_ObjM> HashMap_ObjM;
    public SA_ObjMaster() {
        HashMap_ObjM = new HashMap<>();
    }

    public void add(SA_ObjM objM){
        int index = 0;
        while(true){
            if(!HashMap_ObjM.containsKey(index)) {//0부터 해당키 있는지 탐색후 없으면 추가
                HashMap_ObjM.put(index, objM);//리스트에 추가
                return;
            }
            index++;
        }
    }

    private int search(SA_ObjM objM){//탐색
        Iterator iterator = HashMap_ObjM.entrySet().iterator();
        while (iterator.hasNext()) {//전체 탐색
            Entry entry = (Entry)iterator.next();
            if(entry.getValue() == objM)//value가 동일하면 key(index)반환
                return (int)(entry.getKey());
        }
        return 0;
    }

    public void delete(SA_ObjM objM){
        HashMap_ObjM.remove(search(objM));
    }
}
