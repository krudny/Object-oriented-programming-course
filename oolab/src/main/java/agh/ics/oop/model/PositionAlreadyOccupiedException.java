package agh.ics.oop.model;

public class PositionAlreadyOccupiedException extends Exception {
    public PositionAlreadyOccupiedException(Vector2d vec) {
        super("Position: " + vec.toString() + " is already occupied");
    }
}
