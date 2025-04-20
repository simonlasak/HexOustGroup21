package UIPackage;

import java.lang.reflect.Field;
import java.util.HashMap;

public class BoardTestUtils {

    @SuppressWarnings("unchecked")
    public static HashMap<HexCube, Integer> getRedHexMap() throws Exception {
        Field redField = BoardLogic.class.getDeclaredField("redHexagons");
        redField.setAccessible(true);
        return (HashMap<HexCube, Integer>) redField.get(null);
    }

    @SuppressWarnings("unchecked")
    public static HashMap<HexCube, Integer> getBlueHexMap() throws Exception {
        Field blueField = BoardLogic.class.getDeclaredField("blueHexagons");
        blueField.setAccessible(true);
        return (HashMap<HexCube, Integer>) blueField.get(null);
    }
}