package containerWithMostWater;

public class ContainerTest {
	public static void main(String[] args) {
		//ContainerWithMostWater container = new ContainerWithMostWater();
		
		int[] height = {5, 2, 12, 1, 5, 3, 4, 11, 9, 4};
		
		int result = ContainerWithMostWater.maxArea(height);
		
		System.out.printf("%nThe max area found is %s.", result);

	}

}
