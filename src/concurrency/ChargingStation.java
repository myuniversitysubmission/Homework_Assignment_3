package concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ChargingStation {
    private final Semaphore chargingSpots;

    public ChargingStation(int totalSpots) {
        this.chargingSpots = new Semaphore(totalSpots);
    }

    public void chargeAGV(AGV agv) throws InterruptedException {
        System.out.println("AGV " + agv.getId() + " is waiting to charge...");

        // Try to acquire a spot for up to 15 seconds (simulated waiting time)
        if (chargingSpots.tryAcquire(15, TimeUnit.SECONDS)) {
            System.out.println("AGV " + agv.getId() + " started charging.");
            Thread.sleep(3000); // Simulate charging time
            System.out.println("AGV " + agv.getId() + " finished charging and leaves the station.");
            chargingSpots.release();
        } else {
            System.out.println("AGV " + agv.getId() + " left due to long waiting time.");
        }
    }
}
