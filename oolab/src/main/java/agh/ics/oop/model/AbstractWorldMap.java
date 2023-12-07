package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected Map<Vector2d, WorldElement> all_elements = new HashMap<>();
    protected MapVisualizer mapVisualizer = new MapVisualizer(this);
    Vector2d MAP_LEFT_BOTTOM = new Vector2d(0,0);
    Vector2d MAP_RIGHT_TOP = new Vector2d(0,0);

    @Override
    public void place(Animal animal) throws PositionAlreadyOccupiedException{
        if (canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
        } else {
            throw new PositionAlreadyOccupiedException(animal.getPosition());
        }


    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
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

    public void calculateMapSize(Vector2d vec) {
        MAP_LEFT_BOTTOM = MAP_LEFT_BOTTOM.lowerLeft(vec);
        MAP_RIGHT_TOP = MAP_RIGHT_TOP.upperRight(vec);
    }

    public Map<Vector2d, WorldElement> getElements(){
        for(Map.Entry<Vector2d, Animal> entry : animals.entrySet()){
            Vector2d key = entry.getKey();
            WorldElement element = entry.getValue();

            all_elements.put(key, element);
        }

        return all_elements;
    }
}
