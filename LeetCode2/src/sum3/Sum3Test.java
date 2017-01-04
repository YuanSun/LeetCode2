package sum3;

import java.util.ArrayList;
import java.util.List;

public class Sum3Test {
	public static void main(String[] args) {
		int[] nums = {-4, -4, 4, -1, -1, 0, 1, 2, -1, -4, 8, 1, 2, 5};
		
		List<List<Integer>> result = new ArrayList<>();
		result = Sum3.threeSum(nums);
		
		System.out.printf(result.toString());
	}

}
