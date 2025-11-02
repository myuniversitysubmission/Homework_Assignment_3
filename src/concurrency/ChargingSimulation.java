package concurrency;

import java.util.Random;

public class ChargingSimulation {
    public static void main(String[] args) {
        ChargingStation station = new ChargingStation(3); // 3 charging spots
        Random random = new Random();

        // Create and start 10 AGVs
        for (int i = 1; i <= 10; i++) {
            AGV agv = new AGV(i, station);
            Thread thread = new Thread(agv);
            thread.start();

            // Random arrival delay between AGVs
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
