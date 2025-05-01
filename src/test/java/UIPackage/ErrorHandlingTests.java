package UIPackage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;


@Nested
@DisplayName("Error Handling Tests")
class ErrorHandlingTests {
    
    @BeforeEach
    void setup() {
        BoardLogic.testMode = true;
        BoardLogic.clearBoard();
    }

    @Test
    @DisplayName("Should reject null HexCube")
    void testNullHexCube() {
        assertThrows(NullPointerException.class, () -> {
            BoardLogic.addToList(null, true);
        });
    }

    @Test
    @DisplayName("Should reject invalid coordinates")
    void testInvalidCoordinates() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HexCube(100, 100, 100); // Sum not zero
        });
    }

    @Test
    @DisplayName("Should handle out of bounds points")
    void testOutOfBoundsPoints() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Point(-1, -1); // Negative coordinates
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Point(601, 601); // Beyond board size
        });
    }


}