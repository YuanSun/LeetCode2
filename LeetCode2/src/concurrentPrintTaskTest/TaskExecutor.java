package concurrentPrintTaskTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
    public static void main(String... args) {
        PrintTask task1 = new PrintTask("task1");
        PrintTask task2 = new PrintTask("task2");
        PrintTask task3 = new PrintTask("task3");
        
        System.out.println("Starting executor");
        
        // create ExecutorService to manage threads
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        
        // shut down ExecutorService -- it desides when to shut down threads
        executorService.shutdown();
        
        System.out.printf("Tasks started, main ends.%n%n");
    }
}
