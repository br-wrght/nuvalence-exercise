package io.nuvalence.utilities;


import io.nuvalence.vos.Point;
import io.nuvalence.vos.Rectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Title: RectangleUtilities
 * Description: Performs basic calculations and operations on io.nuvalence.pojos.Rectangle.
 *
 * @author Brian Wright <brianwright@outlook.com>
 * @created 11/10/22
 */
public class RectangleUtilities {
    private static final Logger logger = LoggerFactory.getLogger(RectangleUtilities.class);

    /**
     * Calculates the intersected area (if exists) of two rectangles.
     *
     * @param one
     * @param two
     * @return Rectangle (or null if none exists)
     */
    public static Rectangle getRectangleIntersectionArea(Rectangle one, Rectangle two) {
        logger.info("Determining if intersection exists between 2 rectangles.");

        if (one == null || two == null) return null;

        if (logger.isDebugEnabled()) {
            logger.debug(one.toString());
            logger.debug(two.toString());
        }

        if (!doRectanglesIntersect(one, two)) {
            return null;
        }

        int oneX1 = one.getBottomLeft().x;
        int oneY1 = one.getBottomRight().y;
        int twoX1 = two.getBottomLeft().x;
        int twoY1 = two.getBottomRight().y;
        int oneX2 = one.getBottomRight().x;
        int oneY2 = one.getTopRight().y;
        int twoX2 = two.getBottomRight().x;
        int twoY2 = two.getTopRight().y;

        if (oneX1 < twoX1) oneX1 = twoX1;
        if (oneY1 < twoY1) oneY1 = twoY1;
        if (oneX2 > twoX2) oneX2 = twoX2;
        if (oneY2 > twoY2) oneY2 = twoY2;

        oneX2 -= oneX1;
        oneY2 -= oneY1;

        return new Rectangle(oneX1, oneY1, oneX2, oneY2);
    }


    /**
     * Determines if two rectangles have any point of intersection.
     *
     * @param one
     * @param two
     * @return boolean
     */
    public static boolean doRectanglesIntersect(Rectangle one, Rectangle two) {
        logger.info("Determining if two rectangles intersect.");

        if (one == null || two == null) return false;

        if (logger.isDebugEnabled()) {
            logger.debug(one.toString());
            logger.debug(two.toString());
        }

        if (((one.getTopRight().y < two.getBottomRight().y) || (one.getBottomLeft().y > two.getTopRight().y)) ||
                ((one.getTopRight().x < two.getBottomLeft().x) || one.getBottomLeft().x > two.getTopRight().x)) {
            logger.info("No intersection.");
            return false;
        }
        logger.info("Intersection exists.");
        return true;
    }

    /**
     * Determines if the first rectangle param contains the target rectangle in entirety.
     *
     * @param rectangle
     * @param target
     * @return boolean
     */
    public static boolean doesRectangleContainTarget(Rectangle rectangle, Rectangle target) {
        if (rectangle == null || target == null) return false;

        return doesRectangleContainPoint(rectangle, target.getTopLeft()) &&
                doesRectangleContainPoint(rectangle, target.getTopRight()) &&
                doesRectangleContainPoint(rectangle, target.getBottomLeft()) &&
                doesRectangleContainPoint(rectangle, target.getBottomLeft());
    }

    /**
     * Determines if the rectangle contains a single point.
     *
     * @param rectangle
     * @param point
     * @return boolean
     */
    public static boolean doesRectangleContainPoint(Rectangle rectangle, Point point) {
        if (rectangle == null || point == null) return false;

        if (point.x >= rectangle.getTopLeft().x &&
                point.x <= rectangle.getTopRight().x &&
                point.y >= rectangle.getBottomLeft().y &&
                point.y <= rectangle.getTopLeft().y
        )
            return true;
        return false;
    }

    /**
     * Determines if two rectangles are adjacent
     *
     * @param one
     * @param two
     * @return boolean
     */
    public static boolean areRectanglesAdjacent(Rectangle one, Rectangle two) {
        return one.getTopLeft().x - two.getTopRight().x == 0 ||
                one.getTopRight().x - two.getTopLeft().x == 0 ||
                one.getTopLeft().y - two.getBottomLeft().y == 0 ||
                one.getBottomLeft().y - two.getTopLeft().y == 0;
    }

}