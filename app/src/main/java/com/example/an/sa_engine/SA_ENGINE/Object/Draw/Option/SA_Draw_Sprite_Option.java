package com.example.an.sa_engine.SA_ENGINE.Object.Draw.Option;

import java.util.HashMap;

public class SA_Draw_Sprite_Option {

    public HashMap<String, Boolean> hashMap_Option = new HashMap<>();

    public SA_Draw_Sprite_Option() {
        hashMap_Option.put("camera", true);
        hashMap_Option.put("p2p", true);
        hashMap_Option.put("pos", true);
    }

    public HashMap<String, Boolean> getOption(){
        return hashMap_Option;
    }
}
