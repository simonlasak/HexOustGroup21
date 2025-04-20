package UIPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static UIPackage.BoardLogic.redHexagons;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static UIPackage.BoardTestUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class BasicPlacementTest {
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


}

class CaptureTestLogic {
    @BeforeEach
    void setUpBoard() throws Exception {
        BoardLogic.testMode = true;
        BoardLogic.clearBoard();
        //Red hexagons
        getRedHexMap().put(new HexCube(-1, -1, 2), 0);
        getRedHexMap().put(new HexCube(-2, 0, 2), 0);
        getRedHexMap().put(new HexCube(0, 0, 0), 2);
        getRedHexMap().put(new HexCube(4, -2, -2), 4);
        getRedHexMap().put(new HexCube(2, 1, -3), 6);

        //Blue hexagons
        getBlueHexMap().put(new HexCube(0, -1, 1), 3);
        getBlueHexMap().put(new HexCube(-2, 1, 1), 5);
    }

    @Test
    public void testBlueCapture() throws Exception  {
        //placing blue hexagon at (-1, 0, 1)
        HexCube newBlueMove = new HexCube(-1, 0, 1);
        int groupNumber = 3;

        getBlueHexMap().put(newBlueMove, groupNumber);
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

        assertEquals(expectedRed, getRedHexMap().keySet());
        assertEquals(expectedBlue, getBlueHexMap().keySet());
    }

    @Test
    void testRedCaptureBlueWhenPlacedAdjacent() throws Exception {
        // Positions adjacent to redHex1
        //this checks all the squares around the hex that should be a capturing move
        HexCube[] adjacentPositions = new HexCube[] {
                new HexCube(1, 0, -1),
                new HexCube(0, -1, 1),
                new HexCube(-1, 1, 0),
                new HexCube(-1, 0, 1),
                new HexCube(0, 1, -1),
        };

        for (HexCube newRedHex : adjacentPositions) {
            // Reset board before each test case
            BoardLogic.clearBoard();

            HexCube redHex1 = new HexCube(0, 0, 0);
            HexCube blueHex2 = new HexCube(1, -1, 0);

            BoardLogic.addToList(redHex1, true);   // Red move
            BoardLogic.addToList(blueHex2, false); // Blue move


            BoardLogic.addToList(newRedHex, true); // Red move


            Set<HexCube> expectedRed = new HashSet<>(Arrays.asList(
                    redHex1,
                    newRedHex
            ));
            Set<HexCube> expectedBlue = new HashSet<>(); // Should be empty if captured

            assertEquals(expectedRed, getRedHexMap().keySet());
            assertEquals(expectedBlue, getBlueHexMap().keySet());
        }
    }



}

class NonCaptureMoveTests {
    @BeforeEach
    void setup() {
        BoardLogic.testMode = true;
        BoardLogic.clearBoard();
    }

    @Test
    void testInvalidMoveNextToSameColorNoCapture() throws Exception {
        getRedHexMap().put(new HexCube(0, 0, 0), 0);
        HexCube move = new HexCube(1, -1, 0);
        assertFalse(BoardLogic.isValidMove(move, true));
    }

    @Test
    void testValidMoveNotAdjacentAndNotCapture() {
        HexCube move = new HexCube(5, 5, -10);
        assertTrue(BoardLogic.isValidMove(move, true));
    }

    @Test
    void testAddToListAssignsGroupNumber() throws Exception {
        HexCube move1 = new HexCube(new Point(100, 100));
        HexCube move2 = new HexCube(new Point(200, 200));
        BoardLogic.addToList(move1, true);
        BoardLogic.addToList(move2, true);

        //checking that the red hexagons do not get assigned the dummy value -1, which is only used temporarily in canCapture() for simulation
        assertNotEquals(-1, getRedHexMap().get(move1));
        assertNotEquals(-1, getRedHexMap().get(move2));
    }
}