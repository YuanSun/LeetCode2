package addOne;

public class AddOne {
	protected int[] number;
	
	public AddOne(int[] number) {
		this.number = number;
	}
	
	public int[] Result() {
		boolean overflow = false;
		int numberOfNine = 0;
		int digitIndex = 0;
		while(digitIndex < number.length) {
			if(number[digitIndex] == 9) {
				numberOfNine ++;
			} else
				break;
			digitIndex++;
		}
		
		if(numberOfNine == number.length) 
			overflow = true;
		
		int[] result = overflow? new int[number.length + 1] : new int[number.length];
		
		if(overflow) {
			result[0] = 1;
			for (int i = 1; i < result.length; i++)
				result[i] = 0;
		} else {// no overflow
			int sum = 0;
			int carry = 0;
			for (int i = number.length - 1; i >= 0; i--) {
				if (i == number.length - 1)
					sum = number[i] + 1;
				else {
					sum = number[i] + carry;
					carry = 0; // remove carry
				}
				if (sum >= 10) {
					carry = 1;
					sum = sum % 10;
				}
				result[i] = sum;
			}
		}
		
		return result;
	}
        
        public static int[] addOne(int[] operand) {
            if(operand.length == 0)
                return null;
            boolean overflow = false;
            int sum, carry = 0;
            int length = operand.length;
            
            for (int i = length - 1; i >= 0; i--) {
               if(i == length - 1) {// LSB -> + 1
                   sum = operand[i] + 1;
                   if(sum > 9)
                       carry = 1;
               } else {
                   sum = operand[i] + carry;
                   carry = 0;
                   if(sum > 9)
                       carry = 1;
               }
               sum = sum % 10;
               operand[i] = sum;
            }// end for loop
            
            if(carry == 1)
                overflow = true;
            
            // construct result 
            int[] result = overflow ? new int[length + 1] : new int[length];
            
            if(overflow){
                result[0] = 1;
                for(int i = 1; i <= length; i++)
                    result[i] = operand[i - 1];
            } else {
                for (int i = 0; i < length; i++)
                    result[i] = operand[i];
            }
            
            return result;
        }
}
