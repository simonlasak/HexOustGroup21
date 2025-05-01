package UIPackage;
import org.junit.jupiter.api.*;
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