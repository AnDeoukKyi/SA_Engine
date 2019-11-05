package com.example.an.sa_engine.SA_ENGINE.Object.Mask;

import com.example.an.sa_engine.SA_ENGINE.Object.Draw.SA_Draw;
import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;

public class SA_Mask {

    //오른쪽 아래가 true
    private SA_Draw draw;
    private SA_MaskManager maskManager = new SA_MaskManager();
    private int relativeX, relativeY;
    //realtiveX,Y 얼마만큼 평행이동했는지 나옴 나중에 역계산할때 더하면 실제 출력좌표 나옴


    public SA_Mask(SA_Draw draw, int maskType) {
        this.draw = draw;
        switch(maskType){
            case SA_FLAG.ENGINE_MASK_CREATE_AUTO:
            case SA_FLAG.ENGINE_MASK_CREATE_RECT:
                setPoint();
                break;

        }
        maskManager.setNode();
    }

    private void setPoint(){
        switch (draw.getDrawType()) {
            case SA_FLAG.ENGINE_DRAW_CREATE_SPRITE:
            case SA_FLAG.ENGINE_DRAW_CREATE_RECT:
                maskManager.add(draw.getStartX(), draw.getStartY());
                maskManager.add(draw.getEndX(), draw.getStartY());
                maskManager.add(draw.getEndX(), draw.getEndY());
                maskManager.add(draw.getStartX(), draw.getEndY());
                break;
        }
        maskManager.setRelative();
        relativeX = maskManager.getRelativeX();
        relativeY = maskManager.getRelativeY();
    }

    public void Move(int x, int y){
        maskManager.Move(x, y);
        relativeX += x;
        relativeY += y;
    }

    public SA_MaskManager getMaskManager() {
        return maskManager;
    }
}
