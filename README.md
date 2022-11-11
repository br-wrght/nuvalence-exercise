# Rectangle Algorithms for Nuvalence Interview
This project is a simple Gradle-based Java project that implements certain rectangle algorithms in order to demonstrate good programming practices and capabilities as part of my Nuvalence technical screen.


## Algorithms Implemented
Within the RectanglesUtilities utility class, there are the following algorithms implemented:

- **Rectangle Adjacency**
    - Rectangles are considered adjacent if they share at lease one portion of one side.
  ![Image depicting adjacency in rectangles](https://raw.githubusercontent.com/br-wrght/nuvalence-exercise/master/docs/images/adjacency.png)
- **Rectangle Containment**
    - This algorithm will determine if one rectangle is wholly contained within another rectangle.
  ![Image depicting containment in rectangles](https://raw.githubusercontent.com/br-wrght/nuvalence-exercise/master/docs/images/containment.png)
- **Rectangle Intersection**
    - Rectangles intersect when one or more intersecting lines occur.
  ![Image depicting intersections in rectangles](https://raw.githubusercontent.com/br-wrght/nuvalence-exercise/master/docs/images/intersection.png)

## Building the Project
- macOS:
  - ``./gradlew build``
- Windows:
  - ``./gradlew.bat build`` 

## Testing the Algorithms
- macOS:
  - ``./gradlew test -i``
- Windows:
  - ``./gradlew.bat test -i`` 

## Test Cases
The unit test class ``RectangleUtilitiesTest`` tests the following test cases to certify correctness of the ``RectangleUtilities`` class:

- **Intersections**
  - Vertical
  - Horizontal
  - Double Vertical
  - Double Horizontal
  - None
- **Containment**
  - Successful
  - None
- **Adjacency**
  - Vertical
  - Horizontal
  - None

The unit test results were generated and can be <a href="https://htmlpreview.github.io/?https://github.com/br-wrght/nuvalence-exercise/blob/master/docs/unit-test-report/index.html" target="_blank">viewed here</a>. 
