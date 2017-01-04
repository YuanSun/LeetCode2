package addOne;

public class Multiplier extends Adder{

	public Multiplier(int[] operand1, int[] operand2) throws myException {
		super(operand1, operand2);
	}
	
	public int[] multiplyTwoNumber (int[] operand1, int[]operand2) {
		int operand2Int = convertToInt(operand2);
		int[] result = new int[operand1.length + operand2.length]; 
		for (int i = 0; i < operand2Int; i++) {
			
		}
		return result;
	}

	/**
	 *
	 * @param operand
	 * @return
	 */
	private int convertToInt(int[] operand) {
		int operandInt = 0;
		for (int i = 0; i < operand.length; i++) {
			operandInt = operandInt + operand[i] * (int) Math.pow(10, i);
		}
		return operandInt;
	}
	
}
