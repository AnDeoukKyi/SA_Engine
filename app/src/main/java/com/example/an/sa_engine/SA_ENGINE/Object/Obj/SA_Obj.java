package com.example.an.sa_engine.SA_ENGINE.Object.Obj;


import android.util.Log;

import com.example.an.sa_engine.SA_ENGINE.Sys.Engine.SA_Engine;
import com.example.an.sa_engine.User.Instance.character.hand.finger.Finger;

public class SA_Obj {

    private SA_Engine SA_engine;
    private int SA_id;
    private String SA_name;
    private String SA_tag = "";
    private Class c;



    public SA_Obj() {
        SA_engine = SA_Engine.getEngine();
        Log.e("gg", getClass().toString());



    }




    protected void SA_Create(SA_Obj sa_obj, String name) {
        c = sa_obj.getClass();

        this.SA_name = name;
        //SA_engine.SA_AddObj(this);


    }

    public Class toCast(Object obj){
        return c.getClass().cast(obj);
    }

}
