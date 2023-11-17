package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RectangularMapTest {
    private static final Vector2d VEC11 = new Vector2d(1,1);
    private static final Animal ANIMAL1 = new Animal(1, 1);
    private static final Animal ANIMAL2 = new Animal();

    @Test
    public void testCanMoveToBasic(){
        RectangularMap rectangularMap = new RectangularMap(4,4);
        assertTrue(rectangularMap.canMoveTo(VEC11));
        assertFalse(rectangularMap.canMoveTo(new Vector2d(5,5)));
    }

    @Test
    public void testPlace(){
        RectangularMap rectangularMap = new RectangularMap(4,4);
        assertTrue(rectangularMap.place(ANIMAL1));
        assertTrue(rectangularMap.place(ANIMAL2));
        assertFalse(rectangularMap.place(new Animal()));
    }

    @Test
    public void testIsOccupied(){
        RectangularMap rectangularMap = new RectangularMap(4,4);
        rectangularMap.place(ANIMAL1);
        rectangularMap.place(ANIMAL2);
        assertFalse(rectangularMap.isOccupied(new Vector2d(0,0)));
        assertTrue(rectangularMap.isOccupied(VEC11));
    }

    @Test
    public void testObjectAt(){
        RectangularMap rectangularMap = new RectangularMap(4,4);
        rectangularMap.place(ANIMAL1);
        assertNull(rectangularMap.objectAt(new Vector2d(0, 0)));
        assertEquals(ANIMAL1, rectangularMap.objectAt(VEC11));
    }
}