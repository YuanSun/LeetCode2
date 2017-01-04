package letterCombinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<String> letterCombination(String digits) {
		final String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> result = new ArrayList<>();
		backtrack(result, "", keys, digits, 0);
		
		return result;
	}

	private static void backtrack(List<String> result, String s, String[] keys, String digits, int start) {
		if (digits.isEmpty())
			return;
		if (s.length() == digits.length())
			result.add(s);
		else {
			int index = digits.charAt(start) - '0';
			//System.out.println("index is " + index);
			for (int j = 0; j < keys[index].length(); j++) {
				s = s + keys[index].charAt(j);
				backtrack(result, s, keys, digits, start + 1);
				s = s.substring(0, s.length() - 1);
			}
		}
	}
}
