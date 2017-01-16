package primeNumber;

public class PrimeNumber {
	public static boolean isPrimeNumber(int num) {
		if (num == 1)
			return false;
		
		if (num == 2)
			return true;
		
		return isPrime(num, 2);
		
	}

	private static boolean isPrime(int num, int i) {
		if(num == i)
			return true;
		
		if (num % i == 0)
			return false;		
		
		return isPrime(num, i+1);
	}
}
