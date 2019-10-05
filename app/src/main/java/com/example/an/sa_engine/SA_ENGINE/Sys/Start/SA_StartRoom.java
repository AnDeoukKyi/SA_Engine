package com.example.an.sa_engine.SA_ENGINE.Sys.Start;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.an.sa_engine.R;
import com.example.an.sa_engine.SA_ENGINE.Sys.Engine.SA_Engine;
import com.example.an.sa_engine.User.Instance.Character1;
import com.example.an.sa_engine.User.Instance.Character2;
import com.example.an.sa_engine.User.Instance.Character3;
import com.example.an.sa_engine.User.Instance.Character4;

public class SA_StartRoom extends AppCompatActivity {
    SA_Engine engine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Init();
        //이것도 옵션으로 들어가야됨
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_sa_startroom);

        new Character1();
        new Character2();
        new Character3();
        new Character4();


    }


    private void Init(){
        engine = SA_Engine.getEngine();
    }



}
