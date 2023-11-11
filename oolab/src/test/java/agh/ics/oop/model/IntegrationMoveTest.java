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
            add(new Vector2d(3,3));
        }};

        assertEquals(correctPositions, actualPositions);
    }
    @Test
    public void testInvalidMoves() {
        String[] args = {"f", "w", "h", "b", "l", "r", "r", "f", "l", "b"};
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
    public void testOutOfBorderMoves1() {
        String[] args = {"f", "l", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f"};
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
            add(new Vector2d(2,4));
            add(new Vector2d(0,4));
        }};

        assertEquals(correctPositions, actualPositions);
    }
    @Test
    public void testOutOfBorderMoves2() {
        String[] args = {"f", "l", "l", "b", "b", "b", "b", "b", "b", "b", "b", "b"};
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
            add(new Vector2d(4,4));
        }};

        assertEquals(correctPositions, actualPositions);
    }
    @Test
    public void testInputValues() {
        String[] args = {"f", "l", "r", "b", "r", "f", "j", "k"};
        List<MoveDirection> directions = OptionsParser.Parser(args);
        List<Vector2d> positions = List.of(new Vector2d(7,11), new Vector2d(3,4), new Vector2d(1,1), new Vector2d(0,0));
        Simulation simulation = new Simulation(positions, directions);

        List<Animal> finalAnimals = simulation.getAnimals();
        List<MoveDirection> finalDirections = simulation.getDirections();
        List<Vector2d> finalPositions = new ArrayList<>();


        for (Animal animal : finalAnimals) {
            finalPositions.add(animal.getPosition());
        }

        List<Vector2d> correctPositions = new ArrayList<>() {{
            add(new Vector2d(3,4));
            add(new Vector2d(1,1));
            add(new Vector2d(0,0));
        }};

        List<MoveDirection> correctDirections = new ArrayList<>() {{
            add(MoveDirection.FORWARD);
            add(MoveDirection.LEFT);
            add(MoveDirection.RIGHT);
            add(MoveDirection.BACKWARD);
            add(MoveDirection.RIGHT);
            add(MoveDirection.FORWARD);
        }};

        assertEquals(correctPositions, finalPositions);
        assertEquals(correctDirections, finalDirections);
    }
    @Test
    public void testOrientation() {
        String[] args = {"f", "b", "l", "r", "r", "f", "l", "b"};
        List<MoveDirection> directions = OptionsParser.Parser(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

        List<Animal> finalAnimals = simulation.getAnimals();
        List<MapDirection> actualDirections = new ArrayList<>();

        for (Animal animal : finalAnimals) {
            actualDirections.add(animal.getDirection());
        }
        List<MapDirection> correctDirections = new ArrayList<>() {{
            add(MapDirection.WEST);
            add(MapDirection.EAST);
        }};

        assertEquals(correctDirections, actualDirections);
    }

}
