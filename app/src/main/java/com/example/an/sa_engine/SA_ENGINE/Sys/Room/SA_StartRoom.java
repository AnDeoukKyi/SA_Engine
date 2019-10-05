package com.example.an.sa_engine.SA_ENGINE.Sys.Room;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import com.example.an.sa_engine.R;
import com.example.an.sa_engine.SA_ENGINE.Sys.Engine.SA_Engine;
import com.example.an.sa_engine.User.Instance.Character1;

public class SA_StartRoom extends AppCompatActivity {
    private SA_Engine engine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Init();
        setContentView(R.layout.activity_sa_startroom);

        new Character1();

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
