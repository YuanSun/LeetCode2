package producer_and_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Buffer sharedLocation = new BlockingBuffer();
		
		System.out.printf(
				"Action\t\tValue\tSum of Produced\tSum of Consumed%n");
		
		System.out.printf(
				"------\t\t-----\t---------------\t---------------%n%n");
		
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	}
}
