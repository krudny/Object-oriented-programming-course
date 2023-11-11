package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;

import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationMoveTest {
    @Test
    public void testValidMoves() {
        String[] args = {"f", "b", "l", "r", "r", "f", "l", "b"};
        List<MoveDirection> directions = OptionsParser.Parser(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

        List<Animal> finalAnimals = simulation.getAnimals();
        List<Vector2d> actualPositions = new ArrayList<>();

        for (Animal animal : finalAnimals) {
            actualPositions.add(animal.getPosition());
        }
        List<Vector2d> correctPositions = new ArrayList<>() {{
            add(new Vector2d(2,3));
            add(new Vector2d(2,3));
        }};

        assertEquals(correctPositions, actualPositions);
    }
    @Test
    public void testInvalidMoves() {
        String[] args = {"f", "w", "h", "b"};
        List<MoveDirection> directions = OptionsParser.Parser(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

        List<Animal> finalAnimals = simulation.getAnimals();
        List<Vector2d> actualPositions = new ArrayList<>();

        for (Animal animal : finalAnimals) {
            actualPositions.add(animal.getPosition());
        }
        List<Vector2d> correctPositions = new ArrayList<>() {{
            add(new Vector2d(2,3));
            add(new Vector2d(3,3));
        }};

        assertEquals(correctPositions, actualPositions);
    }
    @Test
    public void testOutOfBorderMoves() {
        String[] args = {"f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f"};
        List<MoveDirection> directions = OptionsParser.Parser(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

        List<Animal> finalAnimals = simulation.getAnimals();
        List<Vector2d> actualPositions = new ArrayList<>();

        for (Animal animal : finalAnimals) {
            actualPositions.add(animal.getPosition());
        }
        List<Vector2d> correctPositions = new ArrayList<>() {{
            add(new Vector2d(4,3));
            add(new Vector2d(3,4));
        }};

        assertEquals(correctPositions, actualPositions);
    }
}
