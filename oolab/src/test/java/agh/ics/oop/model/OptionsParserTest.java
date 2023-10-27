package agh.ics.oop.model;
import agh.ics.oop.OptionsParser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsParserTest {
    @Test
    public void testParseValidDirections() {
        String[] args = {"f", "b", "l", "r"};
        MoveDirection[] result = OptionsParser.Parser(args);

        assertArrayEquals(new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.BACKWARDS, MoveDirection.LEFT, MoveDirection.RIGHT}, result);

        String[] args1 = {"f", "r", "k", "r"};
        MoveDirection[] result1 = OptionsParser.Parser(args1);

        assertArrayEquals(new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.RIGHT, null, MoveDirection.RIGHT}, result1);
    }
}
