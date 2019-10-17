package com.example.an.sa_engine.SA_ENGINE.System.Option.User;

import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.User.Option.Option;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class SA_UserOptionManager {

    private HashMap<String, Integer> hashMap_Flag;
    private SA_Engine engine;

    public void getHashMapFlag(SA_Engine engine) {
        this.engine = engine;
        hashMap_Flag = new HashMap<>();
        addFlag("USER", new Option().getFlag());
        engine.setHashMap_Flag(hashMap_Flag);
    }

    private void addFlag(String type, HashMap<String, Integer> hashMap) {
        Iterator iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()) {//전체 탐색
            Entry entry = (Entry)iterator.next();
            hashMap_Flag.put("USER_" + (String)(entry.getKey()), (int)(entry.getValue()));
        }
    }

}
