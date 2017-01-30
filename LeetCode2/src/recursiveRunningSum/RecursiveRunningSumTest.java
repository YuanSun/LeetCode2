package recursiveRunningSum;

import java.util.ArrayList;
import java.util.List;

public class RecursiveRunningSumTest {

	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		for (int i = 0; i < 10; i++) 
			numList.add(i);
		System.out.println("Summation of numList is " + RecursiveRunningSum.Sum(numList));
	}

}
