package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    @Test
    public void placeTest() {
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4), new Vector2d(0,0));
        GrassField map = new GrassField(10);
        Map<Vector2d, Animal> finalAnimals = map.getAnimals();

        for(Vector2d position : positions) {
            map.place(new Animal(position.getX(), position.getY()));
        }

        assertTrue(finalAnimals.containsKey(new Vector2d(3,4)));
        assertTrue(finalAnimals.containsKey(new Vector2d(0,0)));
        assertTrue(finalAnimals.containsKey(new Vector2d(2,2)));
        assertFalse(finalAnimals.containsKey(new Vector2d(1,2)));
    }

    @Test
    public void isOccupiedTest() {
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(5,7), new Vector2d(-4,0));
        GrassField map = new GrassField(10);

        for(Vector2d position : positions) {
            map.place(new Animal(position.getX(), position.getY()));
        }

        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertTrue(map.isOccupied(new Vector2d(5,7)));
        assertTrue(map.isOccupied(new Vector2d(-4,0)));
    }

    @Test
    public void objectAtTest() {
        List<Vector2d> positions = List.of(new Vector2d(2,2));
        GrassField map = new GrassField(10);

        for(Vector2d position : positions) {
            map.place(new Animal(position.getX(), position.getY()));
        }

        Animal animal = (Animal) map.objectAt(new Vector2d(2,2));
        Vector2d vec = animal.getPosition();

        assertEquals(vec, new Vector2d(2,2));
    }
}
