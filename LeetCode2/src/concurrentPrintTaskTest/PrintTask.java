package concurrentPrintTaskTest;

import java.security.SecureRandom;

public class PrintTask implements Runnable{
    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime; // random sleep time for thread
    private final String taskName;
    
    public PrintTask(String taskName) {
        this.taskName = taskName;
        
        //pick random sleep time between 0 and 5 sec
        sleepTime = generator.nextInt(5000);
    }
    
    // method run contains the code that a thread will execute
    public void run() {
        try { // put thread to sleep for sleepTime amount of time
            System.out.printf("%s going to sleep for %d milliseconds.%n", 
                    taskName, sleepTime);
            Thread.sleep(sleepTime);// put thread to sleep
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            Thread.currentThread().interrupt();// re-interrupt the thread
        }
        
        System.out.printf("%s done sleeping%n", taskName);
    }
}
