package UIPackage;
import java.util.ArrayList;
import java.util.List;

public class BoardLogic {
    private static List<HexCube> redHexagons = new ArrayList<>();
    private static List<HexCube> blueHexagons = new ArrayList<>();

    public static void addToList(HexCube c, boolean isRedTurn) {
        if (isRedTurn) {
            redHexagons.add(c);

        }
        else {
            blueHexagons.add(c);
        }
    }


    public static void printLists() {
        System.out.println("Red Hexagons: " + redHexagons + "\nBlue Hexagons: " + blueHexagons);
    }

    public static boolean isValidMove(){

        return True
    }
}
