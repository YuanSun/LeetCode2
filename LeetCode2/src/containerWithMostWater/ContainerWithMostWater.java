package containerWithMostWater;

import java.util.ArrayList;
import java.util.List;

public class ContainerWithMostWater {
	public static int maxArea (int[] height) {
		int max = 0; // store max area
		int L = height.length;
		int lo = 0, hi = height.length - 1; // two pointers
		List<Integer> results = new ArrayList<>();
		
		// if the array only has two height
		if(L == 2)
			return L * (height[lo] < height[hi] ? height[lo] : height[hi]);
		
		while(lo < hi) {
			int loMax = height[lo], hiMax = height[hi];
			int candidate = (hi - lo) * (loMax < hiMax ? loMax : hiMax);
			
			max = max > candidate ? max : candidate; // update max area
			results.add(max);
			
			// if lo is the shorter side, move the lo forward to find max area
			if (height[lo] < height[hi])
				while(lo < hi && height[lo] <= loMax) ++lo;
			// if hi is the shorter side, move the hi backward to find max area
			else
				while(hi > lo && height[hi] <= hiMax) --hi;
		}
		//print all tested area
		System.out.printf("Tested area: ");
		results.stream().forEach(result -> System.out.printf("%d ",result));
	
		return max;
	}
}
