package UIPackage;
import java.util.ArrayList;
import java.util.List;

class Point
{
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public final double x;
    public final double y;
}

class HexCube
{

    public HexCube(int q, int r, int s)
    {
        this.q = q;
        this.r = r;
        this.s = s;
        if (q + r + s != 0)
            throw new IllegalArgumentException("q + r + s must be 0");
    }

    public HexCube(Point p)
    {
        int q = (int) ((p.x - 300) / 37);
        int r = (int) (((p.y - 300)/ 22 - q) / 2);
        int s = -q-r;
        this.q = q;
        this.r = r;
        this.s = s;
        if (q + r + s != 0)
            throw new IllegalArgumentException("q + r + s must be 0");
    }

    public final int q;
    public final int r;
    public final int s;

    public HexCube add(HexCube b)
    {
        return new HexCube(q + b.q, r + b.r, s + b.s);
    }

    public HexCube subtract(HexCube b)
    {
        return new HexCube(q - b.q, r - b.r, s - b.s);
    }

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

    static public HexCube direction(int direction) {
        return HexCube.directions.get(direction);
    }

    public HexCube neighbour(int direction)
    {
        return add(HexCube.direction(direction));
    }

    public int length()
    {
        return (int)((Math.abs(q) + Math.abs(r) + Math.abs(s)) / 2);
    }

    public int distance(HexCube b)
    {
        return subtract(b).length();
    }

    @Override
    public String toString() {
        return "("+ q + ", " + r + ", " + s + ")";
    }

    //adjacent hexes
    public List<HexCube> getAllNeighbours() {
        List<HexCube> adjHexes = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            //adding to array adjHexes
            //"this" refers to the hexagon we call neighbour method on
            adjHexes.add(this.neighbour(i));
        }
        return adjHexes;
    }

    //equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Check if both objects are the same instance
        if (obj == null || getClass() != obj.getClass()) return false;  // Check if obj is null or not the same class

        HexCube other = (HexCube) obj;  // Cast the object to HexCube
        return this.q == other.q && this.r == other.r && this.s == other.s;  // Compare q, r, and s
    }
}



