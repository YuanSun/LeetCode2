package addOne;

public class AddOneTest {

	public static void main(String[] args) {
		int[] test = {1, 9, 0, 9};
		AddOne theNumberToAdd = new AddOne(test);
		int[] result = theNumberToAdd.Result();
		
		System.out.print("Result is " );
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i]);
	}

}
