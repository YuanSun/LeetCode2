package floodFill;

public class floodFillTest {
	public static void main(String... args) {
		int[][] screen = {
				{1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 0, 0},
				{1, 0, 0, 1, 1, 0, 1, 1},
				{1, 2, 2, 2, 2, 0, 1, 0},
				{1, 1, 1, 2, 2, 0, 1, 0},
				{1, 1, 1, 2, 2, 2, 2, 0},
				{1, 1, 1, 1, 1, 2, 1, 1},
				{1, 1, 1, 1, 1, 2, 2, 1}
				};
		
		int x = 4, y = 4, newColor = 80;
		
		// print original screen
		FloodFill.printScreen(screen);
		
		int prevC = screen[x][y];
		// change color
		FloodFill.floodFill(screen, x, y, prevC, newColor);
		
		// print again
		System.out.printf("%n%nNew Screen%n");
		FloodFill.printScreen(screen);
		
		int i = 5, j = 3;
		System.out.println("\nscreen[" + i + "][" + j + "] = " + screen[i][j]);
	}
}
