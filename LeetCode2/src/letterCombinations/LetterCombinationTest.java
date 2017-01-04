package letterCombinations;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationTest {

	public static void main(String[] args) {
		String digits = "39";
		
		List<String> result = new ArrayList<>();
		result = Solution.letterCombination(digits);
		System.out.println(result.toString());
	}

}
