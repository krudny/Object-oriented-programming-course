package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GrassField implements WorldMap {
    private int grass_amount;
    private final Map<Vector2d, Grass> grass = new HashMap<>();
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    public GrassField(int grass_amount) {
        this.grass_amount = grass_amount;
    }

    Vector2d MAP_LEFT_BOTTOM = new Vector2d(0,0);
    Vector2d MAP_RIGHT_TOP = new Vector2d(0,0);


    public void generatePositions() {
        int maxX = (int) Math.sqrt((double) grass_amount * 10);
        int maxY = maxX;
        Set<Vector2d> positions = new HashSet<>();

        while (positions.size() < grass_amount) {

            int x = (int) (Math.random() * maxX);
            int y = (int) (Math.random() * maxY);

            Vector2d vec = new Vector2d(x, y);
            calculateMapSize(vec);

            Vector2d position = new Vector2d(x, y);
            positions.add(position);
        }

        for(Vector2d position : positions) {
            grass.put(position, new Grass(position));
        }
    }


    @Override
    public String toString() {
        return mapVisualizer.draw(MAP_LEFT_BOTTOM, MAP_RIGHT_TOP);
    }


    @Override
    public boolean canMoveTo(Vector2d position) {

        return !animals.containsKey(position);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if(canMoveTo(position)) {
            animals.put(position, animal);
            return true;
        }
        return false;
    }

    public void calculateMapSize(Vector2d vec) {
        MAP_LEFT_BOTTOM = MAP_LEFT_BOTTOM.lowerLeft(vec);
        MAP_RIGHT_TOP = MAP_RIGHT_TOP.upperRight(vec);
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d position = animal.getPosition();
        if (animals.containsKey(position)){
            animal.move(direction, this);
            if (!position.equals(animal.getPosition())){
                animals.put(animal.getPosition(), animal);
                animals.remove(position);

                int x = animal.getPosition().getX();
                int y = animal.getPosition().getY();

                Vector2d vec = new Vector2d(x, y);
                calculateMapSize(vec);
            }
        }
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return (animals.containsKey(position) || grass.containsKey(position));
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.containsKey(position)){
            return animals.get(position);
        } else if (grass.containsKey(position)) {
            return grass.get(position);
        }
        return null;
    }
}
