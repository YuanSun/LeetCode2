package addOne;

public class Adder {
	private int[] operand1;
	private int[] operand2;
	
	public Adder(int[] operand1, int[] operand2) throws myException {
		validateInput(operand1, operand2);
		
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	private void validateInput(int[] operand1, int[] operand2) throws myException {
		for (int i = 0; i < operand1.length; i++) {
			if (operand1[i] > 9)  {
				throw new myException("operand1 is invalid!!");
			}
				
		}
		
		for (int i = 0; i < operand2.length; i++) {
			if (operand2[i] > 9)
				throw new myException("operand2 is invalide!!");
		}
	}

	public int[] addTwoNumber() {
		int carry = 0, sum = 0;
		final boolean oneLongerThenTwo = operand1.length > operand2.length? true : false;
		final boolean oneSameLengthOfTwo = operand1.length == operand2.length ? true : false;
		final boolean oneShorterThenTwo = !oneLongerThenTwo && !oneSameLengthOfTwo? true : false;
		int[] firstAttemptResult = operand1.length >= operand2.length? 
				new int[operand1.length] : new int[operand2.length];
		int digitsOfSmallNumber = operand1.length >= operand2.length? 
				operand2.length : operand1.length;	
		int digitsOfLargerNumber = operand1.length >= operand2.length? 
				operand1.length : operand2.length;
		operand1 = reverseOperand(operand1);
		operand2 = reverseOperand(operand2);
		
		for (int i = 0; i < digitsOfLargerNumber; i++) {
			if( i < digitsOfSmallNumber) {
				sum = operand1[i] + operand2[i] + carry;
				carry = 0; 
				if (sum >= 10) {
					carry = 1;
					sum = sum % 10;
				}
				firstAttemptResult[i] = sum;
			} else {
				if (oneLongerThenTwo) {
					sum = operand1[i] + carry;
					carry = 0;
					if(sum >= 10) {
						carry = 1;
						sum = sum % 10;
					}
				} else if(oneShorterThenTwo) {
					sum = operand2[i] + carry;
					carry = 0;
					if(sum >= 10) {
						carry = 1;
						sum = sum % 10;
					}
				}
				
				firstAttemptResult[i] = sum;
			}
		}
		
		if(carry != 0) {
			int[] result = new int[digitsOfLargerNumber + 1];
			for (int i = 0; i < digitsOfLargerNumber; i++)
				result[i] = firstAttemptResult[i];
			result[digitsOfLargerNumber] = carry;
			return reverseOperand(result);
		} else
			return reverseOperand(firstAttemptResult);
	}

	private int[] reverseOperand(int[] operand) {
		int[] num = new int[operand.length];
		for (int i = 0; i < operand.length; i++) {
			num[operand.length - i - 1] = operand[i];
		}
		return num;
	}
}
