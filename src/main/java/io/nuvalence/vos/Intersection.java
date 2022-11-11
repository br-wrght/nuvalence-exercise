package io.nuvalence.vos;

/**
 * Title: Intersection
 * Description: A plain old java class that represents line on a 2 dimensional plane.
 *
 * @author Brian Wright <brianwright@outlook.com>
 * @created 11/10/22
 */
public class Intersection {
    private Point coordinate1;
    private Point coordinate2;

    public Intersection() {
    }

    public Intersection(Point coordinate1, Point coordinate2) {
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
    }

    public Point getCoordinate1() {
        return coordinate1;
    }

    public void setCoordinate1(Point coordinate1) {
        this.coordinate1 = coordinate1;
    }

    public Point getCoordinate2() {
        return coordinate2;
    }

    public void setCoordinate2(Point coordinate2) {
        this.coordinate2 = coordinate2;
    }

    @Override
    public String toString() {
        StringBuilder o = new StringBuilder();
        if (coordinate1 != null) {
            o.append("[" + coordinate1.x + ", " + coordinate1.y + "]");
        } else {
            o.append("[null]");
        }
        if (coordinate2 != null) {
            o.append("[" + coordinate2.x + ", " + coordinate2.y + "]");
        } else {
            o.append("[null]");
        }
        return o.toString();
    }
}
