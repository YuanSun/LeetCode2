package addOne;

public class AddOneTest {

	public static void main(String[] args) {
		int[] test = {};
		AddOne theNumberToAdd = new AddOne(test);
		int[] result1 = theNumberToAdd.Result();
		int[] result2 = AddOne.addOne(test);
                
		System.out.print("Result is " );
		for (int i = 0; i < result1.length; i++)
			System.out.print(result1[i]);
                
                System.out.print("\n\nResult is " );
		for (int i = 0; i < result2.length; i++)
			System.out.print(result2[i]);
                
                System.out.println("");
	}

}
