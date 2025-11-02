package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskSimulation {
    public static void main(String[] args) {
        int totalTasks = 8;
        int availableAGVs = 3;

        ExecutorService executor = Executors.newFixedThreadPool(availableAGVs);

        for (int i = 1; i <= totalTasks; i++) {
            Task task = new Task(i);
            executor.submit(task);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAll tasks have been completed.");
    }
}
