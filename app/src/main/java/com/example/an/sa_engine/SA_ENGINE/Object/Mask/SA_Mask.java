package com.example.an.sa_engine.SA_ENGINE.Object.Mask;

import android.graphics.Point;

import com.example.an.sa_engine.SA_ENGINE.Object.Draw.SA_Draw;
import com.example.an.sa_engine.SA_ENGINE.Object.Draw.Shape.SA_Draw_Shape;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;

import java.util.ArrayList;

public class SA_Mask {

    private ArrayList<SA_MaskPoint> point = new ArrayList<>();
    private ArrayList<SA_MaskNode> node = new ArrayList<>();
    private int centerX, centerY;

    public SA_Mask(SA_Draw draw, int maskFlag) {
        switch(maskFlag){
            case SA_FLAG.ENGINE_MASK_CREATE_AUTO:
                setPoint(draw.getDrawType(), draw.getShape());
                break;
        }
        setNode();
    }


    private void setPoint(Object... obj){
        //SA_Draw_Shape rect
        switch ((int)obj[0]) {
            case SA_FLAG.ENGINE_DRAW_RECT_CREATE:
                SA_Draw_Shape rect = (SA_Draw_Shape)obj[1];
                centerX = rect.getCenterX();
                centerY = rect.getCenterY();
                point.add(new SA_MaskPoint(rect.getStartX(), rect.getStartY()));
                point.add(new SA_MaskPoint(rect.getEndX(), rect.getStartY()));
                point.add(new SA_MaskPoint(rect.getEndX(), rect.getEndY()));
                point.add(new SA_MaskPoint(rect.getStartX(), rect.getEndY()));
                break;
        }
    }

    private void setNode(){
        int i1;
        for(int i = 0; i<point.size(); i++){
            i1 = i+1;
            if(i+1 >= point.size())
                i1 = 0;
            node.add(new SA_MaskNode(point.get(i), point.get(i1), centerX, centerY));
        }
    }
}
