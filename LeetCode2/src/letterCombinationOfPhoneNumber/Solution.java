package letterCombinationOfPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<String> letterCombinations(String digits) {
		String[] keys = {"", "", "abc", "def", "ghi", "jkl", 
				"mno", "pqrs", "tuv", "wxyz"};
		List<String> result = new ArrayList<String>();
		backtrack(result, "", keys, digits, 0);
		return result;
	}
	
	private static void backtrack(
			List<String> result, 
			String s, 
			String[] keys, 
			String digits, 
			int start) {
		if(digits.isEmpty())
			return;
		if(s.length() == digits.length())
			result.add(s);
		else {
			for (int i = start; i < digits.length(); i++) {
				int index = digits.charAt(i) - '0';
				for (int j = 0; j < keys[index].length(); j++) {
					s = s + keys[index].charAt(j);
					backtrack(result, s, keys, digits, i+1);
					s = s.substring(0, s.length() - 1);
				}
			}
		}
	}
}
