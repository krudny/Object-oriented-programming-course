package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.Objects;

public class OptionsParser {
    public static MoveDirection[] Parser(String[] args) {
        MoveDirection[] moveDirection = new MoveDirection[args.length];

        for(int i = 0; i < args.length; i++){
            if (Objects.equals(args[i], "f")) {
                moveDirection[i] = MoveDirection.FORWARD;
            } else if (Objects.equals(args[i], "b")) {
                moveDirection[i] = MoveDirection.BACKWARDS;
            } else if (Objects.equals(args[i], "l")) {
                moveDirection[i] = MoveDirection.LEFT;
            } else if (Objects.equals(args[i], "r")) {
                moveDirection[i] = MoveDirection.RIGHT;
            }
        }
        return moveDirection;
    }
}
