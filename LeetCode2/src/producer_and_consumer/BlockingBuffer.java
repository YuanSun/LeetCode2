package producer_and_consumer;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer {
    private final ArrayBlockingQueue<Integer> buffer;
    
    public BlockingBuffer() {
        buffer = new ArrayBlockingQueue<Integer>(1);
    }

    @Override
    public void blockingPut(int value) throws InterruptedException {
        buffer.put(value);
        System.out.printf("%s%2d\t", "Produce writes ", value);
    }

    @Override
    public int blockingGet() throws InterruptedException {
        int readValue = buffer.take();
        System.out.printf("%s%2d\t", "Consumer reads ", readValue);
        
        return readValue;
    }
}
