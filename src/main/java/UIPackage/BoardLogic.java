package UIPackage;
import java.util.*;
import javafx.scene.paint.Color;

public class BoardLogic {

    private static HashMap<HexCube, Integer> redHexagons = new HashMap<>();
    private static HashMap<HexCube, Integer> blueHexagons = new HashMap<>();
    private static int nextGroupNumber = 0;

    public static void addToList(HexCube c, boolean isRedTurn) {
        int groupNumber = findGroupNumber(c, isRedTurn);
        if (isRedTurn) {
            redHexagons.put(c, groupNumber);
            checkCapture(c, isRedTurn);
        } else {
            blueHexagons.put(c, groupNumber);
            checkCapture(c, isRedTurn);
        }
    }

    public static boolean isValidMove(HexCube c, boolean isRedTurn) {
        if (redHexagons.containsKey(c) || blueHexagons.containsKey(c)) {
            return false;
        }
        List<HexCube> neighbours = c.getAllNeighbours();

        if(canCapture(c, isRedTurn)) {
            //System.out.println("iscapturing");
            return true;
        }
        //if (isCapturing) System.out.println("isCapturing");

        //fix this--place a hexagon next to same colors only in the case when it is a capturing move
        for (HexCube neighbour : neighbours) {
            if (((isRedTurn && redHexagons.containsKey(neighbour)) ||
                    (!isRedTurn && blueHexagons.containsKey(neighbour)))) {
                return false;
            }
        }

        //no need to check for capturing if hex has no samecolor neighbor

        return true;
    }

    public static void printLists() {
        System.out.println("Red Hexagons: " + redHexagons + "\nBlue Hexagons: " + blueHexagons);
    }

    private static boolean canCapture(HexCube c, boolean isRedTurn) {
        List<HexCube> neighbours = c.getAllNeighbours();
        int ownGroupSize = getGroupSize(c, isRedTurn);

        //this ensures no same group is counted multiple times
        List<Integer> groupNumbers = new ArrayList<>();
        HashMap<HexCube, Integer> opponentMap = isRedTurn ? blueHexagons : redHexagons;

        //collect all group numbers
        for (HexCube neighbour : neighbours) {
            if (opponentMap.containsKey(neighbour)) {
                groupNumbers.add(opponentMap.get(neighbour));
            }
        }

        //remove duplicates
        List<Integer> uniqueGroups = removeDuplicates(groupNumbers);
        //System.out.println(uniqueGroups);

        //calculate total opponent size
        int opponentGroupSize = 0;
        for (Integer groupNum : uniqueGroups) {
            //we only need to get size of one hex from each group
            for (HexCube hex : opponentMap.keySet()) {
                if (opponentMap.get(hex) == groupNum) {
                    int currentGroupSize = getGroupSize(hex, !isRedTurn);
                    opponentGroupSize = Math.max(opponentGroupSize, currentGroupSize);
                    break; //found one hex from this group, terminate inner loop
                }
            }
        }

        if (opponentGroupSize == 0) return false;
        return ownGroupSize > opponentGroupSize;
    }

    private static void checkCapture(HexCube c, boolean isRedTurn) {
        List<HexCube> neighbours = c.getAllNeighbours();
        List<HexCube> toRemove = new ArrayList<>();

        for (HexCube neighbour : neighbours) {
            if ((isRedTurn && blueHexagons.containsKey(neighbour)) ||
                    (!isRedTurn && redHexagons.containsKey(neighbour))) {
                List<HexCube> opponentGroup = getGroup(neighbour, !isRedTurn);
                if (getGroupSize(c, isRedTurn) > opponentGroup.size()) {
                    toRemove.addAll(opponentGroup);
                }
            }
        }

        for (HexCube hex : toRemove) {
            repaintHexagons(hex);
            if (isRedTurn) {
                blueHexagons.remove(hex);
            } else {
                redHexagons.remove(hex);
            }
        }
    }

    public static void repaintHexagons(HexCube c) {
        Point p = HexCube.getPointFromHexCube(c);
        hexOustUIController.repaintToBase((int)p.x, (int)p.y);
    }


    private static List<HexCube> getGroup(HexCube start, boolean isRed) {
        HashMap<HexCube, Integer> map = isRed ? redHexagons : blueHexagons;
        List<HexCube> group = new ArrayList<>();
        Queue<HexCube> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            HexCube current = queue.poll();
            if (!group.contains(current)) {
                group.add(current);
                for (HexCube neighbour : current.getAllNeighbours()) {
                    if (map.containsKey(neighbour) && !group.contains(neighbour)) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        return group;
    }

    private static int getGroupSize(HexCube c, boolean isRed) {
        return getGroup(c, isRed).size();
    }

    private static int findGroupNumber(HexCube c, boolean isRedTurn) {
        List<Integer> foundGroups = new ArrayList<>();
        List<HexCube> neighbours = c.getAllNeighbours();

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

        if (foundGroups.isEmpty()) {
            return nextGroupNumber++;
        }

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

    public static List<Integer> removeDuplicates(List<Integer> list) {
        return new ArrayList<>(new HashSet<>(list));
    }
}
