package floodFill;
/**
Input:
    screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
                   {1, 1, 1, 1, 1, 1, 0, 0},
                   {1, 0, 0, 1, 1, 0, 1, 1},
                   {1, 2, 2, 2, 2, 0, 1, 0},
                   {1, 1, 1, 2, 2, 0, 1, 0},
                   {1, 1, 1, 2, 2, 2, 2, 0},
                   {1, 1, 1, 1, 1, 2, 1, 1},
                   {1, 1, 1, 1, 1, 2, 2, 1},
                   };
 x = 4, y = 4, newColor = 3
The values in the given 2D screen indicate colors of the pixels.
x and y are coordinates of the brush, newColor is the color that
should replace the previous color on screen[x][y] and all surrounding
pixels with same color.

Output:
Screen should be changed to following.
    screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
                   {1, 1, 1, 1, 1, 1, 0, 0},
                   {1, 0, 0, 1, 1, 0, 1, 1},
                   {1, 3, 3, 3, 3, 0, 1, 0},
                   {1, 1, 1, 3, 3, 0, 1, 0},
                   {1, 1, 1, 3, 3, 3, 3, 0},
                   {1, 1, 1, 1, 1, 3, 1, 1},
                   {1, 1, 1, 1, 1, 3, 3, 1},
                   };
                   */
public class FloodFill {
	// define dimentinos of paint screen
	final static int M = 8;
	final static int N = 8;
	
	/**
	 * 
	 * @param screen 2D screen
	 * @param x -> x coordinate
	 * @param y -> y coordinate
	 * @param prevC -> old color
	 * @param newC -> new color
	 */
	public static void floodFill(int[][] screen, int x, int y, int prevC, int newC) {
		if(screenCheck(screen) == false)
			return;
		
		// base case
		if(x < 0 || x >= M || y < 0 || y >= N)
			return;
		if(screen[x][y] != prevC) // not a pixel to fill
			return;
		
		// replace new color at (x, y)
		screen[x][y] = newC;
		
		// recur for north, east, south, west
		floodFill(screen, x + 1, y, prevC, newC);
		floodFill(screen, x - 1, y, prevC, newC);
		floodFill(screen, x, y + 1, prevC, newC);
		floodFill(screen, x, y - 1, prevC, newC);
	}
	
	public static void printScreen(int[][] screen) {
		if (screenCheck(screen) == false)
			return;
		
		for(int i = 0; i < screen.length; i++) {
			System.out.printf("%s%n", printRow(screen[i]));
		}
		
	}
	
	private static String printRow(int[] row) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < row.length; i++)
			sb.append(String.format("%-4s", row[i]));
		
		return sb.toString();
	}
	
	
	protected static boolean screenCheck(int[][] screen) {
		if(screen.length != M) {
			System.out.println("Screen resolution not compatible!!");
			return false;
		}
		
		for(int i = 0; i < M; i++) {
			if(screen[i].length != N) {
				System.out.println("Screen resolution not compatible!!");
				return false;
			}
		}
		
		return true;
	}
}
