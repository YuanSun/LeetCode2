package floodFill;

import java.util.ArrayList;
import java.util.Stack;

/**
 * resolution of the screen is depend on the FloodFill
 * @author sunyuan
 *
 */
public class FloodFillDfs {
	public static void floodFill(int[][] screen, int x, int y, int prevC, int newC) {
		if(FloodFill.screenCheck(screen) == false)
			return;
		
		dfs(screen, x, y, prevC, newC);
	}

	private static void dfs(int[][] screen, int x, int y, int prevC, int newC) {
		Stack<ArrayList<Integer>> stack = new Stack<>();
		
		ArrayList<Integer> pixel = new ArrayList<>(2);
		pixel.add(0, x);
		pixel.add(1, y);
		screen[pixel.get(0)][pixel.get(1)] = newC; // change color for current pixel
		stack.push(pixel);
		
		while(!stack.isEmpty()) {
			ArrayList<Integer> pixel2Test = stack.peek();
			ArrayList<Integer> adjPixel = getAdjPixel(pixel2Test);
			if(screen[adjPixel.get(0)][adjPixel.get(1)] != prevC || adjPixel.get(0) == -1) // not pixel to fill
				stack.pop();
			else {
				screen[adjPixel.get(0)][adjPixel.get(1)] = newC;
				stack.push(adjPixel);
			}
		}// end while
	}

	private static ArrayList<Integer> getAdjPixel(ArrayList<Integer> pixel2Test) {
		// cannot to figure out how to find 4 way adj pixel
		return new ArrayList<>(2);
	}
}
