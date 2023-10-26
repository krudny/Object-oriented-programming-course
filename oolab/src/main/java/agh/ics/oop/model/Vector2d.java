package agh.ics.oop.model;


public class Vector2d {
    private final int x;
    private final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other) {
        if (other.getX() <= x &&  other.getY() <= y) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean follows(Vector2d other) {
        if (other.getX() > x &&  other.getY() > y) {
            return true;
        }
        else {
            return false;
        }
    }

    public Vector2d add(Vector2d other) {
        int new_x = other.getX() + x;
        int new_y = other.getY() + y;

        return new Vector2d(new_x, new_y);
    }

    public Vector2d subtract(Vector2d other) {
        int new_x = other.getX() - x;
        int new_y = other.getY() - y;

        return new Vector2d(new_x, new_y);
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.getX(), other.getX()), Math.max(this.getY(), other.getY()));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(this.getX(), other.getX()), Math.min(this.getY(), other.getY()));
    }




}
