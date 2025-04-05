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

    public static int listSize(boolean isRedTurn) {
        if (isRedTurn){
            return blueHexagons.size();
        }
        else{
            return redHexagons.size();
        }
    }



    private static boolean canCapture(HexCube c, boolean isRedTurn) {
        // simulate temporary placement
        HashMap<HexCube, Integer> ownMap = isRedTurn ? redHexagons : blueHexagons;
        HashMap<HexCube, Integer> opponentMap = isRedTurn ? blueHexagons : redHexagons;

        // Temporarily add it to the player's color map
        ownMap.put(c, -1); // use dummy group number, just for lookup
        List<HexCube> newGroup = getGroup(c, isRedTurn);
        ownMap.remove(c); // remove simulation

        int newGroupSize = newGroup.size();
        Set<Integer> checkedGroups = new HashSet<>();

        for (HexCube h : newGroup) {
            for (HexCube n : h.getAllNeighbours()) {
                if (opponentMap.containsKey(n)) {
                    int groupId = opponentMap.get(n);
                    if (checkedGroups.contains(groupId)) continue;

                    checkedGroups.add(groupId);
                    List<HexCube> opponentGroup = getGroup(n, !isRedTurn);
                    if (newGroupSize <= opponentGroup.size()) {
                        return false; // not allowed, there's a larger or equal-sized opponent group
                    }
                }
            }
        }

        return checkedGroups.size() > 0;  // true only if it touches at least one opponent group and all are smaller
        //ie the size is greater than zero
    }


    private static void checkCapture(HexCube c, boolean isRedTurn) {
        HashMap<HexCube, Integer> opponentMap = isRedTurn ? blueHexagons : redHexagons;
        HashMap<HexCube, Integer> ownMap = isRedTurn ? redHexagons : blueHexagons;

        List<HexCube> newGroup = getGroup(c, isRedTurn);
        int newGroupSize = newGroup.size();
        Set<HexCube> toRemove = new HashSet<>();

        for (HexCube h : newGroup) {
            for (HexCube n : h.getAllNeighbours()) {
                if (opponentMap.containsKey(n)) {
                    List<HexCube> opponentGroup = getGroup(n, !isRedTurn);
                    if (newGroupSize > opponentGroup.size()) {
                        toRemove.addAll(opponentGroup);
                    }
                }
            }
        }

        for (HexCube hex : toRemove) {
            repaintHexagons(hex);
            opponentMap.remove(hex);
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
