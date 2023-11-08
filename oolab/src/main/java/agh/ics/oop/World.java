package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

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
        /*System.out.println("System zaczął działanie");
        run(OptionsParser.Parser(args));
        System.out.println("System skończył działanie");*/

        /*Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));*/

        /*MapDirection direction = MapDirection.EAST;
        System.out.println("Aktualny kierunek: " + direction);
        System.out.println("Następny kierunek: " + direction.next());
        System.out.println("Poprzedni kierunek: " + direction.previous());
        System.out.println("Jednostkowy wektor: " + direction.toUnitVector());*/

        /*Animal animal1 = new Animal();
        Animal animal2 = new Animal(3,4);
        System.out.println(animal1.toString());
        animal1.move(MoveDirection.BACKWARD);
        System.out.println(animal1.toString());*/



    }
}
