package com.example.an.sa_engine.SA_ENGINE.Object.Mask;

public class SA_MaskNode {
    private double a, b;
    private int k;
    private boolean up;


    public SA_MaskNode(SA_MaskPoint p1, SA_MaskPoint p2, int centerX, int centerY) {

        k = fuction_k(p1, p2);
        if(k != 0){
            a = 0;
            b = 0;
        }
        else{
            b = fuction_b(p1, p2);
            if(b != 0){
                a = 0;
            }
            else{
                a = fuction_a(p1, p2);
                b = a * p1.getX() + p2.getY();
            }
        }
        up = fuction_Check(centerX, centerY);
    }

    public boolean SA_Mask_In(int x, int y){
        return (up == fuction_Check(x, y)) ? true : false;
    }

    private int fuction_k(SA_MaskPoint point1, SA_MaskPoint point2){
        if(point1.getX() == point2.getX())
            return point1.getX();
        else
            return 0;
    }

    private double fuction_b(SA_MaskPoint point1, SA_MaskPoint point2){
        if(point1.getY() == point2.getY())
            return point1.getY();
        else
            return 0;
    }

    private double fuction_a(SA_MaskPoint point1, SA_MaskPoint point2){

        return (double)(point2.getY() - point1.getY()) / (double)(point2.getX() - point1.getX());
    }

    private boolean fuction_Check(int x, int y){
        if(k != 0){//x = k;
            if(x < k)
                return false;
            else
                return true;
        }
        else{
            if(b != 0){//y = b;
                if(y < b)
                    return false;
                else
                    return true;
            }
            else{//y = ax + b
                if(y < a * x + b)
                    return false;
                else return true;
            }
        }
    }
}
