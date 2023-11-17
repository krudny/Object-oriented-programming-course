package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;
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
        List<MoveDirection> directions = OptionsParser.Parser(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4), new Vector2d(0,0));
        WorldMap worldMap = new RectangularMap(5,5);
        Simulation simulation = new Simulation(positions, directions, worldMap);
        simulation.run();

    }
}
