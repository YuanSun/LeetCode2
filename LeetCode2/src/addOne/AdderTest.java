package addOne;

public class AdderTest {

	public static void main(String[] args) throws myException {
		int[] operand1 = {9, 9};
		int[] operand2 = {9, 0, 9};
		Adder theAdder = new Adder(operand1, operand2);
		int[] result = theAdder.addTwoNumber();
		
		System.out.print("Result is " );
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i]);
	}

}
