package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animals = new HashMap<>();

    public static int ID = 0;
    protected Map<Vector2d, WorldElement> all_elements = new HashMap<>();
    protected MapVisualizer mapVisualizer = new MapVisualizer(this);
    Vector2d MAP_LEFT_BOTTOM = new Vector2d(0,0);
    Vector2d MAP_RIGHT_TOP = new Vector2d(0,0);

    protected ArrayList<MapChangeListener> listeners = new ArrayList<>();

    public AbstractWorldMap() {
        ID+=1;
        listeners = new ArrayList<>();
    }

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
                mapChanged(animal, position, animal.getPosition());
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

    public Boundary getCurrentBounds(){
        return new Boundary(MAP_LEFT_BOTTOM, MAP_RIGHT_TOP);
    }

    public String toString() {
        return mapVisualizer.draw(getCurrentBounds().MAP_LEFT_BOTTOM(), getCurrentBounds().MAP_RIGHT_TOP());
    }

    public void addListener(MapChangeListener listener) {
        listeners.add(listener);
    }

    public String mapChanged( Animal animal, Vector2d oldPosition, Vector2d newPosition){
        String result = "";
        if (oldPosition == null){
            result = "New animal placed on the map at " + newPosition.toString();
        }
        else{
            result = "Animal moved from " + oldPosition.toString() + " to " + newPosition.toString();
        }
        for (MapChangeListener listener : listeners)
            listener.mapChanged((WorldMap) this,result);
        return result;
    }
}
