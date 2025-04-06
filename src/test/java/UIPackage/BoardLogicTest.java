package UIPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static UIPackage.BoardLogic.redHexagons;
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