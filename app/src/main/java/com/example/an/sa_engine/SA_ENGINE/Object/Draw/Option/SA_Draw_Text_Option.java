package com.example.an.sa_engine.SA_ENGINE.Object.Draw.Option;

import java.util.HashMap;

public class SA_Draw_Text_Option {

    public HashMap<String, Boolean> hashMap_Option = new HashMap<>();

    public SA_Draw_Text_Option() {
        hashMap_Option.put("camera", true);
        hashMap_Option.put("pos", true);
        hashMap_Option.put("background", true);
        hashMap_Option.put("width", true);
    }

    public HashMap<String, Boolean> getOption(){
        return hashMap_Option;
    }
}
