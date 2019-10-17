package com.example.an.sa_engine.User.Room;

import com.example.an.sa_engine.SA_ENGINE.System.Engine.SA_Engine;
import com.example.an.sa_engine.SA_ENGINE.System.Room.SA_Room;
import com.example.an.sa_engine.User.Instance.character.Character1;
import com.example.an.sa_engine.User.Instance.character.hand.Hand;

public class Room1 extends SA_Room{

    public Room1() {

        Character1 c1 = new Character1("주인공", null);
        Hand c2 = new Hand("손새로함", null);



        SA_Engine engine = SA_Engine.getEngine();
        engine = engine;
        //setTile()//배경타일설정
        //RoomManager();

        //roomMove(new Room2());


    }
}
