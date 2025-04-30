package UIPackage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a 2D point in the UI coordinate system.
 * Used for converting between hexagonal grid coordinates and UI coordinates.
 */
class Point {
    public final double x;
    public final double y;

    /**
     * Creates a point with the specified coordinates.
     *
     * @param x The x-coordinate
     * @param y The y-coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * Represents a hexagon in a cube coordinate system.
 * Uses a 3D coordinate system (q,r,s) where q + r + s = 0 to represent
 * positions on a hexagonal grid.
 */
class HexCube {
    public final int q;
    public final int r;
    public final int s;

    /**
     * Creates a hexagon with the specified cube coordinates.
     *
     * @throws IllegalArgumentException if q + r + s != 0
     */
    public HexCube(int q, int r, int s) {
        this.q = q;
        this.r = r;
        this.s = s;
        if (q + r + s != 0)
            throw new IllegalArgumentException("q + r + s must be 0");
    }

    /**
     * Creates a hexagon from a UI point, converting screen coordinates to cube coordinates.
     *
     * @param p The UI point to convert
     * @throws IllegalArgumentException if the resulting coordinates don't satisfy q + r + s = 0
     */
    public HexCube(Point p) {
        int q = (int) ((p.x - 300) / 37);
        int r = (int) (((p.y - 300)/ 22 - q) / 2);
        int s = -q-r;
        this.q = q;
        this.r = r;
        this.s = s;

        if (q + r + s != 0)
            throw new IllegalArgumentException("q + r + s must be 0");
    }

    /**
     * Converts cube coordinates to UI point coordinates.
     *
     * @param c The cube coordinates to convert
     * @return The corresponding UI point
     * @throws IllegalArgumentException if the cube coordinates don't satisfy q + r + s = 0
     */
    public static Point getPointFromHexCube(HexCube c) {
        if (c.q + c.r + c.s != 0) {
            throw new IllegalArgumentException("q + r + s must be 0");
        }
        int x = 300 + 37 * c.q;
        int y = 300 + 22 * (c.q + 2 * c.r);
        return new Point(x, y);
    }

    /**
     * Adds another hex cube's coordinates to this one.
     *
     * @param b The hex cube to add
     * @return A new hex cube with the sum of coordinates
     */
    public HexCube add(HexCube b) {
        return new HexCube(q + b.q, r + b.r, s + b.s);
    }

    /**
     * Subtracts another hex cube's coordinates from this one.
     *
     * @param b The hex cube to subtract
     * @return A new hex cube with the difference of coordinates
     */
    public HexCube subtract(HexCube b) {
        return new HexCube(q - b.q, r - b.r, s - b.s);
    }

    /**
     * The six directions around a hexagon, represented as cube coordinate vectors.
     */
    static public ArrayList<HexCube> directions = new ArrayList<HexCube>(){
        {
            add(new HexCube(1, 0, -1));
            add(new HexCube(1, -1, 0));
            add(new HexCube(0, -1, 1));
            add(new HexCube(-1, 0, 1));
            add(new HexCube(-1, 1, 0));
            add(new HexCube(0, 1, -1));
        }
    };

    /**
     * Gets the direction vector for a specific direction.
     *
     * @param direction Direction index (0-5)
     * @return The direction vector
     */
    static public HexCube direction(int direction) {
        return HexCube.directions.get(direction);
    }

    /**
     * Gets the neighboring hex in a specific direction.
     *
     * @param direction Direction index (0-5)
     * @return The neighboring hex
     */
    public HexCube neighbour(int direction) {
        return add(HexCube.direction(direction));
    }

    /**
     * Gets all six neighboring hexes.
     *
     * @return A list of all adjacent hexagons
     */
    public List<HexCube> getAllNeighbours() {
        List<HexCube> adjHexes = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            //adding to array adjHexes
            //"this" refers to the hexagon we call neighbour method on
            adjHexes.add(this.neighbour(i));
        }
        return adjHexes;
    }

    /**
     * Returns a string representation of the hex cube.
     *
     * @return String in format "(q, r, s)"
     */
    @Override
    public String toString() {
        return "("+ q + ", " + r + ", " + s + ")";
    }

    /**
     * Compares this hex cube with another object for equality.
     * Two hex cubes are equal if they have the same q, r, and s coordinates.
     *
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Check if both objects are the same instance
        if (obj == null || getClass() != obj.getClass()) return false;  // Check if obj is null or not the same class

        HexCube other = (HexCube) obj;  // Cast the object to HexCube
        return this.q == other.q && this.r == other.r && this.s == other.s;  // Compare q, r, and s
    }

    /**
     * Generates a hash code for this hex cube.
     * Necessary for use in HashMap.
     *
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(q, r, s);
    }
}