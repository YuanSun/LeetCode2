package recursiveRunningSum;

import java.util.ArrayList;
import java.util.List;

public class RecursiveRunningSum {
	private static int index = 0;
	public static Integer Sum(List<Integer> numList) {
		if(index == numList.size() - 1)
			return numList.get(index);
		else {
			List<Integer> subList = new ArrayList<>();
			subList = numList.subList(++index, numList.size());
			return numList.get(index-1) + Sum(subList);
		}
		
	}
}
