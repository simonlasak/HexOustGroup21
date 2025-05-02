package UIPackage;
import org.junit.jupiter.api.*;

import java.util.Set;

import static UIPackage.BoardTestUtils.*;
import static org.junit.jupiter.api.Assertions.*;
@Nested
@DisplayName("Complex Game Scenarios")
class MergingGroupTests {
    
    @BeforeEach
    void setup() {
        BoardLogic.testMode = true;
        BoardLogic.clearBoard();
    }

    @Test
    @DisplayName("Should handle group merging correctly")
    void testGroupMerging() throws Exception {
        // Create two separate groups
        HexCube hex1 = new HexCube(-1, 0, 1);
        HexCube hex2 = new HexCube(1, 0, -1);
        HexCube mergingHex = new HexCube(0, 0, 0);
        
        BoardLogic.addToList(hex1, true);
        BoardLogic.addToList(hex2, true);
        BoardLogic.addToList(mergingHex, true);
        
        // Verify groups are merged
        int group1 = getRedHexMap().get(hex1);
        int group2 = getRedHexMap().get(hex2);
        int mergingGroup = getRedHexMap().get(mergingHex);
        
        assertEquals(group1, group2);
        assertEquals(group1, mergingGroup);
    }

    private void setupMultipleGroups() throws Exception {
        // Setup helper method for complex board positions
        getBlueHexMap().put(new HexCube(-2, 1, 1), 1);
        getBlueHexMap().put(new HexCube(2, -1, -1), 2);
        getBlueHexMap().put(new HexCube(0, 2, -2), 3);
    }@Test
@DisplayName("Should merge three red groups into one")
void testTripleGroupMerge() throws Exception {
    HexCube a = new HexCube(-1, 0, 1);
    HexCube b = new HexCube(1, -1, 0);
    HexCube c = new HexCube(0, 1, -1);
    HexCube center = new HexCube(0, 0, 0);

    BoardLogic.addToList(a, true);
    BoardLogic.addToList(b, true);
    BoardLogic.addToList(c, true);

    BoardLogic.addToList(center, true);

    int group = getRedHexMap().get(center);
    assertEquals(group, getRedHexMap().get(a));
    assertEquals(group, getRedHexMap().get(b));
    assertEquals(group, getRedHexMap().get(c));
}
}
class MultipleGroupMergeTests{

    @Test
    @DisplayName("Should merge three red groups into one")
    void testTripleGroupMerge() throws Exception {
        HexCube a = new HexCube(-1, 0, 1);
        HexCube b = new HexCube(1, -1, 0);
        HexCube c = new HexCube(0, 1, -1);
        HexCube center = new HexCube(0, 0, 0);

        BoardLogic.addToList(a, true);
        BoardLogic.addToList(b, true);
        BoardLogic.addToList(c, true);

        BoardLogic.addToList(center, true);

        int group = getRedHexMap().get(center);
        assertEquals(group, getRedHexMap().get(a));
        assertEquals(group, getRedHexMap().get(b));
        assertEquals(group, getRedHexMap().get(c));
    }
}

class CaptureAfterGroupMergeTests {
    @Test
    @DisplayName("Should capture after red groups merge into a larger one")
    void testCaptureAfterGroupMerge() throws Exception {
        BoardLogic.clearBoard();
        BoardLogic.testMode = true;

        // Blue group of size 2 that will be captured
        HexCube blue1 = new HexCube(-1, 1, 0);
        HexCube blue2 = new HexCube(-2, 1, 1);
        BoardLogic.addToList(blue1, false);
        BoardLogic.addToList(blue2, false);

        // Red pieces that are not connected yet
        HexCube redA = new HexCube(-1, 0, 1);
        HexCube redB = new HexCube(0, -1, 1);
        HexCube redC = new HexCube(0, 1, -1);

        BoardLogic.addToList(redA, true); // Group 1
        BoardLogic.addToList(redB, true); // Group 2
        BoardLogic.addToList(redC, true); // Group 3

        // This move connects all red pieces into one group and is adjacent to blue1
        HexCube mergeAndCaptureMove = new HexCube(0, 0, 0);

        // Is valid as the merged red group (size 4) can capture the blue group (size 2)
        assertTrue(BoardLogic.isValidMove(mergeAndCaptureMove, true),
                "Merged red group should be large enough to capture blue group");

        BoardLogic.addToList(mergeAndCaptureMove, true); // Perform the move

        // Verify blue group is captured
        assertFalse(getBlueHexMap().containsKey(blue1), "Blue1 should be captured");
        assertFalse(getBlueHexMap().containsKey(blue2), "Blue2 should be captured");

        // Verify red group now includes all 4 hexes
        Set<HexCube> expectedRed = Set.of(redA, redB, redC, mergeAndCaptureMove);
        assertTrue(getRedHexMap().keySet().containsAll(expectedRed), "Red group should contain all merged pieces");
    }
}