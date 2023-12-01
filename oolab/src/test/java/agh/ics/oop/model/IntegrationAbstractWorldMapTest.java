package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationAbstractWorldMapTest {
    @Test
    public void RectangularMapMovesTest() {
        String[] args = {"f", "b", "l", "r", "r", "f", "l", "b", "b"};
        List<MoveDirection> directions = OptionsParser.Parser(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4), new Vector2d(0,0));

        RectangularMap map = new RectangularMap(10, 10);
        Simulation sim = new Simulation(positions, directions, map);
        sim.run();

        List<Animal> finalAnimals = sim.getAnimals();
        List<Vector2d> actualPositions = new ArrayList<>();

        for (Animal animal : finalAnimals) {
            actualPositions.add(animal.getPosition());
        }
        List<Vector2d> correctPositions = new ArrayList<>() {{
            add(new Vector2d(2,3));
            add(new Vector2d(3,3));
            add(new Vector2d(1,0));
        }};

        assertEquals(correctPositions, actualPositions);
    }

    @Test
    public void GrassFieldMovesTest() {
        String[] args = {"f", "f", "r", "f", "f", "b", "f", "f"};
        List<MoveDirection> directions = OptionsParser.Parser(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2));

        GrassField map = new GrassField(15);
        Simulation sim = new Simulation(positions, directions, map);
        sim.run();

        List<Animal> finalAnimals = sim.getAnimals();
        List<Vector2d> actualPositions = new ArrayList<>();

        for (Animal animal : finalAnimals) {
            actualPositions.add(animal.getPosition());
        }
        List<Vector2d> correctPositions = new ArrayList<>() {{
            add(new Vector2d(5,4));
        }};

        assertEquals(correctPositions, actualPositions);
    }

    @Test
    public void GrassAmountTest(){
        GrassField map = new GrassField(15);
        Map<Vector2d, Grass> grass = map.getGrass();

        assertEquals(grass.size(), 15);

        GrassField map2 = new GrassField(3);
        Map<Vector2d, Grass> grass2 = map2.getGrass();

        assertEquals(grass2.size(), 3);
    }

}
