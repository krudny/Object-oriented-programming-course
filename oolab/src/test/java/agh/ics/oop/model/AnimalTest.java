package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    public void getDirectionTest(){
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(2,2);
        assertEquals(animal1.getDirection(), MapDirection.NORTH);
        assertEquals(animal2.getDirection(), MapDirection.NORTH);
    }

    @Test
    public void getPositionTest(){
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(2,2);
        Animal animal3 = new Animal(1,3);

        assertEquals(animal1.getPosition(), new Vector2d(2,2));
        assertEquals(animal2.getPosition(), new Vector2d(2,2));
        assertEquals(animal3.getPosition(), new Vector2d(1,3));
    }

    @Test
    public void toStringTest(){
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(2,2);
        Animal animal3 = new Animal(1,3);

        assertEquals(animal1.toString(), "Pozycja: (2,2) Orientacja: Północ");
        assertEquals(animal2.toString(), "Pozycja: (2,2) Orientacja: Północ");
        assertEquals(animal3.toString(), "Pozycja: (1,3) Orientacja: Północ");
    }

    @Test
    public void isAt(){
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(2,2);
        Animal animal3 = new Animal(1,3);

        assertTrue(animal1.isAt(new Vector2d(2,2)));
        assertTrue(animal2.isAt(new Vector2d(2,2)));
        assertTrue(animal3.isAt(new Vector2d(1,3)));
        assertFalse(animal1.isAt(new Vector2d(1,2)));
        assertFalse(animal2.isAt(new Vector2d(1,2)));
        assertFalse(animal3.isAt(new Vector2d(2,3)));
    }


}
