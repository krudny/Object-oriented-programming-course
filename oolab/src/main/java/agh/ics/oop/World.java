package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class World {

    public static void run(List<MoveDirection> directions) {
        for (MoveDirection direction : directions) {
            switch (direction) {
                case FORWARD:
                    System.out.println("Zwierzak idzie prosto");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case LEFT:
                    System.out.println("Zwierzak idzie w lewo");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak idzie w prawo");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        List<MoveDirection> directions = new ArrayList<>();

        String[] args1 = {"f", "f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f"};
        try {
            directions = OptionsParser.Parser(args1);
            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4), new Vector2d(0,0));
            GrassField map = new GrassField(10);
            Simulation sim = new Simulation(positions, directions, map);
            sim.run();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }




    }
}
