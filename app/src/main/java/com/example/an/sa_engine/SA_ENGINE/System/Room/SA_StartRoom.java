package com.example.an.sa_engine.SA_ENGINE.System.Room;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.an.sa_engine.R;
import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;


public class SA_StartRoom extends AppCompatActivity {

    private SA_Engine engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Init();
        setContentView(R.layout.activity_sa_startroom);
        engine.Init_2();
    }


    private void Init(){
        engine = SA_Engine.getEngine();
        engine.Init_1(this);
        setViewType(engine.getFlag("USER_VIEW_TYPE"));

    }//초기화진행


    private void setViewType(int viewType){
        if(viewType == SA_FLAG.USER_VIEW_TYPE_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }//가로모드, 세로모드 설정
}
