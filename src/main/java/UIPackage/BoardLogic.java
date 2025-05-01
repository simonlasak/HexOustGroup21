package UIPackage;
import java.util.*;

/**
 * This class contains the core game logic for the HexOust board game.
 * It manages the state of the game board, tracks player pieces, and
 * handles game rules such as move validation and capture mechanics.
 */
public class BoardLogic {
    //these were private but for junit testing, we have removed the private
    private static HashMap<HexCube, Integer> redHexagons = new HashMap<>();
    private static HashMap<HexCube, Integer> blueHexagons = new HashMap<>();
    private static int nextGroupNumber = 0;
    public static boolean testMode = false;

    /**
     * Checks if the current player has won the game.
     * A player wins when they have 2 or more hexagons and the opponent has none.
     *
     * @param isRedTurn true if it's Red player's turn, false if it's Blue player's turn
     * @return true if the current player has won, false otherwise
     */
    public static boolean checkGameWon(boolean isRedTurn) {
        if (isRedTurn && BoardLogic.blueHexagons.isEmpty() && (BoardLogic.redHexagons.size() >= 2)) {
            return true;
        } else if (!isRedTurn && BoardLogic.redHexagons.isEmpty() && (BoardLogic.blueHexagons.size() >= 2)) {
            return true;
        }
        return false;
    }

    /**
     * Adds a hexagon to the current player's collection and checks for captures.
     *
     * @param c The HexCube coordinates to add
     * @param isRedTurn true if it's Red player's turn, false if it's Blue player's turn
     */
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

    /**
     * Determines if placing a hexagon at the specified coordinates is a valid move.
     * A move is valid if:
     * 1. The hex position is not already occupied
     * 2. The hex position is not adjacent to a hex of the same color, unless it's a capturing move
     *
     * @param c The hex coordinates to check
     * @param isRedTurn true if checking for Red player, false for Blue player
     * @return true if the move is valid, false otherwise
     */
    public static boolean isValidMove(HexCube c, boolean isRedTurn) {
        if (redHexagons.containsKey(c) || blueHexagons.containsKey(c)) {
            return false;
        }
        List<HexCube> neighbours = c.getAllNeighbours();

        if(canCapture(c, isRedTurn)) {
            return true;
        }

        for (HexCube neighbour : neighbours) {
            if (((isRedTurn && redHexagons.containsKey(neighbour)) ||
                    (!isRedTurn && blueHexagons.containsKey(neighbour)))) {
                return false;
            }
        }
        //no need to check for capturing if hex has no same colour neighbor

        return true;
    }

    /**
     * Prints the current state of the board (red and blue hexagons) to standard output.
     * Used primarily for debugging purposes.
     */
    public static void printLists() {
        System.out.println("Red Hexagons: " + redHexagons + "\nBlue Hexagons: " + blueHexagons);
    }

    /**
     * Returns the number of hexagons owned by the opposing player.
     *
     * @param isRedTurn true if it's Red player's turn, false if it's Blue player's turn
     * @return count of opponent's hexagons
     */
    public static int listSize(boolean isRedTurn) {
        if (isRedTurn){
            return blueHexagons.size();
        }
        else{
            return redHexagons.size();
        }
    }

    /**
     * Determines if placing a hexagon at the specified coordinates will result in a capture.
     * A capture is possible when the resulting group would be larger than any adjacent opponent groups.
     *
     * @param c The hex coordinates to check
     * @param isRedTurn true if checking for Red player, false for Blue player
     * @return true if placing a hexagon here would result in a capture, false otherwise
     */
    private static boolean canCapture(HexCube c, boolean isRedTurn) {
        // simulate temporary placement
        HashMap<HexCube, Integer> ownMap = isRedTurn ? redHexagons : blueHexagons;
        HashMap<HexCube, Integer> opponentMap = isRedTurn ? blueHexagons : redHexagons;

        // temporarily add it to the player's color map
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

    /**
     * Processes captures that result from placing a hexagon.
     * Removes all opponent hexagons in groups that are smaller than the current player's group.
     *
     * @param c The hex coordinates of the newly placed hexagon
     * @param isRedTurn true if it's Red player's turn, false if it's Blue player's turn
     */
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
            repaintHexagons(hex); //visually alter the board, repaint the hexagons using method below
            opponentMap.remove(hex);
        }
    }

    /**
     * Updates the UI to repaint a hexagon back to the base color.
     * This is called when a hexagon is captured and needs to be visually removed.
     *
     * @param c The hex coordinates of the hexagon to repaint
     */
    public static void repaintHexagons(HexCube c) {
        if (testMode) return; // this is for skipping ui during test cases

        Point p = HexCube.getPointFromHexCube(c);
        hexOustUIController.repaintToBase((int)p.x, (int)p.y);
    }

    /**
     * Gets all hexagons in the same connected group as the starting hexagon.
     *
     * @param start The starting hexagon coordinates
     * @param isRed true if checking for Red player groups, false for Blue player groups
     * @return A list of all hexagons in the connected group
     */
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

    /**
     * Gets the size of a connected group of hexagons.
     *
     * @param c The hexagon coordinates to check
     * @param isRed true if checking for Red player groups, false for Blue player groups
     * @return The number of hexagons in the connected group
     */
    private static int getGroupSize(HexCube c, boolean isRed) {
        return getGroup(c, isRed).size();
    }

    /**
     * Finds and assigns a group number for a new hexagon.
     * If the hexagon connects to existing groups, it merges those groups.
     *
     * @param c The hexagon coordinates
     * @param isRedTurn true if it's Red player's turn, false if it's Blue player's turn
     * @return The group number for the hexagon
     */
    private static int findGroupNumber(HexCube c, boolean isRedTurn) {
        List<Integer> foundGroups = new ArrayList<>();
        List<HexCube> neighbours = c.getAllNeighbours();

        Map<HexCube, Integer> colourHexagons;
        if (isRedTurn) {
            colourHexagons = redHexagons;
        } else {
            colourHexagons = blueHexagons;
        }




        for (HexCube neighbour : neighbours) {
            if (colourHexagons.containsKey(neighbour)) {
                foundGroups.add(colourHexagons.get(neighbour));
            }
        }

        foundGroups = removeDuplicates(foundGroups);
        if (foundGroups.isEmpty()) {
            return nextGroupNumber++;
        }

        int groupNumber = foundGroups.get(0);
        for (int num : foundGroups) {
            for (HexCube hex : colourHexagons.keySet()) {
                if (colourHexagons.get(hex) == num) {
                    colourHexagons.put(hex, groupNumber);
                }
            }
        }

        return groupNumber;
    }

    /**
     * Removes duplicate values from a list of integers.
     *
     * @param list The list from which to remove duplicates
     * @return A new list containing only unique values
     */
    public static List<Integer> removeDuplicates(List<Integer> list) {
        return new ArrayList<>(new HashSet<>(list));
    }

    /**
     * Clears the board by removing all hexagons from both players.
     * Used when resetting the game.
     */
    public static void clearBoard() {
        redHexagons.clear();
        blueHexagons.clear();
    }
}