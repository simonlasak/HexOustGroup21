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

    public static boolean isValidMove(HexCube c, boolean isRedTurn) {
        List<HexCube> neighbours = c.getAllNeighbours();
        if (isRedTurn) {
            //n squared complexity. Any improvements?
            //even when you fill table you don't notice any delays, probably no improvements needed
            for (HexCube hex : redHexagons) {
                for (HexCube neighbour : neighbours) {
                    if (hex.equals(neighbour)) {
                        //should check if it's a capturing move here
                        return false;
                    }
                }
            }
        }
        else{
            for (HexCube hex : blueHexagons) {
                for (HexCube neighbour : neighbours) {
                    if (hex.equals(neighbour)) {
                        //should check if it's a capturing move here
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
