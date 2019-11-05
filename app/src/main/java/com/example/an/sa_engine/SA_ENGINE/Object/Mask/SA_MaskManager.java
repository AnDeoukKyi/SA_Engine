package com.example.an.sa_engine.SA_ENGINE.Object.Mask;

import android.util.Log;

import com.example.an.sa_engine.SA_ENGINE.System.Option.SA_FLAG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SA_MaskManager {

    private int indexP = 0, indexN = 0;
    private ArrayList<SA_MaskPoint> AL_Point = new ArrayList<>();
    private ArrayList<SA_MaskNode> AL_Node = new ArrayList<>();
    private int relativeX, relativeY;
    private double innerX, innerY;


    public boolean checkClick(int clickX, int clickY){
        boolean click = true;
        for(int i = 0; i<AL_Node.size(); i++){
            if(!AL_Node.get(i).clickCheck(clickX - relativeX, clickY - relativeY)){
                click = false;
                break;
            }
        }
        if(click){
            //Log.e("click했엉", Boolean.toString(click));
            return true;
        }
        else{
            //Log.e("click아니얌", Boolean.toString(click));
            return false;
            //다른 오브젝트까지 검사해야됨
        }

    }


    public void add(int x, int y){
        AL_Point.add(new SA_MaskPoint(indexP++, x, y));
    }

    public void setNode(){
        int i1;
        for(int i = 0; i<AL_Point.size(); i++){
            i1 = i+1;
            if(i+1 >= AL_Point.size())
                i1 = 0;
            AL_Node.add(new SA_MaskNode(indexN++, AL_Point.get(i), AL_Point.get(i1)));
        }
        searchInnerPoint();
        for(int i = 0; i < AL_Node.size(); i++){
            AL_Node.get(i).fuctionCheck(innerX, innerY);
        }
    }

    private void searchInnerPoint(){
        int index = setMostUpPoint();
        searchInner(AL_Point.get(index).getLeftN(), AL_Point.get(index).getRightN());
    }

    private void searchInner(SA_MaskNode n1, SA_MaskNode n2){
        SA_MaskPoint p2 = n1.getP2();
        innerY = p2.getY() + 0.01;
        if(n1.isCb())
            innerX = p2.getX();
        else{
            if(n1.isCk())
                innerX = p2.getX() + 0.01;
            else
                innerX = (innerY - n1.getB())/n1.getA() + 0.0001;
        }
    }

    public void setRelative(){
        int xIndex = 0, yIndex = 0;
        int minX = 999999999, minY = 999999999;
        for(int i = 0; i<AL_Point.size(); i++){
            if(AL_Point.get(i).getX() < minX){
                xIndex = i;
                minX = AL_Point.get(i).getX();
            }
            if(AL_Point.get(i).getY() < minY){
                yIndex = i;
                minY = AL_Point.get(i).getY();
            }
        }
        relativeX = AL_Point.get(xIndex).getX();
        relativeY = AL_Point.get(yIndex).getY();
        for(int i = 0; i<AL_Point.size(); i++){
            AL_Point.get(i).setRelative(relativeX, relativeY);//상대좌표로 변경
        }
    }

    public int getRelativeX() {
        return relativeX;
    }

    public int getRelativeY() {
        return relativeY;
    }

    private int setMostUpPoint(){
        ArrayList<Integer> AL_Index = new ArrayList<>();
        int i1;
        for(int i = 0; i< AL_Node.size(); i++){
            i1 = i+1;
            if(i+1 >= AL_Node.size())
                i1 = 0;
            if(AL_Node.get(i).getDeltaY() <= 0 && AL_Node.get(i1).getDeltaY() >= 0){
                AL_Index.add(i);
            }
        }
        ArrayList<SA_MaskPoint> p = new ArrayList<>();
        for(int i = 0; i<AL_Index.size(); i++)
            p.add(AL_Node.get(AL_Index.get(i)).getP2());
        Collections.sort(p, cmpX);
        Collections.sort(p, cmpY);
        return p.get(0).getIndex();
    }

    Comparator<SA_MaskPoint> cmpX = new Comparator<SA_MaskPoint>() {
        @Override
        public int compare(SA_MaskPoint p1, SA_MaskPoint p2) {
            return p1.getX() - p2.getX();
        }
    };
    Comparator<SA_MaskPoint> cmpY = new Comparator<SA_MaskPoint>() {
        @Override
        public int compare(SA_MaskPoint p1, SA_MaskPoint p2) {
            return p1.getY() - p2.getY();
        }
    };

    public void Move(int x, int y) {
        relativeX += x;
        relativeY += y;
    }
}
