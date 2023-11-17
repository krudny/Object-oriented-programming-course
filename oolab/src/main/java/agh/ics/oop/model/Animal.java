package agh.ics.oop.model;

public class Animal {
    private MapDirection direction;
    private Vector2d position;
    public Animal() {
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }
    public Animal(int x, int y){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(x, y);
    }
    public MapDirection getDirection() {
        return this.direction;
    }
    public Vector2d getPosition() {
        return this.position;
    }
    @Override
    public String toString() {
        return direction.toString();
    }
    public boolean isAt(Vector2d position) {
        return position.equals(this.position);
    }
    public void move(MoveDirection direction, MoveValidator validator) {
        switch(direction) {
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case FORWARD:
                Vector2d newPosition1 = this.position.add(this.direction.toUnitVector());
                if (validator.canMoveTo(newPosition1)) {
                    this.position = newPosition1;
                }
                break;
            case BACKWARD:
                Vector2d newPosition2 = this.position.subtract(this.direction.toUnitVector());
                if (validator.canMoveTo(newPosition2)) {
                    this.position = newPosition2;
                }
                break;
        }
    }

}
