package com.example.an.sa_engine.SA_ENGINE.Object.Draw.Shape;

import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;

public class SA_Draw_Shape {

    private int startX, startY, endX, endY, centerX, centerY, width, height;

    public SA_Draw_Shape(Object... obj) {
        switch((Integer)obj[0]){
            case SA_FLAG.ELSE_POS_CENTER:
                this.centerX = (Integer)obj[1];
                this.centerY = (Integer)obj[2];
                this.width = (Integer)obj[3];
                this.height = (Integer)obj[4];
                this.startX = centerX - width/2;
                this.startY = centerY - height/2;
                this.endX = startX + width;
                this.endY = startY + height;
                break;

            case SA_FLAG.ELSE_POS_NOTHING:
                this.startX = (Integer)obj[1];
                this.startY = (Integer)obj[2];
                this.endX = (Integer)obj[3];
                this.endY = (Integer)obj[4];
                break;

//
//            case SA_FLAG.ELSE_NOTHING:
//                break;
        }

    }


    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
