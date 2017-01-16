package primeNumber;

public class PrimeNumberTest {

	public static void main(String[] args) {
		boolean isPrime = false;
		int aNumber = 5;
		
		for (int i = 1; i <= 100; i++) {
			isPrime = PrimeNumber.isPrimeNumber(i);
			
			if(isPrime)
				System.out.println(i + " is a prime number.");
//			else
//				System.out.println(i + " is not a prime number.");
		}
	}

}
