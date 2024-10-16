package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation extends Thread implements Runnable{
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

    public synchronized void run() {
        int animal_count = Animals.size();
        try {
            for(MoveDirection currentMove : Moves) {
                Thread.sleep(500);
                Animal current_animal = Animals.get(0);
                Animals.remove(0);
                Map.move(current_animal, currentMove);
                Animals.add(current_animal);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> getAnimals() {
        return Animals;
    }

    public List<MoveDirection> getDirections() { return Moves; }
}
