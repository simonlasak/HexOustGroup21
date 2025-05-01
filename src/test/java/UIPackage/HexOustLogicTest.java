package UIPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    void testValidEdgeMove() {
        HexCube edgeMove = new HexCube(0, 300, -300); // Assuming this is edge
        assertTrue(BoardLogic.isValidMove(edgeMove, true));
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

class CaptureTestLogicExtra {

    @BeforeEach
    void setup() {
        BoardLogic.testMode = true;
        BoardLogic.clearBoard();
    }

    @Test
    @DisplayName("Should capture when attacker group becomes larger")
    void testNoCaptureSameSize() throws Exception {
        // Setup two connected blue pieces
        HexCube blue1 = new HexCube(-2, 1, 1);
        HexCube blue2 = new HexCube(-1, 1, 0);
        getBlueHexMap().put(blue1, 1);
        getBlueHexMap().put(blue2, 1);

        // Setup two connected red pieces
        HexCube red1 = new HexCube(1, -1, 0);
        HexCube red2 = new HexCube(2, -1, -1);
        BoardLogic.addToList(red1, true);
        BoardLogic.addToList(red2, true);

        // Place red piece that would make group size 3
        HexCube redMove = new HexCube(0, 0, 0);

        // Should be valid capturing move (3 vs 2)
        assertTrue(BoardLogic.isValidMove(redMove, true),
                "Move should be valid as red group (size 3) can capture blue group (size 2)");

        BoardLogic.addToList(redMove, true);

        // Verify capture occurred
        assertTrue(getBlueHexMap().isEmpty(), "Blue group should be captured");
        assertEquals(3, getRedHexMap().size(), "Red should have 3 pieces");
    }

    @Test
    @DisplayName("Should not capture when red and blue group sizes are equal")
    void testNoCaptureWhenGroupsEqualSize() throws Exception {
        BoardLogic.testMode = true;
        BoardLogic.clearBoard();

        // Red group of size 1
        getRedHexMap().put(new HexCube(-1, -1, 2), 0);


        // Blue group of size 2
        getBlueHexMap().put(new HexCube(0, -1, 1), 1);
        getBlueHexMap().put(new HexCube(-1, 0, 1), 1);

        // Red tries to place a piece adjacent to blue group
        //Red group would be of size 2
        HexCube redMove = new HexCube(-2, 0, 2);

        // Should not be valid because group sizes are equal
        assertFalse(BoardLogic.isValidMove(redMove, true),
                "Move should be invalid as red group is not larger than blue group");
    }

    @Test
    @DisplayName("Valid capture: red group bigger than touching blue group")
    void testValidCaptureByRed() throws Exception {
        BoardLogic.clearBoard();
        BoardLogic.testMode = true;

        // Setup red group of size 3
        BoardLogic.addToList(new HexCube(-1, 0, 1), true);
        BoardLogic.addToList(new HexCube(-2, 0, 2), true);
        BoardLogic.addToList(new HexCube(-1, -1, 2), true);

        // Setup blue group of size 1
        BoardLogic.addToList(new HexCube(0, 0, 0), false);

        HexCube capturingMove = new HexCube(0, -1, 1); // Next to blue, part of red group

        boolean valid = BoardLogic.isValidMove(capturingMove, true);

        assertTrue(valid, "Red should be allowed to capture smaller blue group");
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

    @Test
    @DisplayName("Invalid move: adjacent same-color piece (no capture)")
    void testInvalidMoveAdjacentSameColor() {
        BoardLogic.clearBoard();
        BoardLogic.testMode = true;

        HexCube existing = new HexCube(0, 0, 0);
        HexCube newMove = new HexCube(1, -1, 0); // Adjacent to existing

        BoardLogic.addToList(existing, true); // Red move

        boolean valid = BoardLogic.isValidMove(newMove, true); // Another red move

        assertFalse(valid, "Move should be invalid due to adjacent same-color piece");
    }
}