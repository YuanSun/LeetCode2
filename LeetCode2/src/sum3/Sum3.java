package sum3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		
		// sort nums
		Arrays.sort(nums);
		System.out.print("nums is {");
		for (int i : nums) 
			System.out.printf("%d ", i);
		System.out.println("}");
		
		// compute in O(n)
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
				
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				if (nums[j] + nums[k] + nums[i] == 0) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					System.out.println("i is " + i);
					// eliminate duplicate
					while (j < k && nums[j] == nums[j+1]) j++;
					while (j < k && nums[k] == nums[k-1]) k--;
					j++; k--;
				}
				
				// Shift two pointers
				while (j < k && (nums[j] + nums[k] + nums[i] < 0)) j++;
				while (j < k && (nums[j] + nums[k] + nums[i] > 0)) k--;
			}
		}
		
		return result;
	}
}
