package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;
import java.util.HashMap;
import java.util.Map;
public class RectangularMap extends AbstractWorldMap {

    private final int width;
    private final int height;
    private final Vector2d MAP_RIGHT_TOP;
    private final Vector2d MAP_LEFT_BOTTOM;
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);
    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        MAP_RIGHT_TOP = new Vector2d(width - 1, height - 1);
        MAP_LEFT_BOTTOM = new Vector2d(0,0);
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!isOccupied(position) && position.precedes(MAP_RIGHT_TOP) && position.follows(MAP_LEFT_BOTTOM));
    }
    public Vector2d getMAP_RIGHT_TOP() {
        return MAP_RIGHT_TOP;
    }
    public Vector2d getMAP_LEFT_BOTTOM() {
        return MAP_LEFT_BOTTOM;
    }
    @Override
    public String toString(){
        return mapVisualizer.draw(MAP_LEFT_BOTTOM, MAP_RIGHT_TOP);
    }
}