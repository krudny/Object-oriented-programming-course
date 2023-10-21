package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {

    public static void run(MoveDirection[] directions) {
        for (MoveDirection direction : directions) {
            System.out.println(direction);
        }
    }
    public static void main(String[] args) {
        System.out.println("System zaczął działanie");
        run(OptionsParser.Parser(args));
        System.out.println("System skończył działanie");
    }
}
