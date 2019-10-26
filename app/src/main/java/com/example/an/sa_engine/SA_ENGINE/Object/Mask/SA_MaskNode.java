package com.example.an.sa_engine.SA_ENGINE.Object.Mask;

public class SA_MaskNode {
    private int index;
    private double a, b;
    private int k;
    private int deltaX, deltaY;
    private boolean up;
    private SA_MaskPoint p1, p2;
    private boolean ck = false, cb = false;

    public SA_MaskNode(int index, SA_MaskPoint p1, SA_MaskPoint p2) {
        this.index = index;
        this.p1 = p1;
        this.p2 = p2;
        deltaX = p2.getX() - p1.getX();
        deltaY = p2.getY() - p1.getY();

        fuction_k(p1, p2);
        if(ck){//k가 있다는뜻 x = k
            a = 0;
            b = 0;
        }
        else{
            fuction_ab(p1, p2);
        }

        p1.setRightN(this);
        p2.setLeftN(this);
    }

    private void fuction_k(SA_MaskPoint point1, SA_MaskPoint point2){
        if(point1.getX() == point2.getX()){
            k = point1.getX();
            ck = true;
        }
        else
            k = 0;
    }

    private void fuction_ab(SA_MaskPoint point1, SA_MaskPoint point2){
        if(point1.getY() == point2.getY()){
            b = point1.getY();
            cb = true;
            a = 0;
        }
        else {
            a = (double) (point2.getY() - point1.getY()) / (double) (point2.getX() - point1.getX());
            b = point1.getY() - a * point1.getX();
        }
    }

    public boolean clickCheck(int x, int y){
        boolean bool;
        if(ck){
            if(x < k)
                bool = false;
            else
                bool = true;
        }
        else{
            if(cb){
                if(y < b)
                    bool = true;
                else
                    bool = false;
            }
            else{
                if(y < a * x + b)
                    bool = true;
                else
                    bool = false;
            }
        }
        return bool == up;
    }

    public void fuctionCheck(double x, double y){
        if(ck){
            if(x < k)
                up = false;
            else
                up = true;
        }
        else{
            if(cb){
                if(y < b)
                    up = true;
                else
                    up = false;
            }
            else{
                if(y < a * x + b)
                    up = true;
                else
                    up = false;
            }
        }
    }

    public boolean isCb() {
        return cb;
    }

    public boolean isCk() {
        return ck;
    }

    public int getIndex() {
        return index;
    }

    public SA_MaskPoint getP1() {
        return p1;
    }

    public SA_MaskPoint getP2() {
        return p2;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public int getK() {
        return k;
    }
}
