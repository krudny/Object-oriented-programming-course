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
        return "Pozycja: " + position.toString() + " Orientacja: " + direction.toString();
    }
    public boolean isAt(Vector2d position) {
        return position.equals(this.position);
    }
    public void move(MoveDirection direction) {
        Vector2d MAP_RIGHT_TOP = new Vector2d(5,5);
        Vector2d MAP_LEFT_BOTTOM = new Vector2d(0,0);

        switch(direction) {
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case FORWARD:
                Vector2d newPosition1 = this.position.add(this.direction.toUnitVector());
                if (newPosition1.precedes(MAP_RIGHT_TOP) && newPosition1.follows(MAP_LEFT_BOTTOM)) {
                    this.position = newPosition1;
                }
                break;
            case BACKWARD:
                Vector2d newPosition2 = this.position.subtract(this.direction.toUnitVector());
                if (newPosition2.precedes(MAP_RIGHT_TOP) && newPosition2.follows(MAP_LEFT_BOTTOM)) {
                    this.position = newPosition2;
                }
                break;
        }
    }

}
