package com.example.an.sa_engine.SA_ENGINE.Sys.Option.FlagManager;

import com.example.an.sa_engine.SA_ENGINE.Sys.Engine.SA_Engine;
import com.example.an.sa_engine.User.Option.Option;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class SA_Engine_FlagManager {

    private HashMap<String, Integer> hashMap_Flag;
    private SA_Engine engine;

    public HashMap<String, Integer> getHashMapFlag(SA_Engine engine) {
        this.engine = engine;
        hashMap_Flag = engine.getHashMap_Flag();
        addDefaultFlag();


        addFlag("USER", new Option().getFlag());


        return hashMap_Flag;
    }


    private void addDefaultFlag() {
        String[] flag = stringsArray("FLAG");
        for (int i = 0; i < flag.length; i++) {
            String[] subFlag = stringsArray(flag[i]);
            {
                for (int j = 0; j < subFlag.length; j++) {
                    String[] f = subFlag[j].split(",");
                    hashMap_Flag.put(flag[i] + "_" + f[0], Integer.parseInt(f[1]));
                }
            }
        }
    }

    private void addFlag(String type, HashMap<String, Integer> hashMap) {
        Iterator iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()) {//전체 탐색
            Entry entry = (Entry)iterator.next();
            hashMap_Flag.put("USER_" + (String)(entry.getKey()), (int)(entry.getValue()));
        }
    }


    private String[] stringsArray(String subType) {
        String[] sub = engine.getResources().getStringArray(getRID("array", subType));
        return sub;
    }

    private int getRID(String type, String name) {
        return engine.getResources().getIdentifier(engine.getContext().getPackageName().toString() + ":" + type + "/" + name, null, null);

    }
}
