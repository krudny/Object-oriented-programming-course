package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    private int grass_amount;
    private final Map<Vector2d, Grass> grass = new HashMap<>();


    public GrassField(int grass_amount) {
        this.grass_amount = grass_amount;
        generatePositions();
    }

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
    public boolean isOccupied(Vector2d position) {
        return (super.isOccupied(position) || grass.containsKey(position));
    }
    @Override
    public WorldElement objectAt(Vector2d position) {

        if (grass.containsKey(position)) {
            return grass.get(position);
        }
        return super.objectAt(position);
    }

    public Map<Vector2d, Grass> getGrass(){
        return grass;
    }

    public Map<Vector2d, Animal> getAnimals(){
        return animals;
    }

    @Override
    public Map<Vector2d, WorldElement> getElements(){
        Map<Vector2d, WorldElement> all_animals = super.getElements();

        for(Map.Entry<Vector2d, Grass> entry : grass.entrySet()){
            Vector2d key = entry.getKey();
            WorldElement element = entry.getValue();

            all_elements.put(key, element);
        }

        return all_elements;
    }
}