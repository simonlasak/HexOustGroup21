package UIPackage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardLogic {

    //private static List<HexCube> redHexagons = new ArrayList<>();
    //private static List<HexCube> blueHexagons = new ArrayList<>();


    private static List<Map<HexCube, String>> redGroups = new ArrayList<>();
    private static List<Map<HexCube, String>> blueGroups = new ArrayList<>();

    private static HashMap<HexCube, Integer> redHexagons = new HashMap<>();
    private static HashMap<HexCube, Integer> blueHexagons = new HashMap<>();

    private static int nextGroupNumber = 0;


    public static void addToList(HexCube c, boolean isRedTurn) {


        int groupNumber = findGroupNumber(c, isRedTurn);

        if (isRedTurn) {
            redHexagons.put(c, groupNumber);
        }
        else {
            blueHexagons.put(c, groupNumber);
        }
    }


    public static void printLists() {
        System.out.println("Red Hexagons: " + redHexagons + "\nBlue Hexagons: " + blueHexagons);
    }

    public static boolean isValidMove(HexCube c, boolean isRedTurn) {
        List<HexCube> neighbours = c.getAllNeighbours();

        //first we need to check that the hexagon isnt already occupied
        if (redHexagons.containsKey(c) || blueHexagons.containsKey(c)) {
            return false;
        }


        // if a red/blue hexagon exists adjacent to c, the move is invalid.
        if (isRedTurn) {
            for (HexCube neighbour : neighbours) {
                if (redHexagons.containsKey(neighbour)) {
                    return false;
                }
            }
        } else {
            for (HexCube neighbour : neighbours) {
                if (blueHexagons.containsKey(neighbour)) {
                    return false;
                }
            }
        }

        return true;
    }


    public static int findGroupNumber(HexCube c, boolean isRedTurn){

        List<Integer> foundGroups = new ArrayList<>();

        List<HexCube> neighbours = c.getAllNeighbours();

        //finding adjacent groupnumbers
        if (isRedTurn) {
            for (HexCube neighbour : neighbours) {
                if (redHexagons.containsKey(neighbour)) {
                    foundGroups.add(redHexagons.get(neighbour));
                }
            }
        } else {
            for (HexCube neighbour : neighbours) {
                if (blueHexagons.containsKey(neighbour)) {
                    foundGroups.add(blueHexagons.get(neighbour));
                }
            }
        }

        foundGroups = removeDuplicates(foundGroups);

        //if theres no neighbouring groups found
        if (foundGroups.size() == 0) {
            return nextGroupNumber++;
        }

        //if theres only one neighbouring group found
        if (foundGroups.size() == 1) {
            return foundGroups.get(0);
        }

        //if theres more than one neighbouring group found
        else{
            int groupNumber = foundGroups.get(0);
            for (int num : foundGroups) {

                if (isRedTurn) {
                    for (HexCube hex : redHexagons.keySet()) {
                        if (redHexagons.get(hex) == num) {
                            redHexagons.put(hex, groupNumber);
                        }
                    }
                } else {
                    for (HexCube hex : blueHexagons.keySet()) {
                        if (blueHexagons.get(hex) == num) {
                            blueHexagons.put(hex, groupNumber);
                        }
                    }
                }




            }
            return groupNumber;
        }

    }


    public static List<Integer> removeDuplicates(List<Integer> list) {
        List<Integer> uniqueList = new ArrayList<>();
        for (int num : list) {
            if (!uniqueList.contains(num)) {
                uniqueList.add(num);
            }
        }
        return uniqueList;
    }

}
