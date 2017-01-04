package sum2;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public static ArrayList<Integer> sum2 (int[] nums, int target) {
		Arrays.sort(nums);
		int lo = 0, hi = nums.length - 1;
		
		while (lo < hi) {
			if (nums[lo] + nums[hi] == target)
				break;
			if (nums[lo] + nums[hi] < target)
				lo++;
			else if(nums[lo] + nums[hi] > target)
				hi--;
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(lo);
		ans.add(hi);
		return (ans);
		
	}
}
