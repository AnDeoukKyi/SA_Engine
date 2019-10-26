package com.example.an.sa_engine.SA_ENGINE.Object.Mask;

public class SA_MaskPoint {
    private int index;
    private int x, y;
    private SA_MaskNode leftN, rightN;



    public SA_MaskPoint(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIndex() {
        return index;
    }

    public SA_MaskNode getLeftN() {
        return leftN;
    }

    public SA_MaskNode getRightN() {
        return rightN;
    }

    public void setLeftN(SA_MaskNode leftN) {
        this.leftN = leftN;
    }

    public void setRightN(SA_MaskNode rightN) {
        this.rightN = rightN;
    }

    public void setRelative(int minX, int minY) {
        x -= minX;
        y -= minY;
    }


}
