package com.example.an.sa_engine.SA_ENGINE.Sys.Room;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import com.example.an.sa_engine.R;
import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;
import com.example.an.sa_engine.SA_ENGINE.Sys.Engine.SA_Engine;
import com.example.an.sa_engine.User.Instance.character.Character1;


public class SA_StartRoom extends AppCompatActivity {
    private SA_Engine engine;
    private SA_RoomManager roomManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Init();
        setContentView(R.layout.activity_sa_startroom);

        roomManager = new SA_RoomManager();

        Character1 c1 = new Character1();
        Character1 c2 = new Character1();
        Object o1 = c1;
        SA_Obj o2 = c2;

        Log.e("ggg", o1.getClass().getDeclaringClass().toString());


        //c1.cast(o1).str


    }


    private void Init(){
        engine = SA_Engine.getEngine();
        engine.Init(this);
        setViewType(engine.getFlag("USER", "view"));

    }//초기화진행


    private void setViewType(int viewType){
        if(viewType == engine.getFlag("VIEW", "landscape")){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }//가로모드, 세로모드 설정
}
