package concurrency;

public class AGV implements Runnable {
    private final int id;
    private final ChargingStation station;

    public AGV(int id, ChargingStation station) {
        this.id = id;
        this.station = station;
    }

    @Override
    public void run() {
        try {
            System.out.println("AGV " + id + " arrived at the station.");
            station.chargeAGV(this);
        } catch (InterruptedException e) {
            System.out.println("AGV " + id + " interrupted while waiting.");
        }
    }

    public int getId() {
        return id;
    }
}
