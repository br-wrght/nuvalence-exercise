package io.nuvalence.pojos;

/**
 * Title: Rectangle
 * Description: A plain old java class that represents a rectangle on a 2 dimensional plane.
 *
 * @author Brian Wright <brianwright@outlook.com>
 * @created 11/10/22
 */
public class Rectangle {
    private Point bottomLeft;
    private Point bottomRight;
    private Point topLeft;
    private Point topRight;

    public Rectangle() {
    }

    public Rectangle(Point[] points) {
        constructRectangle(points);
    }

    private void constructRectangle(Point[] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Point point : points) {
            if (point.x < minX) {
                minX = point.x;
            } else if (point.x > maxX) {
                maxX = point.x;
            } else if (point.y < minY) {
                minY = point.y;
            } else if (point.y > maxY) {
                maxY = point.y;
            }
        }

        for (Point point : points) {
            if (point.x == minX) {
                // Left
                if (point.y == minY) {
                    // Bottom
                    setBottomLeft(point);
                } else {
                    // Top
                    setTopLeft(point);
                }
            } else if (point.x == maxX) {
                // Right
                if (point.y == minY) {
                    // Bottom
                    setBottomRight(point);
                } else {
                    setTopRight(point);
                }
            }
        }

        if (getTopRight() == null || getTopLeft() == null || getBottomRight() == null || getBottomLeft() == null) {
            // Set all to zero
            throw new RuntimeException("Incorrect rectangle coordinates");
        }
    }

    public Rectangle(int x, int y, int width, int height) {
        constructRectangle(new Point[]{
                new Point(x, y + height),
                new Point(x, y),
                new Point(x + width, y + height),
                new Point(x + width, y)
        });
    }

    public int getWidth() {
        return topRight.x - topLeft.x;
    }

    public int getHeight() {
        return topLeft.y - bottomLeft.y;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    @Override
    public String toString() {
        StringBuilder o = new StringBuilder();
        if (topLeft != null) {
            o.append("topLeft: [" + topLeft.x + ", " + topLeft.y + "]");
        } else {
            o.append("topLeft: [null]\n");
        }
        if (topRight != null) {
            o.append(" topRight: [" + topRight.x + ", " + topRight.y + "]");
        } else {
            o.append(" topRight: [null]\n");
        }
        if (bottomLeft != null) {
            o.append(" bottomLeft: [" + bottomLeft.x + ", " + bottomLeft.y + "]");
        } else {
            o.append(" bottomLeft: [null]\n");
        }
        if (topLeft != null) {
            o.append(" bottomRight: [" + bottomRight.x + ", " + bottomRight.y + "]");
        } else {
            o.append(" bottomRight: [null]");
        }
        if (topLeft != null && bottomLeft != null) {
            o.append(" height: " + getHeight());
        } else {
            o.append(" height: unknown");
        }
        if (bottomLeft != null && bottomRight != null) {
            o.append(" width: " + getWidth());
        } else {
            o.append(" width: unknown");
        }
        return o.toString();
    }

    @Override
    public boolean equals(Object two) {
        if (this == two) {
            return true;
        }
        if (two == null || getClass() != two.getClass()) {
            return false;
        }
        return toString().equals(two.toString());
    }
}
