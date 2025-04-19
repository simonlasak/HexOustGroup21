package UIPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static UIPackage.BoardLogic.redHexagons;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BoardLogicTest {
    @BeforeEach
    void resetBoard() {
        BoardLogic.clearBoard();
    }

    @Test
    void testValidMoveOnEmptySpot() {
        HexCube move = new HexCube(new Point(300, 300));
        assertTrue(BoardLogic.isValidMove(move, true));
    }

    @Test
    void testInvalidMoveOnOccupiedSpot() {
        HexCube move = new HexCube(new Point(300, 300));
        BoardLogic.addToList(move, true);
        assertFalse(BoardLogic.isValidMove(move, false));
    }

    @Test
    void testAddToListIncreasesRedSize() {
        HexCube move = new HexCube(new Point(300, 300));
        int before = BoardLogic.redHexagons.size();
        BoardLogic.addToList(move, false);
        assertEquals(before + 1, BoardLogic.listSize(true));
    }
}

class CaptureTestLogic {
    @BeforeEach
    void setUpBoard() {
        BoardLogic.testMode = true;
        BoardLogic.clearBoard();
        //Red hexagons
        BoardLogic.redHexagons.put(new HexCube(-1, -1, 2), 0);
        BoardLogic.redHexagons.put(new HexCube(-2, 0, 2), 0);
        BoardLogic.redHexagons.put(new HexCube(0, 0, 0), 2);
        BoardLogic.redHexagons.put(new HexCube(4, -2, -2), 4);
        BoardLogic.redHexagons.put(new HexCube(2, 1, -3), 6);

        //Blue hexagons
        BoardLogic.blueHexagons.put(new HexCube(0, -1, 1), 3);
        BoardLogic.blueHexagons.put(new HexCube(-2, 1, 1), 5);
    }

    @Test
    public void testBlueCapture() {
        //placing blue hexagon at (-1, 0, 1)
        HexCube newBlueMove = new HexCube(-1, 0, 1);
        int groupNumber = 3;

        BoardLogic.blueHexagons.put(newBlueMove, groupNumber);
        BoardLogic.addToList(newBlueMove, false); // false = blue's turn


        BoardLogic.printLists();

        // Expected red hexagons after capture
        Set<HexCube> expectedRed = new HashSet<>(Arrays.asList(
                new HexCube(4, -2, -2),
                new HexCube(2, 1, -3)
        ));

        // Expected blue hexagons after capture
        Set<HexCube> expectedBlue = new HashSet<>(Arrays.asList(
                new HexCube(0, -1, 1),
                new HexCube(-2, 1, 1),
                new HexCube(-1, 0, 1)
        ));

        assertEquals(expectedRed, BoardLogic.redHexagons.keySet());
        assertEquals(expectedBlue, BoardLogic.blueHexagons.keySet());
    }
}