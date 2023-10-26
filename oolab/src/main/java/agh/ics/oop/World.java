package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.Objects;

public class World {

    public static void run(MoveDirection[] directions) {
        for (MoveDirection direction : directions) {
            switch (direction) {
                case FORWARD:
                    System.out.println("Zwierzak idzie prosto");
                    break;
                case BACKWARDS:
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
        System.out.println("System zaczął działanie");
        run(OptionsParser.Parser(args));
        System.out.println("System skończył działanie");

        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(4,5);

        System.out.println(vec1.getX());
        Vector2d vec3 = vec1.add(vec2);
        System.out.print(vec3.toString());

    }
}
