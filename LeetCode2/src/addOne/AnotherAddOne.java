package addOne;

public class AnotherAddOne extends AddOne{

	public AnotherAddOne(int[] number) {
		super(number);
	}
	
	public int[] Calculate() {
		int number = 0;
		for (int i = 0; i < this.number.length; i++) {
			number = number + this.number[i] * (int) Math.pow(10, i);
		}
		number ++;
		
		int length = 0;
		int number_copy = number;
		while(number > 0) {
			length ++;
			number /= 10;
		}
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[length - 1 - i] = (int) (number_copy % Math.pow(10, length - 1 - i));
			number_copy /= 10;
		}
		return result;
	}

}
