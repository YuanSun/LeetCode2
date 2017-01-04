package letterCombinationOfPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class LetterCombTest {
	public static void main(String[] args) {
		String digits = "23";
		
		List<String> result = new ArrayList<String>();
		result = Solution.letterCombinations(digits);
		
		System.out.printf(result.toString());

	}
}
