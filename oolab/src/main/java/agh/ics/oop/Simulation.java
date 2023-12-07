package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> Animals = new ArrayList<>();
    private List<MoveDirection> Moves = new ArrayList<>();
    private final WorldMap Map;
    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap map) {
        this.Moves = moves;
        this.Map = map;
        for(Vector2d position : positions) {
            Animal new_animal = new Animal(position.getX(), position.getY());
            try {
                map.place(new_animal);
                Animals.add(new_animal);
            } catch (PositionAlreadyOccupiedException e) {
                e.printStackTrace();
            }


        }

    }

    public void run() {
        int animal_count = Animals.size();
        int cnt = 0;

        for(MoveDirection currentMove : Moves) {
            Animal current_animal = Animals.get(0);
            Animals.remove(0);
            System.out.println("Zwierze " + ((cnt % animal_count) + 1) + " " + current_animal.toString());
            Map.move(current_animal, currentMove);

            cnt += 1;
            Animals.add(current_animal);
        }
    }

    public List<Animal> getAnimals() {
        return Animals;
    }

    public List<MoveDirection> getDirections() { return Moves; }
}
