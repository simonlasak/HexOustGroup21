package UIPackage;
/*-----------------------------------------*
 *
 * The implementation below is adapted from:
 * https://www.redblobgames.com/grids/hexagons/implementation.html
 *
 *------------------------------------------*/
import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

public class HexGrid extends JPanel
{
    private ArrayList<ArrayList<Point>> grid;

    public HexGrid(ArrayList<ArrayList<Point>> hexagons) {
        this.grid = hexagons;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);

        for (ArrayList<Point> hexagon : grid) {
            for (Point p : hexagon) {
                int x = (int) Math.round(p.x);
                int y = (int) Math.round(p.y);
                g.fillOval(x - 5, y - 5, 10, 10);
            }
        }

        for (ArrayList<Point> hexagon : grid) {
            int p1xi, p1yi, p2xi, p2yi;
            Point p1 = hexagon.get(0), p2;
            for (int i = 1; i < hexagon.size(); i++)
            {
                p2 = hexagon.get(i);
                p1xi = (int) Math.round(p1.x);
                p1yi = (int) Math.round(p1.y);
                p2xi = (int) Math.round(p2.x);
                p2yi = (int) Math.round(p2.y);
                g.drawLine(p1xi, p1yi, p2xi, p2yi);
                p1 = p2;
            }

            p2 = hexagon.get(0);
            p1xi = (int) Math.round(p1.x);
            p1yi = (int) Math.round(p1.y);
            p2xi = (int) Math.round(p2.x);
            p2yi = (int) Math.round(p2.y);
            g.drawLine(p1xi, p1yi, p2xi, p2yi);
        }
    }

    static public void main(String[] args)
    {
        if (args.length != 3)
        {
            System.err.println("java HexGrid <size> <originx> <originy>");
            System.exit(1);
        }

        double size = 0.0, originx = 0.0, originy = 0.0;
        try {
            size = Double.parseDouble(args[0]);
            originx = Double.parseDouble(args[1]);
            originy = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("Problems parsing double arguments.");
            System.exit(1);
        }

        Layout flat = new Layout(Layout.flat,
                new Point(size, size),
                new Point(originx, originy));

        int baseN = 6;
        ArrayList<ArrayList<Point>> grid = new ArrayList<>();
        for (int q = -baseN; q <= baseN; q++) {
            for (int r = -baseN; r <= baseN; r++) {
                for (int s = -baseN; s <= baseN; s++) {
                    if ((q + r + s) == 0) {
                        HexCube h = new HexCube(q, r, s);
                        ArrayList<Point> corners = flat.polygonCorners(h);
                        grid.add(corners);
                    }
                }
            }
        }

        JFrame frame = new JFrame("HexGrid");
        HexGrid panel = new HexGrid(grid);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

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

    static public ArrayList<HexCube> directions = new ArrayList<HexCube>(){{add(new HexCube(1, 0, -1)); add(new HexCube(1, -1, 0)); add(new HexCube(0, -1, 1)); add(new HexCube(-1, 0, 1)); add(new HexCube(-1, 1, 0)); add(new HexCube(0, 1, -1));}};

    static public HexCube direction(int direction)
    {
        return HexCube.directions.get(direction);
    }

    public HexCube neighbor(int direction)
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
}

class FractionalHexCube
{
    public FractionalHexCube(double q, double r, double s)
    {
        this.q = q;
        this.r = r;
        this.s = s;
        if (Math.round(q + r + s) != 0)
            throw new IllegalArgumentException("q + r + s must be 0");
    }

    public final double q;
    public final double r;
    public final double s;

    public HexCube hexRound()
    {
        int qi = (int)(Math.round(q));
        int ri = (int)(Math.round(r));
        int si = (int)(Math.round(s));
        double q_diff = Math.abs(qi - q);
        double r_diff = Math.abs(ri - r);
        double s_diff = Math.abs(si - s);
        if (q_diff > r_diff && q_diff > s_diff)
        {
            qi = -ri - si;
        }
        else
        if (r_diff > s_diff)
        {
            ri = -qi - si;
        }
        else
        {
            si = -qi - ri;
        }
        System.out.println("Hexagon placed at: (q: " + qi + ", r: " + ri + ", s: " + si + ")");

        return new HexCube(qi, ri, si);
    }
}

class Orientation
{
    public Orientation(double f0, double f1, double f2, double f3,
                       double b0, double b1, double b2, double b3,
                       double start_angle)
    {
        this.f0 = f0;
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.b0 = b0;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.start_angle = start_angle;
    }
    public final double f0;
    public final double f1;
    public final double f2;
    public final double f3;
    public final double b0;
    public final double b1;
    public final double b2;
    public final double b3;
    public final double start_angle;
}

class Layout
{
    public Layout(Orientation orientation, Point size, Point origin)
    {
        this.orientation = orientation;
        this.size = size;
        this.origin = origin;
    }

    public final Orientation orientation;
    public final Point size;
    public final Point origin;

    static public Orientation flat = new Orientation(3.0 / 2.0, 0.0, Math.sqrt(3.0) / 2.0, Math.sqrt(3.0), 2.0 / 3.0,
            0.0, -1.0 / 3.0, Math.sqrt(3.0) / 3.0, 0.0);

    public Point hexToPixel(HexCube h)
    {
        Orientation M = orientation;
        double x = (M.f0 * h.q + M.f1 * h.r) * size.x;
        double y = (M.f2 * h.q + M.f3 * h.r) * size.y;
        return new Point(x + origin.x, y + origin.y);
    }

    public FractionalHexCube pixelToHex(Point p)
    {
        Orientation M = orientation;
        Point pt = new Point((p.x - origin.x) / size.x, (p.y - origin.y) / size.y);
        double q = M.b0 * pt.x + M.b1 * pt.y;
        double r = M.b2 * pt.x + M.b3 * pt.y;
        // s is just -q -r because there's redundancy
        return new FractionalHexCube(q, r, -q - r);
    }

    public Point hexCornerOffset(int corner)
    {
        Orientation M = orientation;
        double angle = 2.0 * Math.PI * (M.start_angle - corner) / 6.0;
        return new Point(size.x * Math.cos(angle), size.y * Math.sin(angle));
    }


    public ArrayList<Point> polygonCorners(HexCube h)
    {
        ArrayList<Point> corners = new ArrayList<Point>(){{}};
        Point center = hexToPixel(h);
        for (int i = 0; i < 6; i++)
        {
            Point offset = hexCornerOffset(i);
            corners.add(new Point(center.x + offset.x, center.y + offset.y));
        }
        return corners;
    }
}