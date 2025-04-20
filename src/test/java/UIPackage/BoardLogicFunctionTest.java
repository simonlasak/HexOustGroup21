package UIPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static UIPackage.BoardTestUtils.*;
class BoardLogicFunctionTest {
    @BeforeEach
    void setup() throws Exception {
        BoardLogic.testMode = true;
        BoardLogic.clearBoard();
    }


    @Test
    void testClearBoard() throws Exception {
        HexCube move1 = new HexCube(new Point(100, 100));
        HexCube move2 = new HexCube(new Point(200, 200));
        BoardLogic.addToList(move1, true);
        BoardLogic.addToList(move2, false);

        assertFalse(getRedHexMap().isEmpty() || getBlueHexMap().isEmpty());
        BoardLogic.clearBoard();
        assertTrue(getRedHexMap().isEmpty());
        assertTrue(getBlueHexMap().isEmpty());
    }

    @Test
    void testCheckGameWonRedWins() throws Exception {
        getRedHexMap().put(new HexCube(0, 0, 0), 0);
        getRedHexMap().put(new HexCube(1, -1, 0), 0);
        assertTrue(BoardLogic.checkGameWon(true));
    }

    @Test
    void testCheckGameWonBlueWins() throws Exception {
        getBlueHexMap().put(new HexCube(0, 0, 0), 0);
        getBlueHexMap().put(new HexCube(1, -1, 0), 0);
        getBlueHexMap().put(new HexCube(2, -2, 0), 0);
        assertTrue(BoardLogic.checkGameWon(false));
    }

    @Test
    void testCheckGameNotWon() throws Exception {
        getRedHexMap().put(new HexCube(0, 0, 0), 0);
        getBlueHexMap().put(new HexCube(1, -1, 0), 0);

        assertFalse(BoardLogic.checkGameWon(true));
        assertFalse(BoardLogic.checkGameWon(false));
    }

    @Test
    void testAddToListAddsHexagonCorrectly() throws Exception {
        HexCube hex = new HexCube(new Point(100, 100));
        BoardLogic.addToList(hex, true);
        assertTrue(getRedHexMap().containsKey(hex));
    }

    @Test
    void testListSizeCountsCorrectly() {
        HexCube redHex = new HexCube(new Point(100, 100));
        HexCube blueHex = new HexCube(new Point(200, 200));
        BoardLogic.addToList(redHex, true);
        BoardLogic.addToList(blueHex, false);
        assertEquals(1, BoardLogic.listSize(false)); // red size
        assertEquals(1, BoardLogic.listSize(true));  // blue size
    }

    @Test
    void testAddToListIncreasesRedSize() throws Exception {
        HexCube move = new HexCube(new Point(300, 300));
        int before = getRedHexMap().size();
        BoardLogic.addToList(move, false);
        assertEquals(before + 1, BoardLogic.listSize(true));
    }

    @Test
    void testRepaintHexagons_SkipInTestMode() {
        BoardLogic.testMode = true;
        HexCube c = new HexCube(0, 0, 0);
        assertDoesNotThrow(() -> BoardLogic.repaintHexagons(c));
    }

    @Test
    void testGetGroup_ReturnsConnectedHexes() throws Exception {
        HexCube a = new HexCube(0, 0, 0);
        HexCube b = new HexCube(1, -1, 0);
        getRedHexMap().put(a, 1);
        getRedHexMap().put(b, 1);

        Method method = BoardLogic.class.getDeclaredMethod("getGroup", HexCube.class, boolean.class);
        method.setAccessible(true);

        @SuppressWarnings("unchecked")
        List<HexCube> group = (List<HexCube>) method.invoke(null, a, true);

        assertEquals(2, group.size());
        assertTrue(group.contains(b));
    }

    @Test
    void testFindGroupNumber_UsesNeighborGroup() throws Exception {
        HexCube a = new HexCube(0, 0, 0);
        getRedHexMap().put(a, 5);

        HexCube b = new HexCube(1, -1, 0);

        Method method = BoardLogic.class.getDeclaredMethod("findGroupNumber", HexCube.class, boolean.class);
        method.setAccessible(true);

        int group = (int) method.invoke(null, b, true);
        assertEquals(5, group);
    }

    @Test
    void testRemoveDuplicates_RemovesDuplicatesCorrectly() {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 1);
        List<Integer> result = BoardLogic.removeDuplicates(list);
        assertEquals(3, result.size());
        assertTrue(result.containsAll(Arrays.asList(1, 2, 3)));
    }
}
