package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    List<Animal> Animals = new ArrayList<>();
    List<MoveDirection> Directions = new ArrayList<>();
    public Simulation(List<Vector2d> positions, List<MoveDirection> directions) {
        for(Vector2d position : positions) {
            Animal new_animal = new Animal(position.getX(), position.getY());
            Animals.add(new_animal);
        }

        this.Directions = directions;
    }

    public void run() {
        int animal_count = Animals.size();
        int cnt = 0;

        for(MoveDirection currentMove : Directions) {
            Animal current_animal = Animals.get(0);
            Animals.remove(0);
            current_animal.move(currentMove);
            System.out.println("Zwierze " + ((cnt % animal_count) + 1) + " " + current_animal.toString());
            cnt += 1;
            Animals.add(current_animal);
        }
    }

    public List<Animal> getAnimals() {
        return Animals;
    }
}
