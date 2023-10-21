package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

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
    }
}
