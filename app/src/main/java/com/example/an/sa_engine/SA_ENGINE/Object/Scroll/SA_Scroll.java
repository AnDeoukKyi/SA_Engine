package com.example.an.sa_engine.SA_ENGINE.Object.Scroll;

import com.example.an.sa_engine.SA_ENGINE.Object.Draw.SA_Draw;
import com.example.an.sa_engine.SA_ENGINE.Object.Obj.SA_Obj;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;

import java.util.HashMap;

public class SA_Scroll extends SA_Obj{

    private int align;
    private int width, height;
    private int row = 0;
    private boolean viewScrollBar = false;
    public SA_ScrollBar scrollBar;
    private int scorllBarThickness;
    private int scorllBarLength;



    HashMap<Integer, Object> hashMap_Data = new HashMap<>();

    @Override
    public void _Create(String name) {
        super._Create(name);
    }

    @Override
    public void _Draw() {
        super._Draw();
    }

    public void Init(int align, int width, int height) {
        this.align = align;
        this.width = width;
        this.height = height;
    }

    public void Init(int align, int width, int height, int row) {
        this.align = align;
        this.width = width;
        this.height = height;
        this.row = row;
    }





    public void ViewScrollBar(int scorllBarThickness){
        this.scorllBarThickness = scorllBarThickness;
        viewScrollBar = true;
        if(align == SA_FLAG.ENGINE_OBJECT_SCROLL_HORIZONTAL){
            //수정해야됨
            scorllBarLength = width;
//            SA_Draw_Rect_Point("스크롤바배경", 10, SA_FILL, width-10, 0, width, height, SA_COLOR_GRAY, 0);
//            SA_Draw_Rect_Length("스크롤바", 10, SA_FILLEDGE, width-5, 0, 10, height, SA_COLOR_GRAY, 0);
        }
        else{
            scorllBarLength = height;
//            SA_Draw_Rect_Point("스크롤바배경", 10, SA_FILL, width - scorllBarThickness, 0, width, height, SA_COLOR_GRAY, 0);
//            SA_Draw_Rect_Length("스크롤바", 10, SA_FILLEDGE, width - scorllBarThickness+1, 0, scorllBarThickness-2, height, SA_COLOR_RED, 0);
        }



    }
}
