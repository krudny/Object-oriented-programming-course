package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OptionsParser {
    public static List<MoveDirection> Parser(String[] args) {
        MoveDirection[] moveDirection = new MoveDirection[args.length];
        List<MoveDirection> MoveDirectionList = new ArrayList<>();

        for(int i = 0; i < args.length; i++){
            if (Objects.equals(args[i], "f")) {
                MoveDirectionList.add(MoveDirection.FORWARD);
            } else if (Objects.equals(args[i], "b")) {
                MoveDirectionList.add(MoveDirection.BACKWARD);
            } else if (Objects.equals(args[i], "l")) {
                MoveDirectionList.add(MoveDirection.LEFT);
            } else if (Objects.equals(args[i], "r")) {
                MoveDirectionList.add(MoveDirection.RIGHT);
            } else {
                throw new IllegalArgumentException(args[i] + " " + "is not legal move");
            }
        }
        return MoveDirectionList;
    }
}
