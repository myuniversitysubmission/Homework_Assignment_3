package concurrency;

public class Task implements Runnable {
    private final int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task " + id + " started by " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000 + (int)(Math.random() * 2000)); // simulate task duration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + id + " completed by " + Thread.currentThread().getName());
    }
}
