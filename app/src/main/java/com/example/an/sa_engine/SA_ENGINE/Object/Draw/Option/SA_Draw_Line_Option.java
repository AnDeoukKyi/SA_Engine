package com.example.an.sa_engine.SA_ENGINE.Object.Draw.Option;

import java.util.HashMap;

public class SA_Draw_Line_Option {

    public HashMap<String, Boolean> hashMap_Option = new HashMap<>();

    public SA_Draw_Line_Option() {
        hashMap_Option.put("camera", true);
    }

    public HashMap<String, Boolean> getOption(){
        return hashMap_Option;
    }
}
