package io.nuvalence.utilities;

import io.nuvalence.pojos.Intersection;
import io.nuvalence.pojos.Point;
import io.nuvalence.pojos.Rectangle;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.css.Rect;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Title: RectangleUtilitiesTest
 * Description:
 *
 * @author Brian Wright <brianwright@outlook.com>
 * @created 11/10/22
 */
public class RectangleUtilitiesTest {
    private static final Logger logger = LoggerFactory.getLogger(RectangleUtilitiesTest.class);

    @Test
    public void testSuccessfulVerticalIntersection() {
        logger.info("Starting: testSuccessfulIntersection()");
        Rectangle one = new Rectangle(new Point[]{
                new Point(-5, 2),
                new Point(0, 2),
                new Point(-5, -2),
                new Point(0, -2)
        });

        Rectangle two = new Rectangle(new Point[]{
                new Point(-3, 1),
                new Point(3, 1),
                new Point(-3, 0),
                new Point(3, 0)
        });

        Rectangle correctResult = new Rectangle(new Point[]{
                new Point(-3, 1),
                new Point(0, 1),
                new Point(-3, 0),
                new Point(0, 0)
        });

        Rectangle intersectionResult = RectangleUtilities.getRectangleIntersectionArea(one, two);
        logger.info("Got intersection: " + intersectionResult);
        assertTrue(correctResult.equals(intersectionResult));
        logger.info("Completed: testSuccessfulVerticalIntersection()");
    }

    @Test
    public void testSuccessfulHorizontalIntersection() {
        logger.info("Starting: testSuccessfulHorizontalIntersection()");
        Rectangle one = new Rectangle(new Point[]{
                new Point(0, 3),
                new Point(6, 3),
                new Point(0, 0),
                new Point(6, 0)
        });

        Rectangle two = new Rectangle(new Point[]{
                new Point(2, 6),
                new Point(4, 6),
                new Point(2, 1),
                new Point(4, 1)
        });

        Rectangle correctResult = new Rectangle(new Point[]{
                new Point(2, 3),
                new Point(4, 1),
                new Point(4, 3),
                new Point(2, 1)
        });

        Rectangle intersectionResult = RectangleUtilities.getRectangleIntersectionArea(one, two);
        logger.info("Got intersection: " + intersectionResult);
        assertTrue(correctResult.equals(intersectionResult));
        logger.info("Completed: testSuccessfulHorizontalIntersection()");
    }

    @Test
    public void testSuccessfulDoubleHorizontalIntersection() {
        logger.info("Starting: testSuccessfulDoubleHorizontalIntersection()");
        Rectangle one = new Rectangle(new Point[]{
                new Point(0, 3),
                new Point(6, 3),
                new Point(0, 0),
                new Point(6, 0)
        });

        Rectangle two = new Rectangle(new Point[]{
                new Point(2, 6),
                new Point(4, 6),
                new Point(2, -2),
                new Point(4, -2)
        });

        Rectangle correctResult = new Rectangle(new Point[]{
                new Point(2, 3),
                new Point(4, 0),
                new Point(4, 3),
                new Point(2, 0)
        });

        Rectangle intersectionResult = RectangleUtilities.getRectangleIntersectionArea(one, two);
        logger.info("Got intersection: " + intersectionResult);
        assertTrue(correctResult.equals(intersectionResult));
        logger.info("Completed: testSuccessfulDoubleHorizontalIntersection()");
    }

    @Test
    public void testSuccessfulDoubleVerticalIntersection() {
        logger.info("Starting: testSuccessfulDoubleVerticalIntersection()");
        Rectangle one = new Rectangle(new Point[]{
                new Point(0, 3),
                new Point(6, 3),
                new Point(0, 0),
                new Point(6, 0)
        });

        Rectangle two = new Rectangle(new Point[]{
                new Point(-1, 1),
                new Point(-1, 2),
                new Point(7, 1),
                new Point(7, 2)
        });

        Rectangle correctResult = new Rectangle(new Point[]{
                new Point(0, 1),
                new Point(6, 1),
                new Point(6, 2),
                new Point(0, 2)
        });

        Rectangle intersectionResult = RectangleUtilities.getRectangleIntersectionArea(one, two);
        logger.info("Got intersection: " + intersectionResult);
        assertTrue(correctResult.equals(intersectionResult));
        logger.info("Completed: testSuccessfulDoubleVerticalIntersection()");
    }

    @Test
    public void testUnsuccessfulIntersection() {
        logger.info("Starting: testUnsuccessfulIntersection()");
        Rectangle one = new Rectangle(new Point[]{
                new Point(0, 3),
                new Point(6, 3),
                new Point(0, 0),
                new Point(6, 0)
        });

        Rectangle two = new Rectangle(new Point[]{
                new Point(19, 1),
                new Point(19, 6),
                new Point(22, 1),
                new Point(22, 6)
        });


        Rectangle intersectionResult = RectangleUtilities.getRectangleIntersectionArea(one, two);
        logger.info("Got intersection: " + intersectionResult);
        assertNull(intersectionResult);
        logger.info("Completed: testUnsuccessfulIntersection()");
    }


    @Test
    public void testSuccessfulContainment() {
        logger.info("Starting: testSuccessfulContainment()");
        Rectangle one = new Rectangle(new Point[]{
                new Point(0, 3),
                new Point(6, 3),
                new Point(0, 0),
                new Point(6, 0)
        });

        Rectangle two = new Rectangle(new Point[]{
                new Point(1, 1),
                new Point(1, 2),
                new Point(4, 2),
                new Point(4, 1)
        });


        boolean result = RectangleUtilities.doesRectangleContainTarget(one, two);
        logger.info("Containment Result: " + result);
        assertTrue(result);
        logger.info("Completed: testSuccessfulContainment()");
    }

    @Test
    public void testUnSuccessfulContainment() {
        logger.info("Starting: testUnSuccessfulContainment()");
        Rectangle one = new Rectangle(new Point[]{
                new Point(0, 3),
                new Point(6, 3),
                new Point(0, 0),
                new Point(6, 0)
        });

        Rectangle two = new Rectangle(new Point[]{
                new Point(1, 1),
                new Point(1, 2),
                new Point(4, 2),
                new Point(4, 1)
        });


        boolean result = RectangleUtilities.doesRectangleContainTarget(two, one);
        logger.info("Containment Result: " + result);
        assertFalse(result);
        logger.info("Completed: testUnSuccessfulContainment()");
    }

    @Test
    public void testSuccessfulHorizontalAdjacency() {
        logger.info("Starting: testSuccessfulHorizontalAdjacency()");
        Rectangle one = new Rectangle(new Point[]{
                new Point(0, 3),
                new Point(6, 3),
                new Point(0, 0),
                new Point(6, 0)
        });

        Rectangle two = new Rectangle(new Point[]{
                new Point(6, 2),
                new Point(6, -2),
                new Point(10, 2),
                new Point(10, -2)
        });

        boolean result = RectangleUtilities.areRectanglesAdjacent(one, two);
        logger.info("Adjacency Result: " + result);
        assertTrue(result);
        logger.info("Completed: testSuccessfulHorizontalAdjacency()");
    }

    @Test
    public void testSuccessfulVerticalAdjacency() {
        logger.info("Starting: testSuccessfulVerticalAdjacency()");
        Rectangle one = new Rectangle(new Point[]{
                new Point(0, 3),
                new Point(6, 3),
                new Point(0, 0),
                new Point(6, 0)
        });

        Rectangle two = new Rectangle(new Point[]{
                new Point(2, 3),
                new Point(2, 6),
                new Point(5, 6),
                new Point(5, 3)
        });

        boolean result = RectangleUtilities.areRectanglesAdjacent(two, one);
        logger.info("Adjacency Result: " + result);
        assertTrue(result);
        logger.info("Completed: testSuccessfulVerticalAdjacency()");
    }

    @Test
    public void testUnSuccessfulAdjacency() {
        logger.info("Starting: testUnSuccessfulAdjacency()");
        Rectangle one = new Rectangle(new Point[]{
                new Point(0, 3),
                new Point(6, 3),
                new Point(0, 0),
                new Point(6, 0)
        });

        Rectangle two = new Rectangle(new Point[]{
                new Point(10, 10),
                new Point(10, 16),
                new Point(9, 10),
                new Point(9, 16)
        });

        boolean result = RectangleUtilities.areRectanglesAdjacent(two, one);
        logger.info("Adjacency Result: " + result);
        assertFalse(result);
        logger.info("Completed: testUnSuccessfulAdjacency()");
    }
}
