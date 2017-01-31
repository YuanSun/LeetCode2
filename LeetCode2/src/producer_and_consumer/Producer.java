package producer_and_consumer;

import java.security.SecureRandom;

public class Producer implements Runnable{
	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation; 
	
	public Producer(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	
	public void run() {
		int sum = 0;
		
		for (int count = 1; count <= 10; count++) {
			try { // sleep 0 to 3 s, then place value in Buffer
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.blockingPut(count);
				sum += count;
				System.out.printf("\t%2d%n", sum);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.printf("Producer done producing%nTerminating Producer%n");
	}
}
