
/**
 * Navigate to the RURacing directory and compile the files using the following:
 * Compilation: javac -d bin *.java
 * Execution: java -cp bin Driver
 * 
 * Welcome to RURacing! You're familiar with runtimes and big O notation,
 * right? Well we're bringing that to the racetrack! We're going to create a
 * raceway that will have racers moving through it at different runtimes. We
 * will start with a simple raceway and move on to more complex ones. Each
 * racer will move a certain distance through the raceway based on their
 * runtime (i.e., O(1), O(n), ...). Do not let racers run through the grass!
 * 
 * Ready? Set? Go!
 * 
 * @author Elian D. Deogracia-Brito
 * @author Tiara Clyde
 * @author Tanvi Yamarthy
 */
public class RURacing {
    private static final char GRASS = '.';
    private static final char ROAD = '#';

    /**
     * DO NOT UPDATE OR REMOVE THIS FUNCTION  
     * Read the given coordinates from the track text files by using StdIn
     * The first integer is the number of coordinates. Each coordinate is
     * separated by a newline. Each line contains two integers separated by a
     * space. The first integer is the x-coordinate and the second integer is
     * the y-coordinate. The coordinates are stored in a one-dimensional array
     * in the following manner: {x1, y1, x2, y2, ..., xn, yn}. These 
     * coordinates represent the corners of the raceway and will be used to
     * construct it.
     * 
     * @param filename Name of the file to read the coordinates from.
     */
    public static int[] readTrackFile(String filename) {
        StdIn.setFile(filename);
        int size = StdIn.readInt() * 2;
        StdIn.readLine();
        int[] points = new int[size];
        for (int i = 0; i < size; i += 2) {
            points[i] = StdIn.readInt();
            points[i + 1] = StdIn.readInt();
            StdIn.readLine();
        }

        return points;
    }

    /**
     * DO NOT UPDATE OR REMOVE THIS FUNCTION  
     * Alright, we need to create a raceway. 
     * 
     * Let's use a 2D character array to represent a map that will contain the
     * raceway.
     * 
     * The 2D array will be interpreted in the following manner: points on the
     * array will be represented by the x and y coordinates. The x-coordinate
     * will be the column and the y-coordinate will be the row. We will store
     * points in an (x, y) format. The top-left corner of the map will be
     * (0, 0). The bottom-right corner will be (size - 1, size - 1).
     * 
     * All variables that represent the map will be of type char and have been
     * provided as constants for you above. We'll use the '#' character
     * (char ROAD) to represent the road and the '.' (char GRASS) character
     * to represent the grass.
     * 
     * Draw a road between two given points on a given map. The road should be
     * a straight line between the two points (horizontal or vertical only). 
     * The road must be drawn using the ROAD constant. This method will exclude 
     * diagonal lines.
     * 
     * NOTE: If you require a refresher on 2D arrays, check out the following:
     * https://introcs.cs.rutgers.edu/lectures/
     * https://introcs.cs.princp\;>
     * \eton.edu/java/14array/.
     * 
     * @param x1  Specifies x-coordinate for the first point.
     * @param y1  Specifies y-coordinate for the first point.
     * @param x2  Specifies x-coordinate for the second point.
     * @param y2  Specifies y-coordinate for the second point.
     * @param map 2D character array with the road drawn between the two points.
     * @return
     */
    public static void drawRoad(int x1, int y1, int x2, int y2, char[][] map) {
        // We can assume that the road will be a straight line so we
        // don't have to do any complicated checks.
        int strokeEnd = Math.max(y1, y2);
        for (int pen = Math.min(y1, y2); pen <= strokeEnd; pen++) {
            map[pen][x1] = ROAD; // Along the y-axis
        }
        strokeEnd = Math.max(x1, x2);
        for (int pen = Math.min(x1, x2); pen <= strokeEnd; pen++) {
            map[y1][pen] = ROAD; // Along the x-axis
        }
    }

    /**
     * DO NOT UPDATE OR REMOVE THIS FUNCTION  
     * Let's create a raceway by connecting a series of points. Before we
     * begin we'll need an area to place the raceway on. We'll use a 2D
     * character array to represent the map. The size of the map will be
     * passed in as an argument and will be used for both the width and height.
     * 
     * The points will be given as a list of xy-coordinates stored within a
     * one-dimensional integer array (e.g., {1, 2, 1, 4} would represent two
     * points: (1, 2) & (1, 4)). A road will be created by connecting two
     * consecutive points together using the drawRoad method. Once two points
     * are connected, we will make the next point in the array the new second
     * point. The previous second point will become the new first point, and
     * we will connect the two points once again to form a road. This will
     * continue until we reach the last point in the array.
     * 
     * The last point to connect all roads from the series together is already
     * provided in the array.
     * 
     * @param size      Length and width of 2D character array, not 
     *                  the raceway.
     * @param points    Array of xy-coordinates.
     * @return          New 2D character array with embedded raceway.
     */
    public static char[][] createRaceway(int[] points) {
        // Get size by largest integer
        int size = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i] >= size) {
                size = points[i] + 1;
            }
        }

        char[][] map = new char[size][size];
        int windowLeft = 0;
        int windowRight = 0;
        while (windowRight < points.length) {
            int windowSize = windowRight - windowLeft + 1;
            if (windowSize < 4) {
                windowRight++;
                continue;
            }

            assert windowSize == 4;
            drawRoad(points[windowLeft], points[windowLeft + 1], 
                points[windowLeft + 2], points[windowRight], map);
            windowLeft += 2;
            windowRight++;
        }

        return map;
    }

    /**
     * DO NOT UPDATE OR REMOVE THIS FUNCTION  
     * Great! The raceway has been created. Now we need to print it out to see
     * how it looks like. We'll print the raceway using the following rules:
     * 
     * - Each character will have a space between them to make the final
     * product easier to read.
     * - If a character is a 0, it will be replaced with a grass character when
     * printed.
     * - If a character is not a 0, it will be printed as is.
     * 
     * @param map 2D character array to print.
     * @return
     */
    public static void printMap(char[][] map) {
        for (char[] row : map) {
            for (char character : row) {
                System.out.print((character == 0 ? GRASS : character) + " ");
            }
            System.out.println();
        }
    }

    /**
     * DO NOT UPDATE OR REMOVE THIS FUNCTION  
     * Now that we have a raceway, we need a method that can move a racer
     * through it. This method will move a racer a certain distance through the
     * raceway. The racer will start at the given position and follow a
     * clockwise path (e.g., Right -> Down -> Left -> Up). The racer should
     * avoid stepping on the grass as that will count as a crash.
     * 
     * The trick here is to somehow keep track of the racer's position to avoid
     * getting stuck in a loop. We can do this by keeping track of the racer's
     * direction. Use the following characters to represent a given direction:
     * '>', 'v', '<', '^'. Each time the racer moves, we will update the map
     * with the new direction which also represents the racer's current 
     * position. 
     * 
     * We will also update the previous position with a road character if the
     * racer has moved. This will keep the raceway intact, and make the 
     * racer's current position clear.
     * 
     * @param x         Specifies x-coordinate for the racer's current
     *                  position.
     * @param y         Specifies y-coordinate for the racer's current
     *                  position.
     * @param distance  Specifies the distance to move within a given raceway.
     * @param map       2D character array that contains the raceway.
     * @return          The new xy-coordinates for based on the previous
     *                  position.
     */
    public static int[] moveRacer(int x, int y, int distance, char[][] map) {
        for (int i = 0; i < distance; i++) {
            int py = y, px = x;
            char direction = map[py][px];
            if (x + 1 < map[y].length && map[y][x + 1] == ROAD
                && direction != '<') {
                map[y][++x] = '>';
            } else if (y + 1 < map.length && map[y + 1][x] == ROAD
                && direction != '^') {
                map[++y][x] = 'v';
            } else if (x - 1 >= 0 && map[y][x - 1] == ROAD) {
                map[y][--x] = '<';
            } else if (y - 1 >= 0 && map[y - 1][x] == ROAD) {
                map[--y][x] = '^';
            } else {
                break;
            }

            map[py][px] = ROAD;
        }
        return new int[] {x, y};
    }

    /**
     * This is the first racer. The racer will start at the top-left corner of
     * the raceway and will move until it reaches the end of the raceway 
     * (i.e., the full length of the raceway). Since this racer moves in O(1) 
     * time, it will reach the end of the raceway in one step. Do not
     * print the racer's initial position. For every racer print the
     * consecutive positions they move to.
     * 
     * @param map 2D character array that contains the raceway.
     * @return
     */
    public static void racer1(char[][] map) {
        moveRacer(0,0,16,map);
	// WRITE YOUR CODE HERE
    }

    /**
     * This racer will move through the raceway in O(log n) time. The racer will
     * start at the top-left corner at each timestep, doubling the distance it
     * moves in the previous timestep. The racer will stop once it reaches the
     * end of the raceway. However, the racer may not go past the end of the
     * raceway. The last position of the racer must only be printed once.
     * 
     * @param map 2D character array that contains the raceway.
     * @return
     */
    public static void racer2(char[][] map) {
	// WRITE YOUR CODE HERE
    }

    /**
     * This racer will move through the raceway in O(n) time (constant speed).
     * The racer will start at the top-left corner and each time step move
     * at a distance of 1. Once the racer reaches one lap or the end of the
     * raceway, the racer will stop. The last position of the racer must 
     * only be printed once.
     * 
     * @param map 2D character array that contains the raceway.
     * @return
     */
    public static void racer3(char[][] map) {
	// WRITE YOUR CODE HERE
    }

    /**
     * This racer will move through the raceway in O(n^2) time. The racer will
     * start at the top-left corner and stay at each consecutive position for n
     * steps. At every step the racer must print its position no matter if its 
     * still at the same position.
     * 
     * @param map 2D character array that contains the raceway.
     * @return
     */
    public static void racer4(char[][] map) { // starting X and starting Y
	// WRITE YOUR CODE HERE

    }
}
